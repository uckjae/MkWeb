package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import kr.or.bit.dto.Emp;
import kr.or.bit.utils.DBHelper;

public class EmpDao_won {
	public int insertEmp(Emp emp) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		int resultrow = 0;
		
		try {
			System.out.println("dao 타고");
			emp.toString();
			//"insert into memo(id,email,content) values(?,?,?)";
			connection = DBHelper.getConnection("oracle");
			String sql = "insert into Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno) value(?,?,?,?,?,?,?,?)";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, emp.getEmpno());
			pstmt.setString(2, emp.getEname());
			pstmt.setString(3, emp.getJob());
			pstmt.setInt(4, emp.getMgr());
			pstmt.setDate(5, (Date)emp.getHiredate());
			pstmt.setInt(6, emp.getSal());
			pstmt.setInt(7, emp.getComm());
			pstmt.setInt(8, emp.getDeptno());
			
			resultrow = pstmt.executeUpdate();
		}catch (Exception e) {
			System.out.println("dao 에서 익셉션");
		}finally {
			DBHelper.close(pstmt);
			DBHelper.close(connection);
		}
		
		return resultrow;
	}

	public Emp getEmpByEmpno(int no) {
		Connection connection = DBHelper.getConnection("oracle");
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		
		String sql = "Select empno from emp where empno=?";
		
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, no);
			resultSet = pstmt.executeQuery();
		}catch (Exception e) {

		}

		return null;
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
		Connection connection = DBHelper.getConnection("oracle"); //객체 얻기
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		String sql = "select empno, ename, job, mgr, hiredate, sal, comm, deptno, imagefilename from emp";
		
		ArrayList<Emp> emplist = new ArrayList<Emp>();
		try {
		pstmt = connection.prepareStatement(sql);
		resultSet = pstmt.executeQuery();
		
		while(resultSet.next()) {
			Emp emp = new Emp();
			emp.setEmpno(resultSet.getInt("empno"));
			emp.setEname(resultSet.getString("ename"));
			emp.setJob(resultSet.getString("job"));
			emp.setMgr(resultSet.getInt("mgr"));
			emp.setHiredate(resultSet.getDate("hiredate"));
			emp.setSal(resultSet.getInt("sal"));
			emp.setComm(resultSet.getInt("comm"));
			emp.setDeptno(resultSet.getInt("deptno"));
			emplist.add(emp);
		}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			DBHelper.close(resultSet);
			DBHelper.close(pstmt);
			DBHelper.close(connection);
		}
		return emplist;
	}

	public int deleteEmpByEmpno(int empno) {
		
		return  0;
	}

	public int updateEmp(Emp emp) {
		
		return 0;
	}
  
}
