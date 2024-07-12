package com.processfordao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class transactionhistoryDAO {
    private static final String SELECT_TRANSACTIONS_BY_USERNAME = "SELECT transaction_id, amount, transaction_type, t_status, reciever_phone_number, transaction_date FROM transactions WHERE user_name = ?";

    public ResultSet getTransactionsByUserName(String user_name) throws SQLException {
        Connection connection = MainDAO.getConnection();
        PreparedStatement pst = connection.prepareStatement(SELECT_TRANSACTIONS_BY_USERNAME);
        pst.setString(1, user_name);
        return pst.executeQuery();
    }
}
