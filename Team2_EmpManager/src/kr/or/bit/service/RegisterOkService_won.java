package kr.or.bit.service;


import java.text.SimpleDateFormat;
import java.util.Date;

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
			String date = request.getParameter("hiredate");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date hiredate = sdf.parse(date);
			
			emp.setEname(request.getParameter("ename"));
			emp.setEmpno(Integer.parseInt(request.getParameter("empno")));
			emp.setJob(request.getParameter("job"));
			emp.setMgr(Integer.parseInt(request.getParameter("mgr")));
			emp.setHiredate(hiredate);
			emp.setSal(Integer.parseInt(request.getParameter("sal")));
			emp.setComm(Integer.parseInt(request.getParameter("comm")));
			emp.setDeptno(Integer.parseInt(request.getParameter("deptno")));;
			
			/*String ename = request.getParameter("ename");
			String empno = request.getParameter("empno");
			String job = request.getParameter("job");
			String mgr = request.getParameter("mgr");
			String hiredate = request.getParameter("hiredate");
			String sal = request.getParameter("sal");
			String comm = request.getParameter("comm");
			String deptno = request.getParameter("deptno");*/
			
			EmpDao_won empdao = new EmpDao_won();
			int result = empdao.insertEmp(emp);
			forward = new ActionForward();
			if (result > 0) {
				forward.setRedirect(false); // forward 방식
				forward.setPath("/WEB-INF/views/login/Login.jsp");
			} else { // -1 (제약, 컬럼길이 문제)
				forward.setRedirect(false); // forward 방식
				forward.setPath("/WEB-INF/views/register/register_won.jsp");
			}

		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			
		}
		
		return forward;
	}

}
