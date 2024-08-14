<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
UserDetails user3 = (UserDetails) session.getAttribute("userDA");
if (user3 == null) {

	response.sendRedirect("login.jsp");
	session.setAttribute("loginError", "Please Login...");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<%@include file="all_components/allcss.jsp"%>
</head>
<body>

	<div class="container-fluid">
		<%@include file="all_components/navbar.jsp"%>
		<div class="card py-5">
			<div class="card-body text-center">
				<img alt="" src="images/ENotes_2.png" class="img-fluid mx-auto"
					style="max-width: 300px;">
				<h1>START TAKING YOUR NOTES</h1>
				<a href="addNotes.jsp" class="btn btn-outline-primary">Start
					Here</a>
			</div>
		</div>
	</div>
	<%@include file="all_components/footer.jsp"%>

</body>
</html>