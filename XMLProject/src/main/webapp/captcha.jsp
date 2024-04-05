<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
	body{
		background-color: #fff;
		color: #000;
	}
</style>
<title>CAPTCHA</title>
</head>
<body>

	<center>
		<h3>CAPTCHA </h3>
	<img src="simpleCaptcha.jpg" />
	<form action="captchaController" method="post">
	<input type="text" name="answer" /><br>
	<input type="submit" value="Submit"></form>
	<%if(request.getAttribute("notice")!=null) out.print(request.getAttribute("notice"));%>
	</center>
</body>

</html>
