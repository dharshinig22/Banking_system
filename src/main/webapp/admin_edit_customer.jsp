<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.processfordao.admin_editDAO" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Account</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 60px;
            background-color: #f9f9f9;
        }
        h2 {
            color: #333;
        }
        form {
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-top: 20px;
            font-weight: bold;
        }
        input[type="text"], input[type="email"], input[type="date"], input[type="submit"] {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #0080ff;
            color: white;
            border: none;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #0040ff;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            background-color: #fff;
        }
        table th, table td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;
        }
        table th {
            background-color: #f2f2f2;
            color: #333;
        }
    </style>
</head>
<body>
<h2>Edit an Account</h2>
<form method="post" action="">
    <label>Enter the account number</label>
    <input type="text" name="account_number"/>
    <input type="submit" value="Get"/>
</form>
<%
String user_acc_no = request.getParameter("account_number");
if (user_acc_no != null && !user_acc_no.isEmpty()) {
    try {
        admin_editDAO userDAO = new admin_editDAO();
        ResultSet rs = userDAO.getUserByAccountNumber(user_acc_no);

        if (rs.next()) {
            %>
            <table>
                <tr>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Phone Number</th>
                    <th>Address</th>
                    <th>Account Type</th>
                    <th>Date of Birth</th>
                    <th>Account Number</th>
                </tr>
                <tr>
                    <td><%= rs.getString("uname") %></td>
                    <td><%= rs.getString("email_id") %></td>
                    <td><%= rs.getString("phone_no") %></td>
                    <td><%= rs.getString("uaddress") %></td>
                    <td><%= rs.getString("acc_type") %></td>
                    <td><%= rs.getDate("udob") %></td>
                    <td><%= rs.getString("account_number") %></td>
                </tr>
            </table><br>
            <form action="admin_edit_user" method="post">
                <input type="hidden" name="user_acc_no" value="<%= user_acc_no %>"/>
                <label>Name</label>
                <input type="text" name="new_name" value="<%= rs.getString("uname") %>"/><br><br>
                <label>Email</label>
                <input type="email" name="new_email" value="<%= rs.getString("email_id") %>"/><br><br>
                <label>Phone Number</label>
                <input type="text" name="new_ph_no" value="<%= rs.getString("phone_no") %>"/><br><br>
                <label>Address</label>
                <input type="text" name="new_address" value="<%= rs.getString("uaddress") %>"/><br><br>
                <label>Date of Birth</label>
                <input type="date" name="new_dob" value="<%= rs.getDate("udob") %>"/><br><br>
                <input type="submit" value="Update">
            </form>
            <%
        } else {
            out.println("No account found with the provided account number.");
        }
        rs.close();
    } catch (Exception e) {
        e.printStackTrace();
        out.println("Error occurred: " + e.getMessage());
    }
}
%>
</body>
</html>
