package com.developer.processservelts;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.processfordao.transaction_checkDAO;

@WebServlet("/transaction1")
public class Accountinfo_transaction_servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long t_money = Long.parseLong(request.getParameter("t_amount"));
        String ph_no = request.getParameter("receiver_phone_number");
        String account_password = request.getParameter("account_password");
        HttpSession session = request.getSession();

        String username = (String) session.getAttribute("uname");
        String account_number = (String) session.getAttribute("account_number");

        try {
            boolean transactionSuccess = transaction_checkDAO.performTransaction(account_number, username, t_money, ph_no, account_password);

            if (transactionSuccess) {
                response.sendRedirect("customer_home.jsp");
            } else {
                request.setAttribute("status", "failed");
                request.getRequestDispatcher("customer_home.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Database access error", e);
        }
    }
}
