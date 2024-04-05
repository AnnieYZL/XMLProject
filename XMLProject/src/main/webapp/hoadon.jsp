<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="dao.BookDao"%>
<%@page import="bean.HoaDon"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.giohangbean"%>
<%@page import="dao.giohangdao"%>
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
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
            cursor: pointer;
            text-decoration: none;
        }
        #formsuasach lable, .formsuasach input {
        	 padding: 15px;
  margin: 20px;
        }
        #formsuasach input {
        	border: 1px solid #727272;
        	border-radius: 5px;
        }
        #smdn{
  background-color: #0144af;
  color: #ffffff;
  border-radius: 5px;
  cursor: pointer;
}
	#buy{
		border-radius: 5px;
		border: none;
		background-color: #0144af;
		color: #fff;
		cursor: pointer;
		padding: 5px;
	}
    </style>
</head>

<body>
    <!-- Sidebar (hidden by default) -->
    <nav class="w3-sidebar w3-bar-block w3-card w3-top w3-xlarge w3-animate-left"
        style="display:none;z-index:2;width:20%;min-width:300px" id="mySidebar">
        <a href="javascript:void(0)" onclick="w3_close()" class="w3-bar-item w3-button"> <i class="material-icons"
                style="font-size: 15px; color: #000000;">close</i> Close Menu</a>
		<c:if test="${nd==null&&admin==null}">
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
    <h3 style="text-align: center; color: #b12704;">YOUR BILL</h3>
     <div STYLE="margin-left: 200px;">
     <%
     BookDao bdao = new BookDao();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		ArrayList<HoaDon> dshd = (ArrayList<HoaDon>)request.getAttribute("dshd");
		int n = dshd.size(); if(n==0){ out.print("Bạn chưa có hóa đơn!");
     %>
     
     <%} %>
     <%if(n>0){ %>
     <table class="table table-hover" style="text-align: center; margin-left: -150px;">
     <tr>
     	<th width="20px">ID</th>
     	<th width="250px">Image</th>
     	<th width="100px">Title</th>
     	<th width="100px">Quantity</th>
     	<th width="100px">Price</th>
     	<th width="100px">Total</th>
     	<th width="200px">Date</th>
     </tr>
				<%
				
				for(HoaDon hd : dshd){
				%>
				<tr>
				<td><%=hd.getMaHoaDon()%></td>
				<td><img src="<%=bdao.inSach(hd.getId()).getImage()%>" width="150px"/></td>
				<td><%=bdao.inSach(hd.getId()).getTitle()%></td>
				<td><%=hd.getSoLuong()%></td>
				<td><%=bdao.inSach(hd.getId()).getPrice()%></td>				
				<td><%=hd.getSoLuong()*bdao.inSach(hd.getId()).getPrice()%></td>
				<td><%=dateFormat.format(hd.getNgayMua()) %></td>
				</tr>
				<%} %>
				</table>
				
				
	<%} %>
     </div>
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