package com.processfordao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDeleteDAO {

    public ResultSet getUserByAccountNumber(String account_number) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            con = MainDAO.getConnection();
            String sql = "SELECT * FROM reg1_detail WHERE account_number = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, account_number);
            rs = pst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return rs;
    }

    public static int deleteUser(String account_number) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        int rowcount = 0;

        try {
            con = MainDAO.getConnection();
            String sql = "DELETE FROM reg1_detail WHERE account_number = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, account_number);

            rowcount = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return rowcount;
    }
}
