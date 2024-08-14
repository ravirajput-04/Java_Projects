<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<%@include file="all_components/allcss.jsp"%>

</head>
<body>
	<%@include file="all_components/navbar.jsp"%>
	<div class="container-fluid div-color">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card mt-4">
					<div class="card-header text-center text-white bg-custom">
						<i class="fa fa-user-plus fa-3x" aria-hidden="true"></i>
						<h4>Login</h4>
					</div>


					<%
					String invalidMsg = (String) session.getAttribute("loginFail");

					if (invalidMsg != null) {
					%>
					<div class="alert alert-danger" role="alert"><%=invalidMsg%></div>
					<%
					session.removeAttribute("loginFail");
					}
					%>

					<%
					String withoutLoginMsg = (String) session.getAttribute("loginError");
					if (withoutLoginMsg != null) {
					%>
					<div class="alert alert-danger" role="alert"><%=withoutLoginMsg%></div>
					<%
					session.removeAttribute("loginError");
					}
					%>


					<%
					String logoutMsg = (String) session.getAttribute("logoutMsg");
					if (logoutMsg != null) {
					%>
						<div class="alert alert-success" role="alert"><%=logoutMsg%></div>
					<%
					session.removeAttribute("logoutMsg");
					}
					%>

					<div class="card-body">
						<form action="LoginServlet" method="post">
							<div class="form-group">
								<label for="exampleInputEmail1">Email Address</label> <input
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="uemail">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" class="form-control" id="exampleInputPassword1"
									name="upassword">
							</div>

							<button type="submit"
								class="btn btn-primary badge-pill btn-block">Login</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="all_components/footer.jsp"%>
</body>
</html>