<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/common/HeadTag.jsp"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<style type="text/css">
canvas {
	-moz-user-select: none;
	-webkit-user-select: none;
	-ms-user-select: none;
}
</style>
<script type="text/javascript">
$(function() {
	 $.ajax({
		url : "LocCount",
		data:{cmd: "chart"},
		dataType : "json",
		success : function(data){
			console.log("success");
			console.log(data);
			let counts = [];
			let citys = [];
			$.each(data, function(index, element){
				citys.push(element.Loc);
				counts.push(element.Count);
			})
			console.log(citys);
			console.log(counts);
			setchart(citys , counts);
		}
	}); 
	
function setchart(citys , counts){
	Highcharts.chart('test1', {
	    chart: {
	        plotBackgroundColor: null,
	        plotBorderWidth: null,
	        plotShadow: false,
	        type: 'pie'
	    },
	    title: {
	        text: 'Browser market shares in January, 2018'
	    },
	    tooltip: {
	        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
	    },
	    plotOptions: {
	        pie: {
	            allowPointSelect: true,
	            cursor: 'pointer',
	            dataLabels: {
	                enabled: false
	            },
	            showInLegend: true
	        }
	    },
	    series: [{
	        name: 'Brands',
	        colorByPoint: true,
	        data: [{
	            name: citys[0],
	            y: counts[0],
	            sliced: true,
	            selected: true
	        },{
	            name: citys[1],
	            y: counts[1]
	        },{
	            name: citys[2],
	            y: counts[2]
	        }]
	    }]
	});

 }
});
</script>
<title>Insert title here</title>
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
               <div id="test1" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div>

            </div>
            
            <!-- Bottom -->
            <jsp:include page="/common/Bottom.jsp"></jsp:include>
        </div>
    </div>
</body>
</html>