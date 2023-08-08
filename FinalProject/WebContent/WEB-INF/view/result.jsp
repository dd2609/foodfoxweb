<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body {
  background-image: url("https://images.unsplash.com/photo-1505682750263-f3f9e519c565?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8OHx8Zm9vZCUyMGJhY2tncm91bmR8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60");
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
}
 .button {
        background-color: #04AA6D;
        border: none;
        color: white;
        padding: 10px 14px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 20px;
        margin: 4px 2px;
        cursor: pointer;
      }
 
</style>
<body>
</br>
<h1 align = "center" style="color:white;">FOOD FOX</h1>
<div class="container" align="center">
<br><br><BR><BR><BR>
            <h1 style="color:white;">Welcome Admin !! </h1>
            <form action = "products" method="post">
            <input type="submit" value="ADD PRODUCTS">
            </form></br>
            <form action = "/FinalProject/admin/viewOrders" method="get">
            <input type="submit" value="VIEW ORDERS">
            <br><br>
            <a href=" /FinalProject/admin/" class="button">Logout</a>
            </form>
        </div>
</body>
</html>