<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Content Wrapper. Contains page content -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			Statistics <small>iotsgateway</small>
		</h1>
	</section>

	<!-- Main content -->
	<section class="content">
		<div class="row">
			<div class="col-xs-12">
				<div class="box">
					<div class="box-header">
						<h3 class="box-title">Statics Map</h3>
					</div>
					<!-- /.box-header -->
					<div class="box-body">
						<table id="example2" class="table table-bordered table-hover">
							<thead>
								<tr>
									<th>Map ID</th>
									<th>Number Node</th>
						
									<th>Detail</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${listMap}" var="map">
									<tr>
										<td>${map.mapId }</td>
										<td>${map.numberNode }</td>
										<td><a data = "${map.mapId}"class="detail-map"><i class="glyphicon glyphicon-cloud"></i></a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<!-- /.box-body -->
				</div>

			</div>
			<!-- /.col -->
		</div>
		<!-- /.row -->
	</section>
</div>

<div id="modal-map-detail" class="modal fade" role="dialog"
	data-keyboard="false" data-backdrop="static">
	<div class="modal-dialog modal-lg">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close close-modal">&times;</button>
				<h4 class="modal-title">Map Detail</h4>
			</div>
			<div class="modal-body">
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
									<th>Voltage</th>
									<th>Map Id</th>
									<th>Status</th>
								</tr>
							</thead>
							<tbody class="list-node">
							</tbody>
						</table>
					</div>
					<!-- /.box-body -->
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default close-modal">Close</button>
			</div>
		</div>

	</div>
</div>


<script src="assets/lte/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="assets/lte/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script>
	function loadDetailMap(mapID){
		$.post(
	            'statistics', // URL 
	            {mapId : mapID},  // Data
	            function(result){ // Success
	               	//alert(result);
	            	tbody = $(".list-node");
	            	$.each(result, function(index, item) { // Iterate over the JSON array.
						//$("." + index).html(item); 
	            		tbody.append("<tr class='row-node"+index+"'>");
	            		$.each(item, function(index1, item1) { // Iterate over the JSON array.
							//alert(item1);
	            			$(".row-node"+index).append("<td>"+item1+"</td>");
						});
	            		tbody.append("</tr>");
					});
	            }, 
	            'json' // dataTyppe
	    );
	}
	$(function() {
		$('#example2').DataTable({
			"paging" : true,
			"lengthChange" : false,
			"searching" : false,
			"ordering" : true,
			"info" : true,
			"autoWidth" : false
		});
		$("a.detail-map").on('click', function(){
			loadDetailMap($(this).attr("data"));
			$("#modal-map-detail").modal('show');
		});
		$(".close-modal").on('click', function(){
			$(".list-node > tr").remove();
			$("#modal-map-detail").modal('hide');
		});
	});
</script>