package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.EmpDao_won;
import kr.or.bit.dto.Emp;

public class RegisterOkService_won implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		
		try {
			Emp emp = new Emp();
			
			emp.setEname(request.getParameter("ename"));
			emp.setEmpno(Integer.parseInt(request.getParameter("empno")));
			
			String ename = request.getParameter("ename");
			String empno = request.getParameter("empno");
			String job = request.getParameter("job");
			String mgr = request.getParameter("mgr");
			String hiredate = request.getParameter("hiredate");
			String sal = request.getParameter("sal");
			String comm = request.getParameter("comm");
			String deptno = request.getParameter("deptno");
			
			EmpDao_won empdao = new EmpDao_won();
			empdao.insertEmp(emp)
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			
		}
		
		return null;
	}

}
