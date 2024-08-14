<%@page import="java.util.List"%>
<%@page import="com.ravi.beans.UserData"%>
<%@page import="com.ravi.dao.UserDataDAO"%>
<%@page import="com.ravi.database.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
UserDetails user4 = (UserDetails) session.getAttribute("userDA");
if (user4 == null) {

	response.sendRedirect("login.jsp");
	session.setAttribute("loginError", "Please Login...");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Notes</title>
<%@include file="all_components/allcss.jsp"%>
</head>
<body>
	<%@include file="all_components/navbar.jsp"%>
	<%
	String updatedOrDelete = (String) session.getAttribute("updateMsg");
	if (updatedOrDelete != null) {
	%>
	<div class="alert alert-success" role="alert"><%=updatedOrDelete%></div>
	<%
	session.removeAttribute("updateMsg");
	}
	%>


	<%
	String wrongMsg = (String) session.getAttribute("wrongMsg");
	if (wrongMsg != null) {
	%>
	<div class="alert alert-danger" role="alert"><%=wrongMsg%></div>
	<%
	session.removeAttribute("wrongMsg");
	}
	%>
	<div class="container">
		<h2 class="text-center">All Notes</h2>
		<div class="row">
			<div class="col-md-12">
				<%
				if (user4 != null) {
					UserDataDAO ob = new UserDataDAO(DBConnection.getConnection());
					List<UserData> list = ob.getData(user4.getId());
					for (UserData po : list) {
				%>
				<div class="card mt-3">
					<img alt="" src="images/ENotes_2.png"
						class="card-img-top mt-2 mx-auto" style="max-width: 100px;">
					<div class="card-body p-4">
						<h5 class="card-title"><%=po.getTitle()%></h5>
						<p><%=po.getContent()%></p>

						<p>
							<b class="text-success">Published by: <%=user4.getName()%></b>
						</p>

						<div class="container text-center mt-2">
							<a href="DeleteServlet?ENotes_User_Data_id=<%=po.getId()%>"
								class="btn btn-danger">Delete</a> <a
								href="edit.jsp?ENotes_User_Data_id=<%=po.getId()%>"
								class="btn btn-primary">Edit</a>
						</div>
					</div>
				</div>
				<%
				}
				}
				%>

			</div>
		</div>
	</div>
</body>
</html>