package com.developer.processservelts;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.processfordao.customerregDAO;

@WebServlet("/registercustomer")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private customerregDAO customerDAO;

    public void init() {
        customerDAO = new customerregDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("username");
        String email_id = request.getParameter("email");
        String phone_no = request.getParameter("phone");
        String pass = request.getParameter("password");
        String uaddress = request.getParameter("address");
        String acc_type = request.getParameter("acc_typ");
        String ini_bal = request.getParameter("initial_balance");
        String udob = request.getParameter("dob");
        String id_proof = request.getParameter("aadhar");

        if (email_id.length() > 100) {  // Adjust length based on your database schema
            throw new ServletException("Email is too long.");
        }

        String account_number = generate_account_number();
        String account_password = generate_account_password();

        try {
            customerDAO.registerCustomer(uname, email_id, phone_no, pass, uaddress, acc_type, ini_bal, udob, id_proof, account_number, account_password);
            response.sendRedirect("CustomerLogin.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Registration failed.", e);
        }
    }

    private String generate_account_number() {
        return "user" + new Random().nextInt(999999999);
    }

    private String generate_account_password() {
        return String.valueOf(new Random().nextInt(999999));
    }
}
