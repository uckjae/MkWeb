package kr.or.bit.service;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.EmpDao;

public class MemberDeleteService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		System.out.println("리퀘스트 empno: " + request.getParameter("emp.empno"));
		int empno = Integer.parseInt(request.getParameter("empno"));
		System.out.println(empno);
		EmpDao dao = new EmpDao();
		int row = dao.deleteEmpByEmpno(empno);		
		String url = "";
		if(row > 0){
			url="/WEB-INF/views/admin/MemberList.jsp";
		} 
		System.out.println("row: "+ row);	
		//request.setAttribute("url", url);		
		forward.setRedirect(false);
		forward.setPath(url);
		System.out.println("포워드: " + forward);
		return forward;
	}
}
