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

@WebServlet("/DeleteServlet")

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Integer dataId = Integer.parseInt(request.getParameter("ENotes_User_Data_id"));
			UserDataDAO dao = new UserDataDAO(DBConnection.getConnection());
			boolean f = dao.deleteNotes(dataId);
			HttpSession session = null;
			if(f) {
				session = request.getSession();
				session.setAttribute("updateMsg", "Deleted Successfully");
				response.sendRedirect("showNotes.jsp");
			}
			else {
				session = request.getSession();
				session.setAttribute("wrongMsg","Something went wrong on server");
				response.sendRedirect("showNotes.jsp");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
