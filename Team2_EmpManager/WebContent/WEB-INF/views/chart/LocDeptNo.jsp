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
<script type="text/javascript">
$(function(){
	
	$.ajax(
			{
				//http://192.168.0.3:8090/WebServlet_4_memo_mvc/MemoId
				url:"LocCount.do",
				data:data:{cmd: "chart"},
				dataType:"json"	,
				success:function(data) {
					let city = [];
					let count = [];
					$.each(data,function(index,element)){
						city.push()
						count.push()
					}
				}
				
				
				}
					);
	
});
	
function chart () {
		Highcharts.chart('container', {
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
		            name: 'Chrome',
		            y: 7,
		            sliced: true,
		            selected: true
		        }, {
		            name: 'Internet Explorer',
		            y: 4
		        }, {
		            name: 'Firefox',
		            y: 3
		        }, {
		            name: 'Edge',
		            y: 2
		        }]
		    }]
		});
	
}
</script>
<title>Insert title here</title>
</head>
<body id="page-top">
    <!-- Top -->
    <jsp:include page="/common/Top.jsp"></jsp:include>
   
        <!-- Left Menu -->
        <jsp:include page="/common/Left.jsp"></jsp:include>

      

            <!-- Content -->
	            
       <div id="container" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto">
       
       </div>
           
                
             
            <!-- Bottom -->
            <jsp:include page="/common/Bottom.jsp"></jsp:include>

</body>
</html>