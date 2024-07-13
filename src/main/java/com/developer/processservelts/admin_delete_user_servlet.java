package com.developer.processservelts;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.processfordao.AdminDeleteDAO;

@WebServlet("/admin_delete_user")
public class admin_delete_user_servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_acc_no = request.getParameter("user_acc_no");

        try {
            AdminDeleteDAO deleteDAO = new AdminDeleteDAO();
            int rowsDeleted = deleteDAO.deleteUser(user_acc_no);

            if (rowsDeleted > 0) {
                response.getWriter().write("User account deleted successfully.");
            } else {
                response.getWriter().write("Failed to delete user account.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("Error occurred: " + e.getMessage());
        }
    }
}
