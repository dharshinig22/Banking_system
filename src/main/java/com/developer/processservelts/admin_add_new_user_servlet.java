package com.developer.processservelts;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.processfordao.AdminAddNewUserDAO;

/**
 * Servlet implementation class admin_add_new_user
 */
@WebServlet("/admin_add_new_user")
public class admin_add_new_user_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String uname = request.getParameter("username");
	    String email_id = request.getParameter("email");
	    String phone_no = request.getParameter("phone");
	    String pass = request.getParameter("password");
	    String uaddress = request.getParameter("address");
	    String acc_type = request.getParameter("acc_typ");
	    double ini_bal = Double.parseDouble(request.getParameter("initial_balance"));
	    String udob = request.getParameter("dob");
	    String id_proof = request.getParameter("aadhar");

	    String account_number = generate_account_number();
	    String account_password = generate_account_password();

	    RequestDispatcher dispatcher = null;

	    try {
	        // Call the DAO method to add user
	        int rowcount = AdminAddNewUserDAO.addUser(uname, email_id, phone_no, pass, uaddress, acc_type, ini_bal, udob, id_proof, account_number, account_password);

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

	private String generate_account_number() {
	    return "user" + new Random().nextInt(999999999);
	}

	private String generate_account_password() {
	    return String.valueOf(new Random().nextInt(999999));
	}
}
