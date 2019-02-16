<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>æ é¢</title>
</head>
<body>
<div id="main" style="width: 600px;height: 600px"></div>
</body>
<script type="text/javascript" src="js/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="js/echarts.common.min.js"></script>
<script type="text/javascript">
window.onload = function(){
	$.ajax({
		url:"http://localhost:8080/Echarts/show.do",
		type:"get",
		success:function(data){
			console.log(data);
			var name = new Array();
			var value = new Array();
			
			for (var i = 0; i < data.length; i++) {
				name[i] = data[i].name;
				value[i] = data[i].value;
			}

			console.log(name);
			console.log(value);

			var myChart = echarts.init(document.getElementById("main"));
			var option={
					/* 标题 */
					title:{
					text:'Echart图表'	
					},
					/* 图例 */
					legend:{
						data:['销量']
					},
					/* x轴 */
					xAxis : {
						data:name
					},
					/* y轴 */
					yAxis : {
					},
					/* 数据源 */
					series : [{
						name: '销量',
						type:'bar',
						data :value
					}]
					/* tooltip:{
						trigger:'item',
						formatter:"{a}<br/>{b} : {c}({d}%)",
					},
					series:[{
						name:'数据来源:TEST',
						type:'pie',
						radius:'70%',
						data:data
					}] */
			};
			myChart.setOption(option);
		}
	});
	
	
}
</script>
</html>