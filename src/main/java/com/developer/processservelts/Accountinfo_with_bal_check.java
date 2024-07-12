package com.developer.processservelts;

import com.processfordao.balance_checkDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/bal_check")
public class Accountinfo_with_bal_check extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account_password = request.getParameter("account_password");
        balance_checkDAO balance_checkDAO = new balance_checkDAO();
        RequestDispatcher dispatcher = null;

        try {
            String ini_bal = balance_checkDAO.checkBalance(account_password);

            if (ini_bal != null) {
                request.setAttribute("initial_balance", ini_bal);
                dispatcher = request.getRequestDispatcher("customer_home.jsp");
            } else {
                request.setAttribute("status", "failed");
                dispatcher = request.getRequestDispatcher("customer_home.jsp");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Database access error", e);
        }

        dispatcher.forward(request, response);
    }
}
