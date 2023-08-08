<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order List</title>
<style>
html {
    background: white;
}
h3 {
    margin: 0px;
    padding: 0px;
}
body {
    max-width: 860px;
    min-width: 360px;
    margin: 0px auto;
    background: #F8F8F8;
    padding:0px 5px;
    text-align:center;
}
 
.page-title  {
    font-size:120%;
    text-align: left;
    margin:10px 0px;
}
.header-container {
    text-align: left;
    border-bottom: 1px solid #ccc;
    position: relative;
    background: #5f5f5f;
    color: white;
}
.header-container .header-bar  {
    position: absolute;
    right: 10px;
    bottom: 20px;
}
.header-container .header-bar  a  {
    color: white;
    font-size: bold;
}
 
.footer-container {
    text-align: center;
    margin-top: 10px;
    padding: 5px 0px 0px 0px;
    border-top: 1px solid #ccc;
}
.menu-container {
    text-align: right;
    margin: 10px 5px;
}
.menu-container a {
    margin: 5px 5px 5px 10px;
    color: #004d99;
    font-weight: bold;
    text-decoration: none;
}
 
.site-name {
    font-size:200%;
    margin:10px 10px 10px 0px;
    padding: 5px;
}
 
.container  {
    margin: 5px 0px;
}
 
.demo-container, .login-container, .account-container {
    padding: 5px;
    border: 1px solid #ccc;
    text-align:left;
    margin:20px 0px;
}
 
.customer-info-container {
    text-align: left;
    border: 1px solid #ccc;
    padding: 0px 5px;
}
.product-preview-container {
    border: 1px solid #ccc;
    padding: 5px;
    width: 250px;
    margin: 10px ;
    display: inline-block;
    text-align:left;
}
 
.product-preview-container input {
    width: 50px;
}
 
ul {
    list-style-type: none;
    padding-left: 5px;
    margin:5px;
}
 
 
.navi-item {
    margin: 5px 5px 5px 20px;
}


.error-message {
    font-size: 90%;
    color: red;
    font-style: italic;
}
table td {
    padding: 5px;
}
</style>
</head>
<body>
   <div class="page-title">Order List</div>
   <table border="1" style="width:100%">
       <tr>
           <th>Order Num</th>
           <th>Order Name</th>
           <th>Order Price</th>
           <th>Order Date</th>
           <th>Order Quantity</th>
           <th>Amount</th>
       </tr>
       <c:forEach items="${list}" var="order">
           <tr>
               <td>${order.orderNum}</td>
               <td>${order.product.name}</td>
               <td> <fmt:formatNumber value="${order.product.price}" type="currency"/></td>
               <td>
                  <fmt:formatDate value="${order.orderDate}" pattern="dd-MM-yyyy HH:mm"/>
               </td>
               <td>${order.quantity}</td>
               <td style="color:red;">
                  <fmt:formatNumber value="${order.amount}" type="currency"/>
               </td>
           </tr>
       </c:forEach>
   </table>
</body>
</html>