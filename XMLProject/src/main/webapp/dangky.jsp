<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="menu.css">
    <link rel="shortcut icon" type="png" href="003.png"/>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <style>
      body,h1,h2,h3,h4,h5,h6 {font-family: 'Times New Roman', Times, serif }
      body{
        background-color: #fff;
      }
      *{
       color: #000;
      }
    </style>
    <title>Register</title>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	%>
    <div style="text-align: left;margin: 0; padding: 15px; height: 80px; width: 100%;"><a href="menuController"><img src="003.png" height="50px"></a></div>
    <div class="loginpage"  style="background-color: #fff; color: #000">
        <h1 style="color: #000; text-align: left; margin-left: 28%;">Sign up for Bookstore</h1>
        <form action="dangkyController" method="post" id="formdn" style="background-color: #fff; color: #000;">
            <label style="color: #000;">Name</label> <br>
            <input type="text" placeholder="Name" name="ht"> <br>
            <label style="color: #000;">Username:</label> <br>
            <input type="text" placeholder="Username" name="tdn"> <br>
            <label style="color: #000;">Password:</label> <br>
            <input type="password" placeholder="Password" name="mk"> <br>
            <%if(request.getAttribute("tb")!=null) out.print(request.getAttribute("tb")); %>
            <br>
            <input type="submit" value="Sign up" id="smdn" style="background-color: #0073ff;">
        </form>
        Already have an account? <a href="dangnhapController" id="tkm"  style="color: #000">Log in here</a>
    </div>
</body>
</html>