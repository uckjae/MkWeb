<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <jsp:include page="/common/HeadTag.jsp"/>
    <style type="text/css">
    	select{
    		display: block;
	    	width: 100%;
	    	height: calc(1.5em + 0.75rem + 2px);
	    	padding: 0.375rem 0.75rem;
	    	font-size: 1rem;
	    	font-weight: 400;
	    	line-height: 1.5;
	    	color: #495057;
	    	background-color: #fff;
	    	background-clip: padding-box;
	    	border: 1px solid #ced4da;
	    	border-radius: 0.25rem;
	    	-webkit-transition: border-color 0.15s ease-in-out, -webkit-box-shadow 0.15s ease-in-out;
	    	transition: border-color 0.15s ease-in-out, -webkit-box-shadow 0.15s ease-in-out;
	    	transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
	    	transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out, -webkit-box-shadow 0.15s ease-in-out;
    	}
    </style>
    <script type="text/javascript">
	    $(function(){
	    	$.ajax({
	    		url:"GetDeptNos",
	    		dataType:"json",
	    		success:function(data){
	    			var dArray = [];
	    			dArray = data.deptno;
	    			
	    			for(var i=0; i<dArray.length;i++){
	    				var option = document.createElement("option");
	    				$(option).text(dArray[i]);
	    				$("#deptSelect").append(option);
	    			}
	    		}
	    	});
	    	
	    	$.ajax({
	    		url:"GetEmpnos",
	    		dataType:"json",
	    		success:function(data){
	    			$.each(data, function(index, element){
	    				let option = $("<option></option>");
	    				$(option).text(element.empno+" : "+element.ename);
	    				$(option).val(element.empno);
	    				$("#mgrSelect").append(option);
	    			})
	    		}
	    	});
	    	
	    	$("#empnoCheck").click(function(){
	    		if($("#empno").val() == "" || $("#empno").val() == null){
	    			alert("EMPNO 입력하세요");
	    			$("#empno").focus();
	    		}else{
	    			$.ajax({
	    				url:"ec",
	    				data:{empno:$("#empno").val()},
	    				dataType: "html",
	    				success:function(responsedata){
	    					console.log(">"+responsedata+"<");
	    					if(responsedata == "true"){
	    						alert("사용가능");
	    						$("#ename").focuse();
	    					}else{
	    						alert("중복된 사원번호입니다");
	    						$("#empno").focus();
	    					}
	    				},
	    				error:function(){
	    					
	    				}
	    			});
	    		}
	    	});
	    })
    </script>
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
                                                            <input type="number" id="empno" name="empno" class="form-control" placeholder="No" required="required" autofocus="autofocus">
                                                            <label for="empno">No</label>
                                                            <button id="empnoCheck">중복확인</button>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-label-group">
                                                            <input type="text" id="ename" name="ename" class="form-control" placeholder="Name" required="required">
                                                            <label for="ename">Name</label>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="form-row">
                                                    <div class="col-md-6">
                                                        <div class="form-label-group">
                                                            <input type="date" id="hiredate" name="hiredate" class="form-control" placeholder="Hire Date" required="required">
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
                                                        Dept No 
                                                            <select id="deptSelect" name="deptno" style="height : 49px">
                                                            	<option hidden>부서번호 선택</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-label-group">
                                                        Manager 
                                                        	<select id="mgrSelect" name="mgr" style="height : 49px">
                                                            	<option hidden >Manager 선택</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="form-row">
                                                    <div class="col-md-6">
                                                        <div class="form-label-group">
                                                            <input type="number" id="sal" name="sal" class="form-control" placeholder="Sal" required="required">
                                                            <label for="sal">Salary</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="form-label-group">
                                                            <input type="number" id="comm" name="comm" class="form-control" placeholder="Commission" required="required">
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