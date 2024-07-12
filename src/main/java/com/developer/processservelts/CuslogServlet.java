package com.developer.processservelts;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.processfordao.customerlogDAO;

/**
 * Servlet implementation class CuslogServlet
 */
@WebServlet("/get_account")
public class CuslogServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account_number = request.getParameter("account_number");
        String account_password = request.getParameter("account_password");
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher = null;

        customerlogDAO customerLogDAO = new customerlogDAO();
        boolean isValidUser = customerLogDAO.validateUser(account_number, account_password, session);

        if (isValidUser) {
            dispatcher = request.getRequestDispatcher("customer_home.jsp");
        } else {
            request.setAttribute("status", "failed");
            dispatcher = request.getRequestDispatcher("CustomerLogin.jsp");
        }
        dispatcher.forward(request, response);
    }
}
