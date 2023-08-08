<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Page</title>
</head>
<style>
.topnav {
  background-color: #333;
  overflow: hidden;
}

/* Style the links inside the navigation bar */
.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

/* Change the color of links on hover */
.topnav a:hover {
  background-color: #ddd;
  color: black;
}

/* Create a right-aligned (split) link inside the navigation bar */
.topnav a.split {
  float: right;
  background-color: #04AA6D;
  color: white;
}

body {
  background-image: url("https://images.unsplash.com/photo-1490818387583-1baba5e638af?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTB8fHNpbXBsZSUyMGZvb2QlMjBiYWNrZ3JvdW5kfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60");
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
}

table{
background-color:"yellow";
font-size:"23px";
}

</style>
<body>
<form modelAttribute="email" method="get">
	<h1 align="center">FOOD FOX</h1>
	<div class="topnav">
  <a class="active" href="#home">Home</a>
  <a href="#contact">My Orders</a>
  <a href="/FinalProject/login" class="split">Logout</a>
</div>
	<br/>
	<div>
	<form modelAttribute="products" method="get">
	<table bgcolor="yellow" align="right" cellspacing="10px" cellpadding="10px">
	<tr>
						<th>PRODUCT NAME</th>
						<th>IMAGE </th>
						<th>PRICE</th>
						<th>DESCRIPTION</th>
						
					</tr>
	<c:forEach items="${products}" var="prod" >
					
					<tr>
						<form action="/FinalProject/AddToCart?productId=${prod.productId}&email=${useremail}" method="POST">
							<td>${prod.productName}</td>
							<td style="width: 171px">
							<img src="${prod.imageUrl}" width="100px" height="100px" />
							</td>
							<td>${prod.price}</td>
							<td style="width: 180px">${prod.description}</td>
							<%-- <td ng-controller="myController"><a
								href="getProductById/${prod.productId}" class="btn btn-info"
								role="button"> <span class="glyphicon glyphicon-info-sign"></span></a>
							</td> --%>
							<td>
								<button type="submit">Buy Now</button>
							</td>
						</form>
						</tr>
		</c:forEach>
		
	</table>
	</form>
	</div>
	</form>
</body>
</html>