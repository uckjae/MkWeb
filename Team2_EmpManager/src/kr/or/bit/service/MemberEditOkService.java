package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.EmpDao;
import kr.or.bit.dto.Emp;

public class MemberEditOkService implements Action {

	@Override
	   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
	      ActionForward forward = null;
	      try {
  
	         EmpDao dao = new EmpDao();
	         Emp emp = new Emp();
	         emp.setEmpno(Integer.parseInt(request.getParameter("empno")));
	         emp.setEname(request.getParameter("ename"));
	         emp.setJob(request.getParameter("job"));
	         emp.setMgr(Integer.parseInt(request.getParameter("mgr")));
	         emp.setSal(Integer.parseInt(request.getParameter("sal")));
	         emp.setComm(Integer.parseInt(request.getParameter("comm")));
	         emp.setDeptno(Integer.parseInt(request.getParameter("deptno")));
	         
	         int result = dao.getEditOk(emp);
	         
	         if(result > 0 ) {

	         }else {

	         }
	         	 forward = new ActionForward();
	         	 forward.setRedirect(false);
	             forward.setPath("/WEB-INF/views/admin/MemberList.jsp");
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return forward;
	   }
}
