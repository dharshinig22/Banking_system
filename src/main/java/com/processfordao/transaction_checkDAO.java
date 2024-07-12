package com.processfordao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class transaction_checkDAO {
    public static boolean performTransaction(String account_number, String username, long t_money, String receiver_phone_number, String account_password) throws SQLException {
        Connection con = null;
        PreparedStatement pst_s = null;
        PreparedStatement pst_r = null;
        PreparedStatement pst_t = null;

        try {
            con = MainDAO.getConnection();

            con.setAutoCommit(false); // Start transaction

            pst_s = con.prepareStatement("UPDATE reg1_detail SET ini_bal = ini_bal - ? WHERE account_password = ?");
            pst_s.setLong(1, t_money);
            pst_s.setString(2, account_password);

            pst_r = con.prepareStatement("UPDATE reg1_detail SET ini_bal = ini_bal + ? WHERE phone_no = ?");
            pst_r.setLong(1, t_money);
            pst_r.setString(2, receiver_phone_number);

            Timestamp currentTimestamp = new Timestamp(new Date().getTime());

            pst_t = con.prepareStatement(
                "INSERT INTO transactions (account_number, user_name, amount, transaction_type, t_status, reciever_phone_number, transaction_date) VALUES (?, ?, ?, ?, ?, ?, ?);"
            );

            pst_t.setString(1, account_number);
            pst_t.setString(2, username);
            pst_t.setLong(3, t_money);
            pst_t.setString(4, "transaction");
            pst_t.setString(5, "completed");
            pst_t.setString(6, receiver_phone_number);
            pst_t.setTimestamp(7, currentTimestamp);

            int rowsupdated_s = pst_s.executeUpdate();
            int rowsupdated_r = pst_r.executeUpdate();
            int rowsinserted_t = pst_t.executeUpdate();

            if (rowsupdated_s > 0 && rowsupdated_r > 0 && rowsinserted_t > 0) {
                con.commit(); // Commit transaction
                return true;
            } else {
                con.rollback(); // Rollback transaction in case of failure
                return false;
            }
        } catch (SQLException e) {
            if (con != null) {
                con.rollback(); // Rollback transaction in case of error
            }
            throw e;
        } finally {
            if (pst_s != null) pst_s.close();
            if (pst_r != null) pst_r.close();
            if (pst_t != null) pst_t.close();
            if (con != null) con.close();
        }
    }
}
