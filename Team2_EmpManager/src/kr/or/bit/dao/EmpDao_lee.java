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

public class EmpDao_lee {
	public int insertEmp(Emp emp) {
		Connection conn = null;
		System.out.println("done");
		PreparedStatement pstmt = null;
		int resultrow = 0;
		try {
			
			
			
			conn = DBHelper.getConnection("oracle");
			String sql = "insert into EMP (empno,ename,hiredate,job,deptno,mgr,sal,comm) values(?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, emp.getEmpno());
			pstmt.setString(2,emp.getEname());
			pstmt.setDate(3,(java.sql.Date)emp.getHiredate());
			pstmt.setString(4, emp.getJob());
			pstmt.setInt(5, emp.getDeptno());
			pstmt.setInt(6, emp.getMgr());
			pstmt.setInt(7, emp.getSal());
			pstmt.setInt(8, emp.getComm());
			resultrow = pstmt.executeUpdate();
			
		}catch(Exception e) {
			
		}finally {
			DBHelper.close(pstmt);
			DBHelper.close(conn);
			
		}
		return resultrow;
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
		String sql = "select empno, ename, hiredate from emp";
		
		ArrayList<Emp> emplist = new ArrayList<Emp>();
		try {
		pstmt = connection.prepareStatement(sql);
		resultSet = pstmt.executeQuery();
		
		while(resultSet.next()) {
			Emp emp = new Emp();
			emp.setEmpno(resultSet.getInt("empno"));
			emp.setEname(resultSet.getString("ename"));
			emp.setHiredate(resultSet.getDate("hiredate"));
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
	
	public int getEdit(HttpServletRequest emp) {
		
		String no = emp.getParameter("empno");
		String name = emp.getParameter("ename");
		String job = emp.getParameter("job");
		String mgr = emp.getParameter("mgr");
		String date = emp.getParameter("date");
		String sal = emp.getParameter("sal");
		String comm = emp.getParameter("comm");
		String dept = emp.getParameter("deptno");
		
		System.out.println(no +" , " + name +" , " + job +" , " + mgr +" , " + date +" , " + sal +" , " + comm +" , " + dept);
		
		Connection connection = DBHelper.getConnection("oracle"); //객체 얻기
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		int row = 0;
		String sql = "select empno, ename, job, hiredate, sal, comm, deptno, imagefilename from emp where ename=?";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1,name);
			resultSet = pstmt.executeQuery();
			
			while(resultSet.next()) {
			
				
				row = pstmt.executeUpdate();
			}
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}finally {
				DBHelper.close(resultSet);
				DBHelper.close(pstmt);
				DBHelper.close(connection);
			}
		return row;
			
		
		

	
	}
}
