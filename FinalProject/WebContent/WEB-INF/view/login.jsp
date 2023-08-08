<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
<h3 align="center">${headerMessage}</h3>
<b><h1 align="center">FOOD FOX</h1></b>
<div align ="center">
	<form:form action="/FinalProject/loginSuccess" method="post" modelAttribute="login">

		<table>
			<tr>
				<td>Enter Email:</td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssClass="error"/></td>
			</tr>
			<tr>
			<br>
				<td><br>Enter Password:<br></td>
				<td>
				<br><form:password path="password"/></td>
				<td><form:errors path="password" cssClass="error"/></td>
			</tr>

			<tr>
				<td>
				</br>
				<input type="submit" value="Login"></td>
			</tr>
		</table>
	</form:form>
	</div>
</body>
</html>