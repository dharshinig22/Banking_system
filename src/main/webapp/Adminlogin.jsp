<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin login</title>
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
    height: 30px;
}

</style>
</head>
<body>
<h2>Admin page</h2>
<div class="container">
<form action="adminlogin" method="post">
<label>User Name:</label>
<input type="text" name="admin_name" placeholder="enter admin user"/><br><br>
<label>Password:</label>
<input type="text" name="admin_pass" placeholder="enter admin user"/><br><br>
<input type="submit" value="submit"/>
</form>
</div>
</body>
</html>