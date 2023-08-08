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
	<h1 align="center">FOOD FOX</h1>
	<div class="topnav">
  <a class="active" href="#home">Home</a>
  <a href="#contact">My Orders</a>
  <a href="/FinalProject/login" class="split">Logout</a>
</div>
	
<div class="page-title">Confirmation</div>
 
 
 
  <div class="customer-info-container">
      <h3>Product Information:</h3>
      <form action="/FinalProject/purchase" method="post">
      <input type="hidden" name="code" value="${product.code}"/>
      <ul>
          <li>Name: ${product.productName}</li>
          <li>Price: <fmt:formatNumber value="${product.price}" type="currency"/></li>
          <li>Quantity:<input type="number" min="1" max="${product.quantity}" value="1" step="1" name="quantity" onfocus="this.blur();"/></li>
      </ul>
      <input type="submit" value="Purchase"/>
      </form>
  </div>

</body>
</html>