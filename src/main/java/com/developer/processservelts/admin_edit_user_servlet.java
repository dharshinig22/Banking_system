package com.developer.processservelts;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.processfordao.admin_editDAO;

/**
 * Servlet implementation class admin_edit_user_servlet
 */
@WebServlet("/admin_edit_user")
public class admin_edit_user_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String user_acc_no = request.getParameter("user_acc_no");
	    String new_name = request.getParameter("new_name");
	    String new_email = request.getParameter("new_email");
	    String new_ph_no = request.getParameter("new_ph_no");
	    String new_address = request.getParameter("new_address");
	    String new_dob = request.getParameter("new_dob");

	    RequestDispatcher dispatcher = null;

	    try {
	        // Call the DAO method to update user
	        int rowcount = admin_editDAO.updateUser(user_acc_no, new_name, new_email, new_ph_no, new_address, new_dob);

	        dispatcher = request.getRequestDispatcher("admin_home.jsp");
	        if (rowcount > 0) {
	            request.setAttribute("status", "success");
	        } else {
	            request.setAttribute("status", "failed");
	        }
	        dispatcher.forward(request, response);
	    } catch (Exception e) {
	        e.printStackTrace();
	        request.setAttribute("status", "exception: " + e.getMessage());
	        dispatcher = request.getRequestDispatcher("admin_home.jsp");
	        dispatcher.forward(request, response);
	    }
	}
}
