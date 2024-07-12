package com.processfordao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import com.processfordao.MainDAO;

public class deposite_checkDAO {

    public static boolean depositMoney(String account_number, String user_name, long d_money, String account_password)
            throws SQLException {
        Connection con = null;
        PreparedStatement pst_u = null;
        PreparedStatement pst_t = null;

        try {
            con = MainDAO.getConnection();

            pst_u = con.prepareStatement(
                    "UPDATE reg1_detail SET ini_bal = ini_bal + ? WHERE account_password = ?");
            pst_u.setLong(1, d_money);
            pst_u.setString(2, account_password);

            Timestamp currentTimestamp = new Timestamp(new Date().getTime());

            pst_t = con.prepareStatement(
                    "INSERT INTO transactions (account_number, user_name, amount, transaction_type, t_status, reciever_phone_number, transaction_date) VALUES (?, ?, ?, ?, ?, ?, ?);");
            pst_t.setString(1, account_number);
            pst_t.setString(2, user_name);
            pst_t.setLong(3, d_money);
            pst_t.setString(4, "deposit");
            pst_t.setString(5, "completed");
            pst_t.setString(6, "");
            pst_t.setTimestamp(7, currentTimestamp);

            int rowsupdated_s = pst_u.executeUpdate();
            int rowsinserted_t = pst_t.executeUpdate();

            return rowsupdated_s > 0 && rowsinserted_t > 0;
        } finally {
            if (pst_u != null) pst_u.close();
            if (pst_t != null) pst_t.close();
            if (con != null) con.close();
        }
    }
}
