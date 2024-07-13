<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.processfordao.AdminDeleteDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete a User Account</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 20px;
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
        margin-top: 10px;
        font-weight: bold;
    }
    input[type="text"], input[type="submit"] {
        width: 100%;
        padding: 8px;
        margin-top: 5px;
        box-sizing: border-box;
    }
    input[type="submit"] {
        background-color: #d9534f;
        color: white;
        border: none;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: #c9302c;
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
    <h2>Delete a User Account</h2>
    <form action="" method="post">
        <label>Enter the account number</label>
        <input type="text" name="user_acc_no"/>
        <input type="submit" value="Get"/>
    </form>

    <%
    String user_acc_no = request.getParameter("user_acc_no");
    if (user_acc_no != null && !user_acc_no.isEmpty()) {
        try {
            AdminDeleteDAO userDAO = new AdminDeleteDAO();
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
                <form action="admin_delete_user" method="post">
                    <input type="hidden" name="user_acc_no" value="<%= user_acc_no %>"/>
                    <input type="submit" value="Delete Account"/>
                </form>
                <%
            } else {
                out.println("<br>No account found with the provided account number.");
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
