package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.or.bit.dto.Emp;
import kr.or.bit.dto.chart.TotalSaleryChart;
import kr.or.bit.utils.DBHelper;

public class EmpDao {
	public int insertEmp(Emp emp) {
		int resultRow = 0;
		Connection connection = DBHelper.getConnection("oracle");
		PreparedStatement pstmt = null;

		String sql = "INSERT INTO EMP(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)"
				+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, emp.getEmpno());
			pstmt.setString(2, emp.getEname());
			pstmt.setString(3, emp.getJob());
			pstmt.setInt(4, emp.getMgr());
			pstmt.setDate(5, new Date(emp.getHiredate().getTime()));
			pstmt.setInt(6, emp.getSal());
			pstmt.setInt(7, emp.getComm());
			pstmt.setInt(8, emp.getDeptno());

			resultRow = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			DBHelper.close(pstmt);
			DBHelper.close(connection);
		}

		return resultRow;
	}

	public Emp getEmpByEmpno(int no) {
		Emp emp = null;

		Connection connection = DBHelper.getConnection("oracle");
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;

		String sql = "SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO" + " FROM EMP WHERE EMPNO=?";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, no);
			resultSet = pstmt.executeQuery();
			if (resultSet.next()) {
				int empno = resultSet.getInt(1);
				String ename = resultSet.getString(2);
				String job = resultSet.getString(3);
				int mgr = resultSet.getInt(4);
				Date hiredate = resultSet.getDate(5);
				int sal = resultSet.getInt(6);
				int comm = resultSet.getInt(7);
				int deptno = resultSet.getInt(8);

				emp = new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return emp;
	}

	public boolean checkAdminLogin(String userid, String pwd) {
		boolean result = false;

		Connection connection = DBHelper.getConnection("oracle");
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;

		String sql = "SELECT USERID, PWD FROM ADMINLIST WHERE USERID=?";

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, userid);
			resultSet = pstmt.executeQuery();

			if (resultSet.next() && resultSet.getString("PWD").equals(pwd))
				result = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			DBHelper.close(pstmt);
			DBHelper.close(resultSet);
			DBHelper.close(connection);
		}

		return result;
	}

	public List<Emp> getEmps() {
		List<Emp> emps = new ArrayList<Emp>();

		Connection connection = DBHelper.getConnection("oracle");
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;

		String sql = "SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO" + " FROM EMP";

		try {
			pstmt = connection.prepareStatement(sql);
			resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				int empno = resultSet.getInt(1);
				String ename = resultSet.getString(2);
				String job = resultSet.getString(3);
				int mgr = resultSet.getInt(4);
				Date hiredate = resultSet.getDate(5);
				int sal = resultSet.getInt(6);
				int comm = resultSet.getInt(7);
				int deptno = resultSet.getInt(8);

				emps.add(new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			DBHelper.close(pstmt);
			DBHelper.close(resultSet);
			DBHelper.close(connection);
		}

		return emps;
	}

	public int deleteEmpByEmpno(int empno) {
		int resultRow = 0;
		Connection connection = DBHelper.getConnection("oracle");
		PreparedStatement pstmt = null;

		String sql = "DELETE FROM EMP WHERE EMPNO = ?";

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, empno);

			resultRow = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			DBHelper.close(pstmt);
			DBHelper.close(connection);
		}

		return resultRow;
	}

	public int updateEmp(Emp emp) {
		int resultRow = 0;
		Connection connection = DBHelper.getConnection("oracle");
		PreparedStatement pstmt = null;

		String sql = "UPDATE EMP SET ENAME=?, JOB=?, MGR=?, HIREDATE=?, SAL=?, COMM=?, DEPTNO=? " + " WHERE EMPNO=?";

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, emp.getEname());
			pstmt.setString(2, emp.getJob());
			pstmt.setInt(3, emp.getMgr());
			pstmt.setDate(4, new Date(emp.getHiredate().getTime()));
			pstmt.setInt(5, emp.getSal());
			pstmt.setInt(6, emp.getComm());
			pstmt.setInt(7, emp.getDeptno());
			pstmt.setInt(8, emp.getEmpno());

			resultRow = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			DBHelper.close(pstmt);
			DBHelper.close(connection);
		}

		return resultRow;
	}

	public List<TotalSaleryChart> ChartDataByTotalSalery(int count) {
		List<TotalSaleryChart> results = new ArrayList<TotalSaleryChart>();
		Connection connection = DBHelper.getConnection("oracle");
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;

		String sql = "SELECT ENAME, totalSal" + "  FROM (SELECT ENAME, SAL+NVL(COMM,0) AS totalSal"
				+ "           FROM EMP ORDER BY totalSal DESC)" + "WHERE ROWNUM <= ?";

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, count);
			resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				results.add(new TotalSaleryChart(resultSet.getString(1), resultSet.getInt(2)));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			DBHelper.close(pstmt);
			DBHelper.close(connection);
		}

		return results;
	}
}