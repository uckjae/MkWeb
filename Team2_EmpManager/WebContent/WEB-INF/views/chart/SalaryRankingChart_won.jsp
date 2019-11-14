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
	</style>
	<script type="text/javascript">
		$(function() {
			$.ajax({
				url : "SalaryRanking_won.do",
				dataType : "json",
				success : function(data){
					console.log("success");
					console.log(typeof(data));
					let labels = [];
					let datas = [];
					$.each(data, function(index, element){
						labels.push(element.ename);
						datas.push(element.totalsal);
					})
					
					setChart(labels,datas);
				}
			});
		})
		
		function setChart(labels, datas){
			var barChartData = {
					labels: labels,
					datasets: [{
						label: 'Total Salery',
						backgroundColor: getAnotherChartColor(0),
						borderColor: getAnotherChartColor(0),
						borderWidth: 1,
						data: datas
					}]
				};
	
			window.myBar = new Chart( $('#canvas'), {
				type: 'bar',
				data: barChartData,
				options: {
					responsive: true,
					legend: {
						position: 'top',
					},
					title: {
						display: true,
						text: '상위 연봉 순위'
					}
				}
			});
		}
		
		let colorNames = Object.keys(window.chartColors);
		function getAnotherChartColor(dataLength){
			let colorName = colorNames[dataLength % colorNames.length];
			let dsColor = window.chartColors[colorName];
			return window.chartColors[colorName];
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
                <canvas id="canvas"></canvas>
            </div>
            
            <!-- Bottom -->
            <jsp:include page="/common/Bottom.jsp"></jsp:include>
        </div>
    </div>
</body>

</html>