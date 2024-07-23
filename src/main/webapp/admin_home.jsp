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
        background-color: #f0f2f5;
        margin: 0;
        padding: 20px;
        display: flex;
        flex-direction: column;
        align-items: center;
        min-height: 100vh;
    }

    .header {
        text-align: center;
        margin-bottom: 20px;
    }

    .container {
        background-color: #ffffff;
        padding: 30px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        width: 100%;
        margin-top: 20px;
    }

    .container form {
        display: flex;
        flex-direction: column;
    }

    .container label {
        margin-bottom: 10px;
    }

    .container input[type="text"],
    .container input[type="password"],
    .container input[type="email"],
    .container input[type="date"],
    .container select,
    .container input[type="submit"] {
        padding: 10px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 5px;
        width: calc(100% - 22px);
    }

    .container input[type="submit"] {
        background-color: #0080ff;
        color: white;
        border: none;
        cursor: pointer;
    }

    .container input[type="submit"]:hover {
        background-color: #0040ff;
    }

    .add_new_user, .edit_delete {
        margin-top: 20px;
    }

    .edit_delete button {
        margin-top: 10px;
    }

    .db-details {
        margin-top: 30px;
        width: 100%;
        max-width: 1200px;
        overflow-x: auto;
    }

    .db-details table {
        width: 100%;
        border-collapse: collapse;
    }

    .db-details th, .db-details td {
        padding: 12px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }

    .db-details th {
        background-color: #f2f2f2;
    }

    .edit-delete {
        display: flex;
        justify-content: space-around;
        margin-top: 20px;
    }

    .edit-delete .edit,
    .edit-delete .delete {
        text-align: center;
    }

    .edit-delete button {
        padding: 10px 20px;
        background-color: #0080ff;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        text-decoration: none;
        display: inline-block;
        transition: background-color 0.3s ease;
    }

    .edit-delete button:hover {
        background-color: #0040ff;
    }

    .edit-delete button a {
        color: white;
        text-decoration: none;
    }

    .edit-delete button:hover a {
        color: white;
    }
</style>
</head>
<body>
<h2>Welcome Admin</h2>
<%
    // Retrieve the username from the session
    String username = (String) session.getAttribute("uname");
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
            <div>
                <label for="username">User Name:</label>
                <input type="text" id="name" name="username" placeholder="Enter your name" required>
            </div>
            <div>
                <label for="email">Email ID:</label>
                <input type="email" id="email" name="email" placeholder="Enter your email id" required>
            </div>
            <div>
                <label for="phone">Phone Number:</label>
                <input type="text" id="phone" name="phone" placeholder="Enter your phone number" required>
            </div>
            <div>
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" placeholder="Enter your password" required>
            </div>
            <div>
                <label for="address">Address:</label>
                <input type="text" name="address" placeholder="Enter your address" required>
            </div>
            <div>
                <label for="account_type">Account Type:</label>
                <select name="acc_typ">
                    <option>Current account</option>
                    <option>Savings account</option>
                </select>
            </div>
            <div>
                <label for="initial_balance">Initial Balance:</label>
                <input type="text" id="initial_balance" name="initial_balance" placeholder="Enter account balance" required>
            </div>
            <div>
                <label for="dob">Date of Birth:</label>
                <input type="date" id="dob" name="dob" required>
            </div>
            <div>
                <label for="aadhar">ID Proof:</label>
                <input type="text" id="aadhar" name="aadhar" placeholder="Enter Aadhar number" required>
            </div>
            <input type="submit" value="Register">
        </form>
    </div>
</div>
<hr>
<div class="edit-delete">
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
