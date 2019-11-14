package kr.or.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.*;
import kr.or.bit.service.*;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url_Command = requestURI.substring(contextPath.length());
		System.out.println("3 : " + url_Command);
		ActionForward forward = null;
		Action action = null;

		// Login 화면
		if (url_Command.equals("/Login.do")) {
			forward = new ActionForward();
			forward.setPath("/WEB-INF/views/login/Login.jsp");
		} 
		// Login 진행
		else if (url_Command.equals("/LoginOk.do")) {
			action = new LoginService();
			forward = action.execute(request, response);
		} 
		// Register 화면
		else if (url_Command.equals("/Register.do")) {
			forward = new ActionForward();
			forward.setPath("/WEB-INF/views/register/Register.jsp");
		}
		// Register 진행
		else if (url_Command.equals("/RegisterOk.do")) {
			action = new RegisterOkService();
			forward = action.execute(request, response);
		}
		
		// MemberList 화면
		else if (url_Command.equals("/MemberList.do")) {
			action = new MemberListService();
			forward = action.execute(request, response);
		}
		// MemberDetail 화면
		else if (url_Command.equals("/MemberDetail.do")) {
			
		}
		// MemberEdit 화면
		else if (url_Command.equals("/MemberEdit.do")) {
			System.out.println("너 안들어가?");
			action = new MemberEditService();
			forward = action.execute(request, response);	
		}
		// MemberEdit 진행
		else if (url_Command.equals("/MemberEditOk.do")) {
			action = new MemberEditOkService();
			forward = action.execute(request, response);
		}
		// MemberDelete 진헹
		else if (url_Command.equals("/MemberDelete.do")) {
			System.out.println("삭제 비포");			
			action = new MemberDeleteService();
			forward = action.execute(request, response);
			System.out.println("삭제 애프터");
		}
		// Logout 진헹
		else if (url_Command.equals("/Logout.do")) {
			action = new LogoutService();
			forward = action.execute(request, response);
		}

		if (forward != null) {
			System.out.println("포워드가 null 값이 아니니?");
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
				dis.forward(request, response);
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}
}
