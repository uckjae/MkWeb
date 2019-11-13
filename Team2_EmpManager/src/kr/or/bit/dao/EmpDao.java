package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import kr.or.bit.dto.Emp;
import kr.or.bit.utils.DBHelper;

public class EmpDao {
	public int insertEmp(Emp emp) {
		
		return 0;
	}

	public Emp getEmpByEmpno(int no) {
		


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
    public String getJob() {
        
        Connection conn = DBHelper.getConnection("oracle");
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        
        String sql = "select DISTINCT job from emp";
        try {
            
        }catch (Exception e) {

        }
        
        
        
        return null;
    }
}
