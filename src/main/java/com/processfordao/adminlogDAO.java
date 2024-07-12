package com.processfordao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class adminlogDAO {

    private static final String SELECT_USER_SQL = "SELECT * FROM admin_details WHERE adm_name = ? AND adm_pass = ?";
    
    public boolean validate(String admin_name, String admin_pass) throws SQLException {
        boolean status = false;

        try (Connection connection = MainDAO.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_SQL)) {

            preparedStatement.setString(1, admin_name);
            preparedStatement.setString(2, admin_pass);

            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();

        } catch (SQLException e) {
            printSQLException(e);
        }
        return status;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException)e).getSQLState());
                System.err.println("Error Code: " + ((SQLException)e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
