package com.processfordao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class admin_home_DAO {
    public ResultSet getAllUsers() throws SQLException {
        Connection con = MainDAO.getConnection();
        String query = "SELECT uname, email_id, phone_no, uaddress, acc_type, udob, account_number FROM reg1_detail ORDER BY account_number ASC;";
        PreparedStatement pst = con.prepareStatement(query);
        return pst.executeQuery();
    }
}
