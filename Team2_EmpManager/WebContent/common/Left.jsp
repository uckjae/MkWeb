<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%
	boolean isLogin=false;
	boolean isAdmin=false;
	if(session.getAttribute("userid")!=null ){
		isLogin=true;
		if(session.getAttribute("userid").equals("admin"))
			isAdmin = true ;
	}
%>
<!DOCTYPE html>
<html>
<body>
    <!-- Sidebar -->
    <ul class="sidebar navbar-nav">
        <li class="nav-item active">
            <a class="nav-link" href="index.jsp">
                <i class="fas fa-home"></i>
                <span>Main</span>
            </a>
        </li>
        <%if(isLogin){ %>
        <li class="nav-item">
            <a class="nav-link" data-toggle="modal" data-target="#logoutModal">
                <i class="fas fa-sign-out-alt"></i>
                <span>Logout</span>
             </a>
        </li>
        <%} else{%>
         <li class="nav-item">
            <a class="nav-link" href="Login.do">
                <i class="fas fa-sign-in-alt"></i>
                <span>Login</span></a>
        </li>
         <li class="nav-item">
            <a class="nav-link" href="Register.do">
                <i class="fas fa-user-friends"></i>
                <span>Register</span></a>
        </li>
        <%}%>
        <%if(isAdmin){%>
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown"
                aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-user-shield"></i>
                <span>Admin</span>
            </a>
            <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                <!-- <h6 class="dropdown-header">Login Screens:</h6> -->
                <a class="dropdown-item" href="MemberList.do">Member</a>
            </div>
        </li>
        <%}%>
    </ul>
    
    <!-- Logout Modal-->
     <jsp:include page="/WEB-INF/views/modal/LogoutModal.jsp"/> 
</body>
</html>