<%@page import="bean.Book"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>
    <title>Bookstore</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" type="png" href="003.png"/>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Karma">
    <style>
        body,
        h1,
        h2,
        h3,
        h4,
        h5,
        h6 {
            font-family: "Karma", sans-serif
        }

        .w3-bar-block .w3-bar-item {
            padding: 20px
        }

        #formtimkiem input {
            width: 200px;
            height: 25px;
            border: 2px solid black;
            border-radius: 20px;
            padding: 20px;
            size: 12px;
        }

        a {
            cursor: pointer;  text-decoration: none;
        }
    </style>
</head>

<body>
    <!-- Sidebar (hidden by default) -->
    <nav class="w3-sidebar w3-bar-block w3-card w3-top w3-xlarge w3-animate-left"
        style="display:none;z-index:2;width:20%;min-width:300px" id="mySidebar">
        <a href="javascript:void(0)" onclick="w3_close()" class="w3-bar-item w3-button"> <i class="material-icons"
                style="font-size: 15px; color: #000000;">close</i> Close Menu</a>
		<c:if test="${nd==null&&admin!=1}">
			<a href="dangnhapController" onclick="w3_close()" class="w3-bar-item w3-button"> <i class="material-icons"
                style="font-size: 15px; color: #000000;">login</i> Login</a>
			<a href="dangkyController" onclick="w3_close()" class="w3-bar-item w3-button">Register</a>
		</c:if>
		<c:if test="${nd!=null}">
        <a href="giohangController" onclick="w3_close()" class="w3-bar-item w3-button"> <i class="material-icons"
                style="font-size: 15px; color: #000000;">shopping_cart</i> Cart</a>
        <a href="hoadonController" onclick="w3_close()" class="w3-bar-item w3-button"><i class="material-icons"
                style="font-size: 15px; color: #000000;">receipt_long</i> My Bill</a>
        <a href="dangxuat.jsp" onclick="w3_close()" class="w3-bar-item w3-button"> <i class="material-icons"
                style="font-size: 15px; color: #000000;">exit_to_app</i> Log Out</a>
		</c:if>
		<c:if test="${admin==1}">
		<a href="themsachController" onclick="w3_close()" class="w3-bar-item w3-button"> Create Book</a>
        <a href="dangxuat.jsp" onclick="w3_close()" class="w3-bar-item w3-button"> <i class="material-icons"
                style="font-size: 15px; color: #000000;">exit_to_app</i> Log Out</a>
		</c:if>
    </nav>

    <!-- Top menu -->
    <div class="w3-top">
        <div class="w3-white w3-xlarge" style="max-width:1200px;margin:auto">
            <div class="w3-button w3-padding-16 w3-left" onclick="w3_open()">☰</div>
            <div class="w3-right w3-padding-16" style="font-size: 20px;">
            <c:if test="${nd!=null}">Hello, <c:out value="${nd.getHoTen()}"/></c:if>
            <c:if test="${admin==1}">Welcome admin!</c:if>
            </div>
            <div class="w3-center w3-padding-16">

                <label for="sig" style="font-size: 20px; padding-right: 20px;"><a href="menuController">MY BOOKSTORE</a></label>


            </div>
        </div>
    </div>

    <!-- !PAGE CONTENT! -->
    <div class="w3-main w3-content w3-padding" style="max-width:1200px; margin-top:100px">
	<c:set var="i" value="0"></c:set>
	<% ArrayList<Book> ds = (ArrayList<Book>) request.getAttribute("ds");
		int n = ds.size();
		for(int i=0;i<n;i++){
			if(i%4==0){
	%>
	<div class="w3-row-padding w3-padding-16 w3-center" id="food">
	<%}%>
		<div class="w3-quarter">
               <img src="<%=ds.get(i).getImage() %>" style="width:200px; height: 300px;">
               <c:if test="${admin!=null}"><a href="suasachController?masach=<%=ds.get(i).getId() %>" style="text-decoration: none; margin-bottom: 0; color: #007185;"><h3 style="margin-bottom: 0; color: #007185;"><%=ds.get(i).getTitle() %></h3></a>
               </c:if>
               <c:if test="${admin==null}"><h3 style="margin-bottom: 0; color: #007185;"><%=ds.get(i).getTitle() %></h3></c:if>
               <p style="color: #DF2E38;margin: 0;">$<%=ds.get(i).getPrice() %></p>
               <c:if test="${admin==null}"><a href="giohangController?masach=<%=ds.get(i).getId() %>" style="margin: 0;"><img src="icon-dat-mua.png" style="width:100px;"></a></c:if>
               <c:if test="${admin!=null}"><img src="icon-dat-mua.png" style="width:100px; margin:0;"></c:if>
               <p style="margin: 0; color: #007185; font-size: 15px;">><%for(String s:ds.get(i).getAuthor()) out.print(s+"-");%></p>
               <p style="color: #ea8f31; font-size: 12px; margin: 0;">Year:<%=ds.get(i).getYear() %></p>
               <p style="color: #565959; font-size: 15px; margin: 0;">#<%=ds.get(i).getCategory() %></p>
     </div>
	<%if(i%4==3){%>
		</div>
	<%}%>
	<%}%>
	</div>
	

       
    <script>
        // Script to open and close sidebar
        function w3_open() {
            document.getElementById("mySidebar").style.display = "block";
        }

        function w3_close() {
            document.getElementById("mySidebar").style.display = "none";
        }
    </script>

</body>

</html>