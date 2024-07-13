package com.processfordao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminAddNewUserDAO {

    public static int addUser(String uname, String email_id, String phone_no, String pass, String uaddress, String acc_type, double ini_bal, String udob, String id_proof, String account_number, String account_password) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        int rowcount = 0;

        try {
            con = MainDAO.getConnection();
            String sql = "INSERT INTO reg1_detail (uname, email_id, phone_no, pass, uaddress, acc_type, ini_bal, udob, id_proof, account_number, account_password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pst = con.prepareStatement(sql);

            pst.setString(1, uname);
            pst.setString(2, email_id);
            pst.setString(3, phone_no);
            pst.setString(4, pass);
            pst.setString(5, uaddress);
            pst.setString(6, acc_type);
            pst.setDouble(7, ini_bal);
            pst.setString(8, udob);
            pst.setString(9, id_proof);
            pst.setString(10, account_number);
            pst.setString(11, account_password);

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
