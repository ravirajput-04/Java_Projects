package com.ravi.servlet;

import java.io.IOException;

import com.ravi.dao.UserDataDAO;
import com.ravi.database.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AddNotesServlet")
public class AddNotesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String eid = request.getParameter("eid");
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		UserDataDAO dao = new UserDataDAO(DBConnection.getConnection());
		boolean f = dao.AddNotes(title, content, eid);

		if (f) {
			@SuppressWarnings("unused")
			HttpSession session = request.getSession();
			response.sendRedirect("showNotes.jsp");
		} else {
			System.out.println("Failed data");
		}
	}

}
