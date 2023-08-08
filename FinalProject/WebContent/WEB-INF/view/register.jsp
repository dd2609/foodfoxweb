<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>

<style>
body {
  background-image: url("https://media.istockphoto.com/id/1425236963/photo/microphone-smartphone-supermarket-trolley-and-pumpkin-on-pink-background.jpg?b=1&s=170667a&w=0&k=20&c=hUF7X7VcLxjAA4mCm1oJAc-baUffA7NzPECu1hWmOWM=");
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
}

</style>
</head>
<body>
<b><h1 align="center">FOOD FOX</h1></b>
	<form:form action="/FinalProject/registerSuccess"
		method="post" modelAttribute="user">
		<table align="center">
		<h3 align="center">User registration form</h3>
			<tr>
				<td>Enter Email:</td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Enter Phone No:</td>
				<td><form:input path="mobileNumber"/></td>
				<td><form:errors path="mobileNumber" cssClass="error"/></td>

			</tr>
			<tr>
				<td>Enter Password:</td>
				<td><form:password path="password"/></td>
				<td><form:errors path="password" cssClass="error"/></td>
			</tr>

			<tr>
				<td>Enter your Name:</td>
				<td><form:input path="username"/></td>
				<td><form:errors path="username" cssClass="error"/></td>
			</tr>
			<tr>
				<td>
				</br>
				<input type="submit" value="Register"></td>
			</tr>
			
		</table>
	</form:form>
	</br>
	<div align="center">
	<b>Already a User ?? </b><a href="/FinalProject/login">Login</a>
	</div>

</body>
</html>