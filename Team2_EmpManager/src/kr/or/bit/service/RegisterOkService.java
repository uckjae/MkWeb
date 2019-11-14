package kr.or.bit.service;

import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.EmpDao;
import kr.or.bit.dto.Emp;

public class RegisterOkService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		try {
			int empno = Integer.parseInt(request.getParameter("empno"));
			String ename = request.getParameter("ename");
			String job = request.getParameter("job");
			int mgr = Integer.parseInt(request.getParameter("mgr"));
			int sal = Integer.parseInt(request.getParameter("sal"));
			int comm = Integer.parseInt(request.getParameter("comm"));
			int deptno = Integer.parseInt(request.getParameter("deptno"));
			Date hiredate= new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("hiredate"));

			EmpDao dao = new EmpDao();
			Emp emp = new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno);
			int result = dao.insertEmp(emp);

			String msg = "";
			String url = "";
			if (result>0) {
				msg = "등록 성공! 로그인 페이지로 이동합니다.";
				url = "Login.do";
			} else {
				msg = "등록 실패! 회원 가입 페이지로 재 이동합니다.";
				url = "Register.do";
			}

			request.setAttribute("board_msg", msg);
			request.setAttribute("board_url", url);

			forward.setPath("/common/redirect.jsp");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return forward;
	}

}
