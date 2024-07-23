<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sign Up Page</title>
<style>
@import url('https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap');

body {
    background-image: url('img/b1.jpg'); 
    background-size: cover;
    background-position: center;
    background-attachment: fixed;
    font-family: 'Poppins', sans-serif;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: flex-start;
    height: 100vh;
    margin: 0;
    padding-top: 20px;
}

header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    width: 100%;
    max-width: 600px;
    padding: 20px;
    background: rgba(255, 255, 255, 0.8);
    border-radius: 10px;
    box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
    margin-bottom: 20px;
}

header h2, header a {
    font-weight: 700;
    font-size: 1.5em;
    color: #333;
    text-decoration: none;
    margin: 0;
}

.container {
    background-color: rgba(255, 255, 255, 0.9);
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
    width: 80%;
    max-width: 600px;
    margin: 20px;
}

label {
    font-weight: 500;
    margin-bottom: 5px;
    display: block;
}

input, select {
    width: calc(100% - 20px);
    margin: 10px 0;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
}

input[type="submit"] {
    background-color: #0080ff;
    color: white;
    border: none;
    cursor: pointer;
    transition: background-color 0.3s ease;
    width: 100%;
    padding: 15px;
    font-size: 1em;
    margin-top: 20px;
}

input[type="submit"]:hover {
    background-color: #0040ff;
}

a {
    color: #4CAF50;
    text-decoration: none;
}

a:hover {
    text-decoration: underline;
}
</style>
</head>
<body>
<header>
    <h2>Sign Up</h2>
    <h2><a href="CustomerLogin.jsp">Login</a></h2>
</header>
<div class="container">
<form action="registercustomer" method="post">
    <div class="form-group">
        <label for="username">User Name:</label>
        <input type="text" id="username" name="username" placeholder="Enter your name" required>
    </div>
    <div class="form-group">
        <label for="email">Email ID:</label>
        <input type="email" id="email" name="email" placeholder="Enter your email id" required>
    </div>
    <div class="form-group">
        <label for="phone">Phone Number:</label>
        <input type="text" id="phone" name="phone" placeholder="Enter your phone number" required>
    </div>
    <div class="form-group">
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" placeholder="Enter your password" required>
    </div>
    <div class="form-group">
        <label for="address">Address:</label>
        <input type="text" name="address" placeholder="Enter your address" required>
    </div>
    <div class="form-group">
        <label for="account_type">Account Type:</label>
        <select name="acc_typ" required>
            <option value="current">Current Account</option>
            <option value="savings">Savings Account</option>
        </select>
    </div>
    <div class="form-group">
        <label for="initial_balance">Initial Balance:</label>
        <input type="text" id="initial_balance" name="initial_balance" placeholder="Enter account balance" required>
    </div>
    <div class="form-group">
        <label for="dob">Date of Birth:</label>
        <input type="date" id="dob" name="dob" required>
    </div>
    <div class="form-group">
        <label for="aadhar">ID Proof:</label>
        <input type="text" id="aadhar" name="aadhar" placeholder="Enter Aadhar number" required>
    </div>
    <input type="submit" value="Register">
</form>
</div>
</body>
</html>
