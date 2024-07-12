<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>HOME PAGE</title>
<style>
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;600;700&display=swap');

body {
    background-color: #f0fff0;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    height: 100vh;
    margin: 0;
    font-family: 'Poppins', sans-serif;
}

h2 {
    font-size: 3em;
    color: #333;
    margin-bottom: 20px;
}

a {
    display: inline-block;
    text-decoration: none;
    font-size: 1.5em;
    color: white;
    background-color: #333;
    padding: 10px 20px;
    border-radius: 5px;
    margin: 10px 0;
    transition: background-color 0.3s;
}

a:hover {
    background-color: #555;
}

.container {
    text-align: center;
}
</style>
</head>
<body>
<div class="container">
    <h2>EBANK</h2>
    <a href="CustomerRegister.jsp">Customer</a><br><br>
    <a href="Adminlogin.jsp">Admin</a>
</div>
</body>
</html>
