<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			Dashboard <small>Iot Gateway</small>
		</h1>
	</section>
	<!-- Main content -->
	<section class="content">
		<!-- Info boxes -->
		<div class="row">
			<div class="col-xs-12">
				<c:forEach items="${ listMap }" var="map">
					<div class="col-lg-3 col-xs-6">
						<div class="small-box bg-green">
							<div class="inner" style="text-align: center;">
								<h3>Map: ${ map.mapId}</h3>
								<p>${map.numberNode}
								<p />
							</div>
							<div class="icon">
								<i class="fa fa-cogs"></i>
							</div>
							<a href="map-view?mapid=${ map.mapId }" class="small-box-footer">
								More info <i class="fa fa-arrow-circle-right"></i>
							</a>
						</div>
					</div>
				</c:forEach>


			</div>
		</div>

	</section>
	<!-- /.content -->
</div>
