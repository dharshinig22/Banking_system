package com.developer.processservelts;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.processfordao.deposite_checkDAO;

@WebServlet("/deposit")
public class Accountinfo_deposite_servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long d_money = Long.parseLong(request.getParameter("d_money"));
        String account_password = request.getParameter("account_password");
        HttpSession session = request.getSession();

        String account_number = (String) session.getAttribute("account_number");
        String user_name = (String) session.getAttribute("uname");

        try {
            boolean isDeposited = deposite_checkDAO.depositMoney(account_number, user_name, d_money, account_password);
            if (isDeposited) {
                response.sendRedirect("customer_home.jsp");
            } else {
                request.setAttribute("status", "failed");
                request.getRequestDispatcher("customer_home.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Database access error", e);
        }
    }
}
