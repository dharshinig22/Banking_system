package com.developer.processservelts;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.processfordao.adminlogDAO;

/**
 * Servlet implementation class admlogServlet
 */
@WebServlet("/adminlogin")
public class admlogServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private adminlogDAO adminlogDAO;
    
    public void init() {
        adminlogDAO = new adminlogDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException {
        String adm_name = request.getParameter("admin_name");
        String adm_pass = request.getParameter("admin_pass");

        try {
            if (adminlogDAO.validate(adm_name, adm_pass)) {
                response.sendRedirect("admin_home.jsp"); // Redirect to admin home page
            } else {
                PrintWriter out = response.getWriter();
                out.println("<html><body><b>Login failed. Please check your username and password.</b></body></html>");
            }
        } catch (SQLException e) {
            throw new ServletException("Login failed.", e);
        }
    }
}
