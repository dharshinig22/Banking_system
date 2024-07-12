

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sing up page</title>
<style>
@import url('https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap');

body{
    background-color:#f0fff0;
    display: flex;
    align-items: center;
    flex-direction: column;
    justify-content: center;
}
h2{
    text-align: center;
    font-family: "Poppins", sans-serif;
    font-weight: 700;
    font-style: normal;
    font-size: 5vh;
}
.container{
    background-color: rgb(192, 228, 228);
    display: flex;
    justify-content: center;
    border-radius: 10px;
    box-shadow: 0 10px 20px rgb(141, 143, 144);
    align-items: center;
    height: 70vh;
    width:600px;
}
label{
    font-family: "Poppins", sans-serif;
    font-weight: 400;
    font-style: normal;
    font-size: 2.5vh;
    
}
input{
    width: 300px;
    margin: 10px;
    height: 20px;
}

</style>

</head>
<body>
<input type="hidden" id="status" value="<%= request.getAttribute("status") %>">
<h2>Sign Up</h2>
<h2><a href ="CustomerLogin.jsp">Login</a></h2>
<div class="container">
<form action="registercustomer" method="post">
        <div class="form-group">
        <label for="username">User Name:</label>
        <input type="text" id="username" name="username" placeholder="enter your name" required><br><br>
        </div>
        <div class="form-group">
        <label for="email">Email ID:</label>
        <input type="email" id="email" name="email" placeholder="Enter your email id" required><br><br>
        </div>
        
        <div class="form-group">
        <label for="phone">Phone Number:</label>
        <input type="text" id="phone" name="phone" placeholder="enter your phone number" required><br><br>
        </div>
        
        <div class="form-group">
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" placeholder="enter your password"  required><br><br>
        </div>
        
        <div class="form-group">
        <label for="address">Address:</label>
        <input type="text" name="address" placeholder="Enter your address"  required/><br><br>
        </div>
        
        <div class="form-group">
        <label for="account_type">Account Type:</label>
        <select name="acc_typ"><option>Current account </option> <option>Savings account</option>
        </select>
        <br><br>
        </div>
        
        <div class="form-group">
        <label for="initial_balance">Initial Balance:</label>
        <input type="text" id="initial_balance" name="initial_balance" placeholder="Enter account balance" required><br><br>
        </div>
        
        <div class="form-group">
        <label for="dob">Date of Birth:</label>
        <input type="date" id="dob" name="dob"   required><br><br>
        </div>
        
        <div class="form-group">
        <label for="aadhar">ID Proof</label>
        <input type="text" id="aadhar" name="aadhar" placeholder="enter aadhar number" required><br><br>
        </div>
  
        <input type="submit" value="Register">

</form>
</div>
</body>
</html>