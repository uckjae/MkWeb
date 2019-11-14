package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.EmpDao;
import kr.or.bit.dto.Emp;

public class MemberEditService implements Action {
	   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		      ActionForward forward = new ActionForward();
		      EmpDao dao = new EmpDao();   
		      Emp emp = new Emp();
		      int no = Integer.parseInt(request.getParameter("empno"));
	    	  emp = dao.getEdit(no);
	    	  if(no == 0) {
	    		  System.out.println("여긴?");
	    	  }
		      
		      	
		      
		     
		      try {  	  
		    	
		             request.setAttribute("emp",emp);
		             forward.setRedirect(false);
		             forward.setPath("/WEB-INF/views/admin/MemberEdit.jsp");
		             
		      } catch (Exception e) {
		         System.out.println("edit : " + e.getMessage());
		      }
		      return forward;
		   }

}
