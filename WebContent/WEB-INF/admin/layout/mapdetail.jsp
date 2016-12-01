<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" type="text/css" href="assets/css/vis.min.css" />

<script type="text/javascript" src="assets/js/vis.min.js"></script>

<div class="content-wrapper" style="position: relative;">
	<section class="content">
		<!-- Info boxes -->
		<div class="row">
			<div class="col-xs-12 node-status">
				<c:forEach items="${listNode}" var="node">
					<c:if test="${node.status eq 0}">
						<div data="${ node.nodeId }" class="node node-postition">
							<center>
								<img src="assets/img/macker0.png" height=50 />
								<h5>Node ${ node.nodeId }</h5>
							</center>
						</div>
					</c:if>
					<c:if test="${node.status eq 1}">
						<div data="${ node.nodeId }" class="node node-postition">
							<center>
								<img src="assets/img/macker1.png" height=50 />
								<h5>Node ${ node.nodeId }</h5>
							</center>
						</div>
					</c:if>

				</c:forEach>
			</div>
		</div>


	</section>
</div>
<div id="modal-node-detail" class="modal fade" role="dialog"
	data-keyboard="false" data-backdrop="static">
	<div class="modal-dialog modal-lg">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close close-modal">&times;</button>
				<h4 class="modal-title">Node Detail</h4>
			</div>
			<div class="modal-body">
				<!-- <div class="row">
					<div class="col-xs-12">
						<div class="box box-primary">
							<div class="box-header with-border">
								<i class="fa fa-bar-chart-o"></i>

								<h3 class="box-title">Interactive Area Chart</h3>

								<div class="box-tools pull-right">
									Real time
									<div class="btn-group" id="realtime" data-toggle="btn-toggle">
										<button type="button" class="btn btn-default btn-xs active"
											data-toggle="on">On</button>
										<button type="button" class="btn btn-default btn-xs"
											data-toggle="off">Off</button>
									</div>
								</div>
							</div>
							<div class="box-body">
								<div id="interactive" style="height: 300px; width: 100%;"></div>
							</div>
						</div>
					</div>
				</div>-->
				<div class="box box-info">
					<div class="box-header with-border">
						<div class="box-tools pull-right">
							<button type="button" class="btn btn-box-tool"
								data-widget="collapse">
								<i class="fa fa-minus"></i>
							</button>
						</div>
					</div>
					<div class="box-body">
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>Node Id</th>
									<th>Temperature(C)</th>
									<th>Humidity(%)</th>
									<th>Voltage(V)</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td class="nodeId">0</td>
									<td class="temp">0</td>
									<td class="humi">0</td>
									<td class="light">0</td>
								</tr>

							</tbody>
						</table>


					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default close-modal">Close</button>
			</div>
		</div>

	</div>
