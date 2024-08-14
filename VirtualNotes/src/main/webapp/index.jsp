<%@page import="java.sql.Connection"%>
<%@page import="com.ravi.database.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Virtual Notes</title>
<%@include file="all_components/allcss.jsp"%>
<style type="text/css">
.back-img {
	background: url("images/ENotes_1.jpg");
	width: 100%;
	height: 80vh;
	background-repeat: no-repeat;
	background-position: center;
	background-size: cover;
	background-attachment: fix;
}
</style>
</head>
<body>
	<%@include file="all_components/navbar.jsp"%>
	
	<div class="container-fluid back-img">
		<div class="text-center">
			<h1 class="text-white"><i class="fa fa-book pt-5 pb-3" aria-hidden="true"></i> E Notes - Save Your Notes</h1>
			<a href="login.jsp" class="btn btn-light"><i class="fa fa-user" aria-hidden="true"></i> Login</a> <a
				href="register.jsp" class="btn btn-light"><i class="fa fa-user-plus" aria-hidden="true"></i> Register</a>
		</div>
	</div>
	<%@include file="all_components/footer.jsp"%>
</body>
</html>