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
  background-image: url("https://media.istockphoto.com/id/1333723812/photo/top-view-photo-of-halloween-decorations-pumpkin-baskets-candy-corn-straws-spiders-web-bats.jpg?b=1&s=170667a&w=0&k=20&c=93TmN31LhY9xF2-TkxN5W5acMvRZLys--qXBFyF209I=");
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
}

</style>
<body>
</br></br>
<br/></br>
</br></br>
<br/></br></br>
<div class="container" align ="center">
			<h1 id="form_header" class="text-warning" align="center">FOOD FOX</h1>
            <h3 id="form_header" class="text-warning" align="center">Admin Login</h3>
            <div> </div>
     
            <!-- User input form to validate a user -->
           
            <form  action="product" method="post" >
                
                    <label for="email">  Email:  </label>
                    <input type="text"  id="email" name="email">
                <br/><br>
                
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password">
                <br/><br>
                <button type="submit" class="btn btn-primary">Login</button>
            
            </form>
            <br><br>
            <b style ="color:red">${msg }</b>
       
</body>
</html>