</div>
<!-- FLOT CHARTS -->
<script src="assets/lte/plugins/flot/jquery.flot.min.js"></script>
<!-- FLOT RESIZE PLUGIN - allows the chart to redraw when the window is resized -->
<script src="assets/lte/plugins/flot/jquery.flot.resize.min.js"></script>
<!-- FLOT PIE PLUGIN - also used to draw donut charts -->
<script src="assets/lte/plugins/flot/jquery.flot.pie.min.js"></script>
<!-- FLOT CATEGORIES PLUGIN - Used to draw bar charts -->
<script src="assets/lte/plugins/flot/jquery.flot.categories.min.js"></script>
<!-- Page script -->
<script>
	$(function() {
		/*
		 * Flot Interactive Chart
		 * -----------------------
		 */
		// We use an inline data source in the example, usually data would
		// be fetched from a server
		/* var data = [], totalPoints = 20;

		 function getRandomData() {

		   if (data.length > 0)
		     data = data.slice(1);

		   // Do a random walk
		   while (data.length < totalPoints) {

		     var prev = data.length > 0 ? data[data.length - 1] : 50,
		         //y = prev + Math.random() * 10 - 5;
		     y = prev + Math.random() * 10-5;

		     if (y < 0) {
		       y = 0;
		     } else if (y > 100) {
		       y = 100;
		     }

		     data.push(y);
		   }

		   // Zip the generated y values with the x values
		   var res = [];
		   for (var i = 0; i < data.length; ++i) {
		     res.push([i, data[i]]);
		   }

		   return res;
		 }

		 var interactive_plot = $.plot("#interactive", [getRandomData()], {
		   grid: {
		     borderColor: "#f3f3f3",
		     borderWidth: 1,
		     tickColor: "#f3f3f3"
		   },
		   series: {
		     shadowSize: 0, // Drawing is faster without shadows
		     color: "#3c8dbc"
		   },
		   lines: {
		     fill: false, //Converts the line chart to area chart
		     color: "#3c8dbc"
		   },
		   yaxis: {
		     min: 0,
		     max: 100,
		     show: true
		   },
		   xaxis: {
		     show: true
		   }
		 });

		 var updateInterval = 5000; //Fetch data ever x milliseconds
		 var realtime = "on"; //If == to on then fetch data every x seconds. else stop fetching
		 function update() {

		   interactive_plot.setData([getRandomData()]);

		   // Since the axes don't change, we don't need to call plot.setupGrid()
		   interactive_plot.draw();
		   if (realtime === "on")
		     setTimeout(update, updateInterval);
		 }

		 //INITIALIZE REALTIME DATA FETCHING
		 if (realtime === "on") {
		   update();
		 }
		 //REALTIME TOGGLE
		 $("#realtime .btn").click(function () {
		   if ($(this).data("toggle") === "on") {
		     realtime = "on";
		   }
		   else {
		     realtime = "off";
		   }
		   update();
		 });*/
		/*
		 * END INTERACTIVE CHART
		 */
	});

	function getRandomInt(min, max) {
		return Math.floor(Math.random() * (max - min + 1)) + min;
	}
	function loadRealTime(nodeID) {
		$.post('node', // URL 
		{
			nodeId : nodeID
		}, // Data
		function(result) { // Success
			if (result !== "error") {
				$.each(result, function(index, item) { // Iterate over the JSON array.
					$("." + index).html(item);
				});
			} else {
				alert(result);
			}
		}, 'json' // dataTyppe
		);
	}

	function loadNodeInMap(mapID) {
		$.post('map-view', // URL 
		{
			mapId : mapID
		}, // Data
		function(result) { // Success
			$.each(result, function(index, item) { // Iterate over the JSON array.
				//$("." + index).html(item);
			//alert(index + " : " + item);
				$(".node-status > div").each(function(){
					if(index == ($(this).attr("data"))){
						if(item == 0){
							$(this).find("img").attr("src", "assets/img/macker0.png");
						}
						if(item == 1){
							$(this).find("img").attr("src", "assets/img/macker1.png");
						}
					}
					
				});
			});
		}, 'json' // dataTyppe
		);
	}

	$(function() {
		
		//loadNodeInMap(${map.mapId});
		intervalUpdateMap = setInterval(function() {
			loadNodeInMap(${map.mapId});
		}, 5000);
		
		
		$('div.node-postition').each(function() {
			$(this).css({
				position : "absolute",
				left : getRandomInt(0, $(this).parent().width()) + 'px',
				top : getRandomInt(0, $(this).parent().height()) + 'px'
			});
		});

		$("div.node").on('click', function() {
			nodeId = $(this).attr("data");
			loadRealTime(nodeId);
			intervalUpdate = setInterval(function() {
				loadRealTime(nodeId);
			}, 5000);
			$("#modal-node-detail").modal('show');
		});
		$(".close-modal").on('click', function() {
			clearInterval(intervalUpdate);
			$("#modal-node-detail").modal('hide');
		});
	});
</script>
