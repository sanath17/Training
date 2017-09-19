<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link href="css/style.css" rel="stylesheet">
</head>
<body>
	<div class="imgcontainer">
		<img src="images/social.png" alt="Avatar" class="avatar">
	</div>
	<form:form action="/Spring-MVC-LoginForm/login" method="POST">

		<div class="container">

			<h2>Sign in</h2>

			<label><b>Username</b></label> 
			<input type="text" placeholder="Enter Username" name="username" required>
			
			<label><b>Password</b></label>
			<input type="password" placeholder="Enter Password" name="password" required>

			<button type="submit" value="Submit">Login</button>

			<div style="color: red">${error}</div>

		</div>
	</form:form>
</body>
</html>