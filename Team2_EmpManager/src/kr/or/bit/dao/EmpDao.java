package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
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
		
		Connection connection = DBHelper.getConnection("oracle"); //객체 얻기
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		int row = 0;
		String sql = "select empno, ename, job, hiredate, sal, comm, deptno, imagefilename from emp where ename=?";
		String sql_update = "update emp set empno=? , ename=? , job=?," 
				+ "sal=? ,comm =?,deptno = ? where idx=?";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1,name);
			resultSet = pstmt.executeQuery();
			
			while(resultSet.next()) {
				pstmt = connection.prepareStatement(sql_update);
				pstmt.setString(1,no);
				pstmt.setString(2, name);
				pstmt.setString(3, job);
				pstmt.setString(4, sal);
				pstmt.setString(5, comm);
				pstmt.setString(6, dept);
				pstmt.setString(7, no);
				
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
