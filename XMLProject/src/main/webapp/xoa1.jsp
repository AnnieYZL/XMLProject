<%@page import="dao.giohangdao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
		giohangdao gh2 = (giohangdao)session.getAttribute("gh");
		String masach = request.getParameter("ms");
		gh2.Xoa(Long.parseLong(masach));
		int n=gh2.ds.size();
		session.setAttribute("gh", gh2);
		if(n==0) response.sendRedirect("menuController");
		else response.sendRedirect("giohangController"); 
%>
		
</body>
</html>