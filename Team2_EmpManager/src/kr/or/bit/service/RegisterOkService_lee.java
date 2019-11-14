package kr.or.bit.service;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.EmpDao_lee;
import kr.or.bit.dto.Emp;

public class RegisterOkService_lee implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		
		
		
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
			
			Emp emp = new Emp();
			emp.setEmpno(empno);
			emp.setEname(ename);
			emp.setHiredate(hiredate);
			emp.setJob(job);
			emp.setDeptno(deptno);
			emp.setMgr(mgr);
			emp.setSal(sal);
			emp.setComm(comm);
			
			EmpDao_lee dao = new EmpDao_lee();
			dao.insertEmp(emp);
			forward = new ActionForward();
			forward.setPath("/index.jsp");
									
		}catch(Exception e) {
			
		}finally {
			
		}
		
		return forward;
	}

}
