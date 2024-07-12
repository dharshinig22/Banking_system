package com.processfordao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/bank1";
    private static final String USER = "root";
    private static final String PASSWORD = "Dharshu@22";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("MySQL JDBC Driver not found.");
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
