package kr.or.bit.service;

import java.util.Date;
import java.io.File;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.EmpDao;
import kr.or.bit.dto.Emp;

public class RegisterOkService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		String uploadpath = request.getSession().getServletContext().getRealPath("/upload");

		int size = 1024 * 1024 * 10;

		try {
			MultipartRequest multi = new MultipartRequest(request, // 기전에 있는 request 객체의 주소값
					uploadpath, // 실 저장 경로 (배포경로)
					size, // 10M
					"UTF-8",
					new DefaultFileRenamePolicy()
					// 파일 중복(upload 폴더 안에:a.jpg -> a_1.jpg(업로드 파일 변경) )
			); // 파일 업로드 완료

			String fileName = multi.getFilesystemName("fileinput");
			int empno = Integer.parseInt(multi.getParameter("empno"));

			File oldFile = new File(uploadpath + File.separator + fileName);
			File newFile = new File(uploadpath + File.separator + empno + "." + fileName.split("\\.")[1]);

			if (newFile.exists())
				newFile.delete();

			oldFile.renameTo(newFile);

			String ename = multi.getParameter("ename");
			String job = multi.getParameter("job");
			int mgr = Integer.parseInt(multi.getParameter("mgr"));
			int sal = Integer.parseInt(multi.getParameter("sal"));
			int comm = Integer.parseInt(multi.getParameter("comm"));
			int deptno = Integer.parseInt(multi.getParameter("deptno"));
			Date hiredate = new SimpleDateFormat("yyyy-MM-dd").parse(multi.getParameter("hiredate"));
			EmpDao dao = new EmpDao();
			Emp emp = new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno, newFile.getName());
			int result = dao.insertEmp(emp);

			String msg = "";
			String url = "";
			if (result > 0) {
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
