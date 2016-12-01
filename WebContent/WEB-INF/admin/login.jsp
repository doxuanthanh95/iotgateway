<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<%@include file="component/css_library.jsp" %>
<%@include file="component/js_library.jsp" %>
</head>
<body class="hold-transition login-page">
	<div class="login-box">
		<div class="login-logo">
			<a href="#"><h2>
					<b>IOTGATEWAY</b>
				</h2></a>
		</div>
		<!-- /.login-logo -->
		<div class="login-box-body">
			<p class="login-box-msg">Sign in to start your session</p>

			<form action="<?php echo base_url('admin/login/check_login'); ?>"
				method="post">
				<div class="form-group has-feedback">
					<input id="email" type="email" class="form-control" name="email"
						placeholder="Email" required> <span
						class="glyphicon glyphicon-envelope form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input id="password" type="password" class="form-control"
						name="password" placeholder="Password" required> <span
						class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="row">
					<!-- /.col -->
					<div class="col-xs-6 col-xs-offset-3">
						<button type="submit" class="btn btn-primary btn-block btn-flat">Sign
							In</button>
					</div>
					<!-- /.col -->
				</div>
			</form>

		</div>
		<!-- /.login-box-body -->
	</div>
</body>
</html>
