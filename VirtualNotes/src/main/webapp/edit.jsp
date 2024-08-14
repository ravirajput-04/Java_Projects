<%@page import="com.ravi.beans.UserData"%>
<%@page import="com.ravi.database.DBConnection"%>
<%@page import="com.ravi.dao.UserDataDAO"%>
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
<title>Edit Notes</title>
<%@include file="all_components/allcss.jsp"%>
</head>
<body>
	<%
	Integer dataId = Integer.parseInt(request.getParameter("ENotes_User_Data_id"));
	UserDataDAO udao = new UserDataDAO(DBConnection.getConnection());
	UserData ud = udao.getDataById(dataId);
	%>
	<div class="container-fluid">
		<%@include file="all_components/navbar.jsp"%>
		<h1 class="text-center">Edit Your Notes</h1>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<form action="EditNotesServlet" method="post">
						<input type="hidden" value="<%=dataId%>" name = "dataId">


						<div class="form-group">
							<%
							UserDetails user1 = (UserDetails) session.getAttribute("userDA");
							if (user1 != null) {
							%>
							<input type="hidden" value="<%=user1.getId()%>" name="eid">
							<%
							}
							%>
							<label for="exampleInputEmail1">Enter Title</label> <input
								type="text" class="form-control" id="exampleInputEmail1"
								aria-describedby="emailHelp" name="title" required="required" value = "<%=ud.getTitle()%>">
						</div>

						<div class="form-group">
							<label for="exampleInputEmail1">Enter Content</label>
							<textarea rows="9" cols="" class="form-control" name="content"
								required="required"><%=ud.getContent() %></textarea>
						</div>

						<div class="container text-center">
							<button type="submit" class="btn btn-primary">Add Notes</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<%@include file="all_components/footer.jsp"%>
</body>
</html>