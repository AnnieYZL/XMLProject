<%@page import="dao.BookDao"%>
<%@page import="dao.giohangdao"%>
<%@page import="java.util.logging.Handler"%>
<%@page import="bean.giohangbean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	giohangdao gh2 = (giohangdao)session.getAttribute("gh");
	
	//Xoa chon
	String[] gtc = request.getParameterValues("c1");
	if(gtc!=null){
		for(String c:gtc){
			gh2.Xoa(Long.parseLong(c));
		}
	int n=gh2.ds.size();
	session.setAttribute("gh", gh2);
	if(n==0) response.sendRedirect("menuController");
	else	response.sendRedirect("giohangController");
	}
	
	
	//Sua so luong
	String ms = request.getParameter("but1");
	BookDao bdao = new BookDao();
	if(ms!=null){
	String sl = request.getParameter(ms);
	gh2.Them(bdao.inSach(Long.parseLong(ms)), 1);
	session.setAttribute("gh", gh2);
	response.sendRedirect("giohangController");
	}
	
	//Xoa tat ca
	else if(request.getParameter("but-xoa-all")!=null){
		session.removeAttribute("gh");
		response.sendRedirect("menuController");
	}


	
	%>
</body>
</html>