<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <jsp:include page="/common/HeadTag.jsp"/>
</head>

<body id="page-top">
    <!-- Top -->
    <jsp:include page="/common/Top.jsp"></jsp:include>
    <div id="wrapper">
        <!-- Left Menu -->
        <jsp:include page="/common/Left.jsp"></jsp:include>

        <div id="content-wrapper">

            <!-- Content -->
            <div class="container-fluid">
                <div class="card mb-3">
                    <div class="card-header">
                        <i class="fas fa-user-plus"></i>
                        회원가입
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">
                                <div class="row">
                                    <div class="col-sm-12">
                                        <form action="RegisterOk.do" method="post">
                                            <div class="form-group">
                                                <div class="form-row">
                                                    <div class="col-md-6">
                                                        <div class="form-label-group">
                                                            <input type="text" id="name" name="name" class="form-control" placeholder="Name" required="required" autofocus="autofocus">
                                                            <label for="name">Name</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-label-group">
                                                            <input type="text" id="empno" name="empno" class="form-control" placeholder="Empno" required="required">
                                                            <label for="empno">Empno</label>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="form-row">
                                                    <div class="col-md-6">
                                                        <div class="form-label-group">
                                                            <input type="text" id="hiredate" name="hiredate" class="form-control" placeholder="Hire Date" required="required">
	                                                        <label for="hiredate">Hire Date</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-label-group">
                                                            <input type="text" id="job" name="job" class="form-control" placeholder="Job" required="required">
                                                            <label for="job">Job</label>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="form-row">
                                                    <div class="col-md-6">
                                                        <div class="form-label-group">
                                                            <input type="text" id="deptno" name="deptno" class="form-control" placeholder="Dept No" required="required">
                                                            <label for="deptno">Dept No</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-label-group">
                                                        	<input type="text" id="mgr" name="mgr" class="form-control" placeholder="Manager" required="required">
                                                        	<label for="mgr">Manager</label>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="form-row">
                                                    <div class="col-md-6">
                                                        <div class="form-label-group">
                                                            <input type="text" id="sal" name="sal" class="form-control" placeholder="Salary" required="required">
                                                            <label for="sal">Salary</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-label-group">
                                                            <input type="text" id="comm" name="comm" class="form-control" placeholder="Commission" required="required">
                                                            <label for="comm">Commission</label>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="form-row">
                                             	 <div class="col-md-6">
                                                    <input type="submit" class="btn btn-primary btn-block" value="Register">
                                                </div>
                                                <div class="col-md-6">
                                                    <input type="reset" class="btn btn-danger btn-block" value="Cancel">
                                                </div>
                                            </div>
                                        </form>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Bottom -->
            <jsp:include page="/common/Bottom.jsp"></jsp:include>
        </div>
    </div>
</body>

</html>