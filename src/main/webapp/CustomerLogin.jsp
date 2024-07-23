<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login Page</title>
<style>
    /* Reset some basic elements */
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }

    body {
        background-image: url('img/b1.jpg'); 
        background-size: cover;
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        color: #333;
        line-height: 1.6;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .container {
        width: 100%;
        max-width: 600px;
        background: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    h2 {
        margin-bottom: 20px;
        font-size: 24px;
        color: #333;
    }

    form {
        display: flex;
        flex-direction: column;
    }

    label {
        margin-bottom: 10px;
        font-weight: bold;
    }

    input[type="text"],
    input[type="password"] {
        padding: 10px;
        margin-bottom: 20px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }

    input[type="submit"] {
        padding: 10px;
        border: none;
        border-radius: 4px;
        background-color: #0080ff;
        color: white;
        font-size: 16px;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background-color: #0040ff;
    }

    p {
        margin-top: 10px;
        font-size: 16px;
    }
</style>
</head>
<body>
<input type="hidden" id="status" value="<%=request.getAttribute("status")%>"/>
<div class="container">
    <section>
        <h2>Get Account ID</h2>
        <form action="get_account" method="post">
            <label for="phone_number">Phone Number</label>
            <input type="text" id="phone_number" name="phone_number" required/>
            
            <label for="password">Password</label>
            <input type="password" id="password" name="password" required/>
            
            <input type="submit" value="Get"/>
        </form>
        <%-- Display retrieved account details --%>
        <%
        String accountNumber = (String) request.getAttribute("account_number");
        String accountPassword = (String) request.getAttribute("account_password");
        if (accountNumber != null && accountPassword != null) {
            out.println("<p>Account Number: " + accountNumber + "</p>");
            out.println("<p>Account Password: " + accountPassword + "</p>");
        }
        %>
    </section>

    <section>
        <h2>Account Login</h2>
        <form action="get" method="post">
            <label for="account_number">Account Number</label>
            <input type="text" id="account_number" name="account_number" placeholder="Enter your Account Number" required/>
            
            <label for="account_password">Account Password</label>
            <input type="password" id="account_password" name="account_password" placeholder="Enter your Account password" required/>
            
            <input type="submit" value="Login" name="signin"/>
        </form>
    </section>
</div>
</body>
</html>
