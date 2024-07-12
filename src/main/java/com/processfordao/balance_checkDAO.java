package com.processfordao;

import com.processfordao.MainDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class balance_checkDAO {

    public String checkBalance(String account_password) throws SQLException {
        String ini_bal = null;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            con = MainDAO.getConnection();
            pst = con.prepareStatement("SELECT ini_bal FROM reg1_detail WHERE account_password = ?");
            pst.setString(1, account_password);
            rs = pst.executeQuery();

            if (rs.next()) {
                ini_bal = rs.getString("ini_bal");
            }

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return ini_bal;
    }
}
