package kr.or.bit.service;

import java.io.IOException;

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
		try {
			String no = request.getParameter("empno");
			if(no == null || no.trim().equals("")) {
				
					response.sendRedirect("MemberEdit.jsp");
					EmpDao dao = new EmpDao();
			}
		}catch (Exception e) {
			
		}
		
		
		
		
		
		
		return null;
	}
}
