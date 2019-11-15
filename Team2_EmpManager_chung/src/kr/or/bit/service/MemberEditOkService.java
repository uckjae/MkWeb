package kr.or.bit.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.EmpDao;
import kr.or.bit.dto.Emp;

public class MemberEditOkService implements Action {

	@Override
	   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
	      ActionForward forward = null;
		  int size = 1024*1024*10;
			//	String uploadpath = request.getRealPath("upload");
		  		String imagefilename = "";
				ServletContext application = request.getServletContext();
			    String uploadpath  = application.getRealPath("upload"); //이미지 저장 실경로
				MultipartRequest multi  = null;
	      try {
				multi = new MultipartRequest(
						request, //기존에 있는  request 객체의 주소값 
						uploadpath, //실 저장 경로 (배포경로)
						size, //10M
						"UTF-8",
						new DefaultFileRenamePolicy() //파일 중복(upload 폴더 안에:a.jpg -> a_1.jpg(업로드 파일 변경) )
						);
	    	  
	         EmpDao dao = new EmpDao();
	         Emp emp = new Emp();
	         emp.setEmpno(Integer.parseInt(multi.getParameter("empno")));
	         emp.setEname(multi.getParameter("ename"));
	         emp.setJob(multi.getParameter("job"));
	         emp.setHiredate(new SimpleDateFormat("yyyy-MM-dd").parse(multi.getParameter("hiredate")));
	         emp.setMgr(Integer.parseInt(multi.getParameter("mgr")));
	         emp.setSal(Integer.parseInt(multi.getParameter("sal")));
	         emp.setComm(Integer.parseInt(multi.getParameter("comm")));
	         emp.setDeptno(Integer.parseInt(multi.getParameter("deptno")));
	         
	        Enumeration filenames = multi.getFileNames();
			String file2 = (String)filenames.nextElement();
			System.out.println(file2);
			imagefilename = multi.getFilesystemName(file2);
	         emp.setImagefilename(imagefilename);
	         int result = dao.updateEmp(emp);
	         
	         
	         	 forward = new ActionForward();
	         	 forward.setRedirect(false);
	             forward.setPath("/MemberList.do");
	             
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return forward;
	   }
}
