<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <jsp:include page="/common/HeadTag.jsp"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://www.chartjs.org/dist/2.9.2/Chart.min.js"></script>
	<script src="https://www.chartjs.org/samples/latest/utils.js"></script>
	<style>
canvas {
	-moz-user-select: none;
	-webkit-user-select: none;
	-ms-user-select: none;
}

p {
	font-size: xx-large;
	font-weight: 700;
}
</style>
<script type="text/javascript">
$(function() {
	//초기에 select 반영하기 위해
	ajax($("#countOption option:selected").val());
	
	$("#countOption").change(function(){
		let countOption=$("#countOption option:selected").val();
		ajax(countOption);
	});
})

function ajax(conOption){
	 $.ajax({
		 url:"SalaryRanking_Choi.do",
		 data:{cmd:"chart",count:countOPtion},
	     dataType:"json",
		 success: function(data){
			 console.log('success');
			 console.log(typeof(data));
			 
		 }
	 });
}

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
            <div class="row">
	             <p >직군별 임금 그래프 </p>
            </div>
           
                <canvas id="canvas"></canvas>
            </div>
            
            <!-- Bottom -->
            <jsp:include page="/common/Bottom.jsp"></jsp:include>
        </div>
    </div>
</body>
</html>