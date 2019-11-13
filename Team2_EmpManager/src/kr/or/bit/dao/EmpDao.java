package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.or.bit.dto.Emp;
import kr.or.bit.utils.DBHelper;

public class EmpDao {
	public int insertEmp(Emp emp) {
		
		return 0;
	}

	public Emp getEmpByEmpno(int no) {
		
		  return this.getEmpByEmpno(no);
		
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
		Connection conn = DBHelper.getConnection("oracle");
		PreparedStatement pstmt = null;
		int row = 0;
		
		String sql = "delete from emp where empno=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, empno);
			row = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		
	
		return  row;
	}

	public int updateEmp(Emp emp) {
		
		return 0;
	}
	
	public Emp getEdit(HttpServletRequest request) {
		try {
			String no = request.getParameter("empno");
			String ename = request.getParameter("ename");
			String job = request.getParameter("job");
			String mgr = request.getParameter("mgr");
			String date = request.getParameter("hiredate");
			String sal = request.getParameter("sal");
			String comm = request.getParameter("comm");
			String dept = request.getParameter("deptno");
			
			Connection conn = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			
			String sql = "select no from emp where=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			
			conn = DBHelper.getConnection("oracle");
			
			rs = pstmt.executeQuery();
			
			
		}catch (Exception e) {

		}
		
		
		
		return null;

	}
	
	
  
}
