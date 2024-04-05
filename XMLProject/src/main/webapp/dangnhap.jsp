<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <title>Login to Bookstore</title>
</head>
<body>
	<div style="text-align: left;margin: 0; padding: 15px; height: 80px; width: 100%; background-color: #fff;"><a href="menuController"><img src="003.png" height="50px"></a></div>
    <div class="loginpage" style="background-color: #fff; color: #000">
        <h1 style="color: #000;">Log in to Bookstore</h1>
        <form action="dangnhapController" method="post" id="formdn" style="background-color: #fff; color: #000;">
            <label style="color: #000;" >Email or username:</label> <br>
            <input type="text" placeholder="Email or username" name="usname"> <br>
            <label style="color: #000;">Password:</label> <br>
            <input type="password" placeholder="Password" name="pass"> <br>
            <c:if test="${kt!=null}">
            	<c:out value="${kt}"></c:out>
			</c:if>
            <br>
            <input type="submit" value="Log in" id="smdn" style="background-color: #0073ff;">
        </form>
        <label>Remember me</label>
        <input type="checkbox" id="switch" class="switch-input" />
        <label for="switch" class="switch"></label> <br>
        <a href="#forgot" id="tkm" style="color: #000;">Forgot your password?</a> <br><br><br>
        Don't have an account? <a href="dangkyController" id="tkm" style="color: #000;">Sign up for Bookstore</a>
    </div>
</body>
</html>