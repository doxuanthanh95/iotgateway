<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content-wrapper" id="dashboard">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1 style="text-align: center;">
			Dashboard <small>Iot Gateway</small>
		</h1>
	</section>
	<br />
	<!-- Main content -->
	<section class="content">
		<div class="row">
			<div class="col-md-3 col-sm-6 col-xs-12 col-md-offset-3">
				<a href="map-view">
					<div class="info-box">
						<span class="info-box-icon bg-aqua"><i
							class="ion ion-ios-gear-outline"></i></span>

						<div class="info-box-content">
							<span class="info-box-text">Map View</span> <span
								class="info-box-number">90<small>%</small></span>
						</div>
						<!-- /.info-box-content -->
					</div>
				</a>
				<!-- /.info-box -->
			</div>
			<!-- /.col -->
			<div class="col-md-3 col-sm-6 col-xs-12">
				<a href="statistics">
					<div class="info-box">
						<span class="info-box-icon bg-red"><i
							class="fa fa-google-plus"></i></span>

						<div class="info-box-content">
							<span class="info-box-text">Statistics</span> <span
								class="info-box-number">41,410</span>
						</div>
						<!-- /.info-box-content -->
					</div> <!-- /.info-box -->
				</a>
				<!-- /.col -->
			</div>
		</div>
	</section>
	<!-- /.content -->
</div>
