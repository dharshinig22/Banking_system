package com.developer.processservelts;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.processfordao.withdraw_checkDAO;

@WebServlet("/withdraw")
public class Accountinfo_withdraw_servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long w_money = Long.parseLong(request.getParameter("w_money"));
        String account_password = request.getParameter("account_password");
        HttpSession session = request.getSession();
        
        String account_number = (String) session.getAttribute("account_number");
        String user_name = (String) session.getAttribute("uname");

        try {
            withdraw_checkDAO withdraw_checkDAO = new withdraw_checkDAO();
            boolean isSuccess = withdraw_checkDAO.processWithdraw(account_number, user_name, w_money, account_password);

            if (isSuccess) {
                // Update successful
                response.sendRedirect("customer_home.jsp");
            } else {
                // No rows updated, handle as per your application's logic
                request.setAttribute("status", "failed");
                request.getRequestDispatcher("customer_home.jsp").forward(request, response);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new ServletException("Database access error", e);
        }
    }
}
