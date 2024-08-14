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

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("fname");
		String email = request.getParameter("uemail");
		String password = request.getParameter("upassword");

		UserDetails user = new UserDetails();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		
		UserDAO dao = new UserDAO(DBConnection.getConnection());
		boolean f = dao.addUser(user);
		HttpSession session;
		if(f) {
			session = request.getSession();
			session.setAttribute("reg-success", "Registered Successfully..");
			response.sendRedirect("register.jsp");
		}
		else {
			session = request.getSession();
			session.setAttribute("reg-fail", "Something went wrong..!");
			response.sendRedirect("register.jsp");
		}
	}
}
