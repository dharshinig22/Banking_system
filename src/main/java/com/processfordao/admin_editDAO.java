package com.processfordao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class admin_editDAO {

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

    public static int updateUser(String user_acc_no, String new_name, String new_email, String new_ph_no, String new_address, String new_dob) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        int rowcount = 0;

        try {
            con = MainDAO.getConnection();
            String sql = "UPDATE reg1_detail SET uname = ?, email_id = ?, phone_no = ?, uaddress = ?, udob = ? WHERE account_number = ?";
            pst = con.prepareStatement(sql);

            pst.setString(1, new_name);
            pst.setString(2, new_email);
            pst.setString(3, new_ph_no);
            pst.setString(4, new_address);
            pst.setString(5, new_dob);
            pst.setString(6, user_acc_no);

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
