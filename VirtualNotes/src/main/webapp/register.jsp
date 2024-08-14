<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
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
						<h4>Registration</h4>
					</div>

					<%
					String regMsg = (String) session.getAttribute("reg-success");
					if (regMsg != null) {
					%>
					<div class="alert alert-success" role="alert"><%=regMsg%>
						Login<a href="login.jsp"> Click Here</a>
					</div>
					<%
					session.removeAttribute("reg-success");
					}
					%>


					<%
					String failMsg = (String) session.getAttribute("reg-fail");
					if (failMsg != null) {
					%>
					<div class="alert alert-danger" role="alert"><%=failMsg%></div>
					<%
					session.removeAttribute("reg-fail");
					}
					%>
					<div class="card-body">
						<form action="RegisterServlet" method="post">
							<div class="form-group">
								<label for="exampleInputName1">Full Name</label> <input
									type="text" class="form-control" id="exampleInputName1"
									aria-describedby="emailHelp" name="fname">
							</div>
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
								class="btn btn-primary badge-pill btn-block">Register</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="all_components/footer.jsp"%>
</body>
</html>