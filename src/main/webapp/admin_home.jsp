<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.processfordao.admin_home_DAO" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Home</title>
<style>
    body {
        font-family: Arial, sans-serif;
    }
    h2 {
        color: #333;
    }
    .container {
        margin-top: 20px;
        width: 50%;
        margin-left: auto;
        margin-right: auto;
    }
    .form-group {
        margin-bottom: 15px;
    }
    label {
        display: block;
        margin-bottom: 5px;
        font-weight: bold;
    }
    input[type="text"], input[type="email"], input[type="password"], input[type="date"], select {
        width: 100%;
        padding: 8px;
        box-sizing: border-box;
    }
    input[type="submit"] {
        background-color: #4CAF50;
        color: white;
        border: none;
        padding: 10px 20px;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: #45a049;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
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
    .edit, .delete {
        margin: 20px 0;
    }
    .edit button, .delete button {
        background-color: #008CBA;
        color: white;
        border: none;
        padding: 10px 20px;
        cursor: pointer;
        text-decoration: none;
    }
    .edit button:hover, .delete button:hover {
        background-color: #007B9E;
    }
    .edit button a, .delete button a {
        color: white;
        text-decoration: none;
    }
</style>
</head>
<body>
<h2>Welcome Admin</h2>
<%
    // Retrieve the username from the session
    String username = (String) session.getAttribute("adm_name");
    if (username != null) {
        out.println("Welcome, " + username + "!");
    } else {
        out.println("Username not found in session.");
    }
%>
<hr>
<div class="add_new_user">
    <div class="container">
        <form action="admin_add_new_user" method="post">
            <div class="form-group">
                <label for="username">User Name:</label>
                <input type="text" id="username" name="username" placeholder="Enter your name" required><br><br>
            </div>
            <div class="form-group">
                <label for="email">Email ID:</label>
                <input type="email" id="email" name="email" placeholder="Enter your email id" required><br><br>
            </div>
            <div class="form-group">
                <label for="phone">Phone Number:</label>
                <input type="text" id="phone" name="phone" placeholder="Enter your phone number" required><br><br>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" placeholder="Enter your password" required><br><br>
            </div>
            <div class="form-group">
                <label for="address">Address:</label>
                <input type="text" name="address" placeholder="Enter your address" required/><br><br>
            </div>
            <div class="form-group">
                <label for="account_type">Account Type:</label>
                <select name="acc_typ">
                    <option>Current account</option>
                    <option>Savings account</option>
                </select>
                <br><br>
            </div>
            <div class="form-group">
                <label for="initial_balance">Initial Balance:</label>
                <input type="text" id="initial_balance" name="initial_balance" placeholder="Enter account balance" required><br><br>
            </div>
            <div class="form-group">
                <label for="dob">Date of Birth:</label>
                <input type="date" id="dob" name="dob" required><br><br>
            </div>
            <div class="form-group">
                <label for="aadhar">ID Proof:</label>
                <input type="text" id="aadhar" name="aadhar" placeholder="Enter Aadhar number" required><br><br>
            </div>
            <input type="submit" value="Register">
        </form>
    </div>
</div>
<hr>
<div class="edit,delete">
    <div class="edit">
        <button><a href="admin_edit_customer.jsp">Edit user details</a></button>
    </div>
    <div class="delete">
        <button><a href="admin_delete_customer.jsp">Delete an account</a></button>
    </div>
</div>
<h2>List of Users</h2>
<div class="db-details">
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
    <%
    try {
        admin_home_DAO adminDAO = new admin_home_DAO();
        ResultSet rs = adminDAO.getAllUsers();

        while (rs.next()) {
            %>
            <tr>
                <td><%= rs.getString("uname") %></td>
                <td><%= rs.getString("email_id") %></td>
                <td><%= rs.getString("phone_no") %></td>
                <td><%= rs.getString("uaddress") %></td>
                <td><%= rs.getString("acc_type") %></td>
                <td><%= rs.getDate("udob") %></td>
                <td><%= rs.getString("account_number") %></td>
            </tr>
            <%
        }
        rs.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    %>
</table>
</div>
</body>
</html>
