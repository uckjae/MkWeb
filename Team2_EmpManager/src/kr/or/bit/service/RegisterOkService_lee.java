package kr.or.bit.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.utils.DBHelper;

public class RegisterOkService_lee implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			int empno = Integer.parseInt(request.getParameter("empno"));
			String ename = request.getParameter("ename");
			SimpleDateFormat transformat = new SimpleDateFormat("yy/MM/dd");
			String date = request.getParameter("hiredate");
			Date hiredate;
			hiredate = (Date) transformat.parse(date);
			
			String job = request.getParameter("job");
			int deptno = Integer.parseInt(request.getParameter("deptno"));
			int mgr = Integer.parseInt(request.getParameter("mgr"));
			int sal = Integer.parseInt(request.getParameter("sal"));
			int comm = Integer.parseInt(request.getParameter("comm"));
			
			
			conn = DBHelper.getConnection("oracle");
			String sql = "insert into EMP (empno,ename,hiredate,job,deptno,mgr,sal,comm) values(?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empno);
			pstmt.setString(2, ename);
			pstmt.setDate(3, hiredate);
			pstmt.setString(4, job);
			pstmt.setInt(5, deptno);
			pstmt.setInt(6, mgr);
			pstmt.setInt(7, sal);
			pstmt.setInt(8, comm);
			
		}catch(Exception e) {
			
		}finally {
			
		}
		
		return null;
	}

}
