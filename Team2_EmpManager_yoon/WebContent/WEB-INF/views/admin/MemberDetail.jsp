<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <jsp:include page="/common/HeadTag.jsp"/>
    <link href="css/profileImageBox.css" rel="stylesheet">
    <style type="text/css">
        .form-radio {
            background-color: #e9ecef
        }
    </style>
</head>

<body id="page-top">
    <!-- Top -->
    <jsp:include page="/common/Top.jsp"></jsp:include>
    <div id="wrapper">
        <!-- Left Menu -->
        <jsp:include page="/common/Left.jsp"></jsp:include>

        <div id="content-wrapper">
            <!-- !! Content !! -->
 			<c:set var="emp" value="${requestScope.empdetail}"/>
            <div class="container-fluid">
                <div class="card mb-3">
                    <div class="card-header">
                        <i class="fas fa-user-tag"></i>
                        	회원 정보 [<b>${emp.ename } 님</b>]
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">
                                <div class="row">
                                    <div class="col-sm-12">
                                    <div class="uploadBox">
                                      
                                    <c:choose>
	                                    <c:when test ="${emp.imagefilename == null}">
	                                    	<c:set var="path" value="images/user.png"></c:set>
										</c:when>
                                    	<c:otherwise>
                                    		<c:set var="path" value="upload/${emp.imagefilename}"></c:set>
										</c:otherwise>
                                    </c:choose> 
                                     <img id="profileimg" class="profile" alt="Emp image" src="${path}">        
                                           </div>
                                        <form action="MemberList.do" method="post">
                                            <div class="form-group">
                                                <div class="form-row">
                                                    <div class="col-md-6">
                                                        <div class="form-label-group">
                                                            <input type="number" id="empno" name="empno" class="form-control" placeholder="No" required="required" autofocus="autofocus"
                                                            			readonly value="${emp.empno }">
                                                            <label for="empno">No</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-label-group">
                                                            <input type="text" id="ename" name="ename" class="form-control" placeholder="Name" required="required"
                                                            			readonly value="${emp.ename }">
                                                            <label for="ename">Name</label>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="form-row">
                                                    <div class="col-md-6">
                                                        <div class="form-label-group">
                                                            <input type="date" id="hiredate" name="hiredate" class="form-control" placeholder="Hire Date" required="required"
                                                            			readonly value="${emp.hiredate }">
	                                                        <label for="hiredate">Hire Date</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-label-group">
                                                            <input type="text" id="job" name="job" class="form-control" placeholder="Job" required="required"
                                                            			readonly value="${emp.job }">
                                                            <label for="job">Job</label>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="form-row">
                                                    <div class="col-md-6">
                                                        <div class="form-label-group">
                                                            <input type="number" id="deptno" name="deptno" class="form-control" placeholder="Dept No" required="required"
                                                            			readonly value="${emp.deptno }">
                                                            <label for="deptno">Dept No</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-label-group">
                                                        	<input type="number" id="mgr" name="mgr" class="form-control" placeholder="Manager" required="required"
                                                        				readonly value="${emp.mgr }">
                                                        	<label for="mgr">Manager</label>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="form-row">
                                                    <div class="col-md-6">
                                                        <div class="form-label-group">
                                                            <input type="number" id="sal" name="sal" class="form-control" placeholder="Sal" required="required"
                                                            			readonly value="${emp.sal }">
                                                            <label for="sal">Salary</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-label-group">
                                                            <input type="number" id="comm" name="comm" class="form-control" placeholder="Commission" required="required"
                                                           			 readonly value="${emp.comm }">
                                                            <label for="comm">Commission</label>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <input type="submit" class="btn btn-primary btn-block" value="Ok" onClick="MemberList.do">
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>