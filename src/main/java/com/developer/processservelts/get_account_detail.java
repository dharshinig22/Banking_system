package com.developer.processservelts;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class get_account_details
 */
@WebServlet("/get_account")
public class get_account_detail extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phone_no = request.getParameter("phone_number");
        String pass = request.getParameter("password");
        RequestDispatcher dispatcher = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank1", "root", "Dharshu@22");
            PreparedStatement pst = con.prepareStatement("SELECT account_number, account_password FROM reg1_detail WHERE phone_no = ? AND pass = ?");

            pst.setString(1, phone_no);
            pst.setString(2, pass);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String account_number = rs.getString("account_number");
                String account_password = rs.getString("account_password");
                request.setAttribute("account_number", account_number);
                request.setAttribute("account_password", account_password);
                dispatcher = request.getRequestDispatcher("CustomerLogin.jsp");
            } else {
                request.setAttribute("status", "failed");
                dispatcher = request.getRequestDispatcher("CustomerLogin.jsp");
            }
            dispatcher.forward(request, response);

            rs.close();
            pst.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Database access error", e);
        }
    }
}