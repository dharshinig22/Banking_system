package com.processfordao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class customerregDAO {

    private static final String INSERT_CUSTOMER_SQL = "INSERT INTO reg1_detail (uname, email_id, phone_no, pass, uaddress, acc_type, ini_bal, udob, id_proof, account_number, account_password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public void registerCustomer(String username, String email, String phone, String password, String address, String acc_typ, String initial_balance, String dob, String aadhar, String account_number, String account_password) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = MainDAO.getConnection();
            preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL);

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, phone);
            preparedStatement.setString(4, password);
            preparedStatement.setString(5, address);
            preparedStatement.setString(6, acc_typ);
            preparedStatement.setString(7, initial_balance);
            preparedStatement.setString(8, dob);
            preparedStatement.setString(9, aadhar);
            preparedStatement.setString(10, account_number);
            preparedStatement.setString(11, account_password);

            System.out.println("Executing query: " + preparedStatement.toString());
            preparedStatement.executeUpdate();
            System.out.println("Customer registered successfully");
        } catch (SQLException e) {
            printSQLException(e);
            throw e;  // Rethrow exception after logging it
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    printSQLException(e);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    printSQLException(e);
                }
            }
        }
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
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
