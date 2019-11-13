package kr.or.bit.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.EmpDao;
import kr.or.bit.dto.Emp;

public class MemberEditService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward forward = null;
		String no = request.getParameter("empno");
		String name = request.getParameter("ename");
		String job = request.getParameter("job");
		String mgr = request.getParameter("mgr");
		String date = request.getParameter("hiredate");
		String sal = request.getParameter("sal");
		String comm = request.getParameter("comm");
		String dept = request.getParameter("deptno");
		
		if(no == null || no.trim().equals("")) {
			try {
				EmpDao empdao = new EmpDao();
				List<Emp> emplist = empdao.getEmps();
				request.setAttribute("emplist", emplist);
				
				forward = new ActionForward();
				forward.setRedirect(false); //forward 방식
			  	forward.setPath("/WEB-INF/views/admin/MemberEdit.jsp");
	
		
		
		  	
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			
		}
		
	}
		return forward;
}
}
