package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import kr.or.bit.dto.Emp;
import kr.or.bit.dto.chart.TotalSaleryChart;
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
	
	public Emp getEdit(int no) {
		
			Connection conn = DBHelper.getConnection("oracle");    
			PreparedStatement pstmt = null;
			ResultSet rs = null;
		      Emp emp = new Emp();
		      try {
		         String sql = "select empno,ename, job, mgr, hiredate, sal, deptno from Emp where empno=?";

		         pstmt = conn.prepareStatement(sql);
		         pstmt.setInt(1, no);
		         rs = pstmt.executeQuery();
		         if (rs.next()) {
		            emp.setEmpno(rs.getInt("empno"));
		            emp.setEname(rs.getString("ename"));
		            emp.setJob(rs.getString("job"));
		            emp.setMgr(rs.getInt("mgr"));
		            emp.setHiredate(rs.getDate("hiredate"));
		            emp.setSal(rs.getInt("sal"));
		            emp.setDeptno(rs.getInt("deptno"));
		            
		          
		         }
		      } catch (Exception e) {

		      } finally {
		         try {
					rs.close();
					pstmt.close();
			        conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		         
		      }
		      return emp;
		      }
	
	   public int getEditOk(Emp emp) throws SQLException {
		      Connection conn = null; 
			PreparedStatement pstmt = null;
		      int row = 0;
//		       

		      try {
		         conn = DBHelper.getConnection("oracle");
		         String sql = "update emp set ename=?, job=?,deptno=?,sal=?,mgr=?,empno=? where empno=?";
		         pstmt = conn.prepareStatement(sql);

		         pstmt.setString(1, emp.getEname());
		         pstmt.setString(2, emp.getJob());
		         pstmt.setInt(3, emp.getDeptno());
		         pstmt.setInt(4, emp.getSal());
		         pstmt.setInt(5, emp.getMgr());
		         pstmt.setInt(6, emp.getEmpno());
		         pstmt.setInt(7, emp.getEmpno());
		         row = pstmt.executeUpdate();

		      } catch (Exception e) {
		         System.out.println(e.getMessage());
		      } finally {
		         pstmt.close();
		         conn.close();
		      }
		      return row;
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

