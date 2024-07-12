package com.processfordao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.http.HttpSession;
import com.processfordao.MainDAO;

public class customerlogDAO {

    public boolean validateUser(String account_number, String account_password, HttpSession session) {
        boolean isValidUser = false;

        try {
            Connection con = MainDAO.getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM reg1_detail WHERE account_number = ? AND account_password = ?");

            pst.setString(1, account_number);
            pst.setString(2, account_password);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                session.setAttribute("uname", rs.getString("uname"));
                session.setAttribute("account_number", rs.getString("account_number"));
                isValidUser = true;
            }

            rs.close();
            pst.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return isValidUser;
    }
}
