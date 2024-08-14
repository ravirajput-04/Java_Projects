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

@WebServlet("/EditNotesServlet")
public class EditNotesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			Integer dataId = Integer.parseInt(request.getParameter("dataId"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			UserDataDAO dao = new UserDataDAO(DBConnection.getConnection());
			boolean f = dao.dataUpdate(dataId, title, content);
			
			if(f) {
				HttpSession session = request.getSession();
				session.setAttribute("updateMsg", "Notes Updated Successfully");
				response.sendRedirect("showNotes.jsp");
			}
			else {
				System.out.println("Something went wrong");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
