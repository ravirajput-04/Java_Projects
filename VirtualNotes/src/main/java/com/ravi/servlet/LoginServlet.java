package com.ravi.servlet;

import java.io.IOException;

import com.ravi.beans.UserDetails;
import com.ravi.dao.UserDAO;
import com.ravi.database.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("uemail");
		String password = request.getParameter("upassword");

		UserDetails user = new UserDetails();
		user.setEmail(email);
		user.setPassword(password);

		user = new UserDAO(DBConnection.getConnection()).loginUser(user);

		if (user != null) {

			HttpSession session = request.getSession();
			session.setAttribute("userDA", user);
			response.sendRedirect("home.jsp");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("loginFail", "Invalid Username/Password");
			response.sendRedirect("login.jsp");
		}
	}

}
