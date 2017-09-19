<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring Login Form</title>
</head>
<body>
	<form:form action="/Spring-MVC-LoginForm/registerbatch" method="POST" >

		<div align="center">
			<table>
			
				<tr>
					<td>batch_id</td>
					<td><input type="text" name="batch_id" /></td>
				</tr>
				<tr>
					<td>program</td>
					<td><input type="text" name="program" /></td>
				</tr>
				<tr>
					<td>trainer_name</td>
					<td><input type="text" name="trainer_name" /></td>
				</tr>
				<tr>
					<td>student_count</td>
					<td><input type="text" name="student_count" /></td>
				</tr>
				<tr>
					<td>course</td>
					<td><input type="text" name="course" /></td>
				</tr>
				<tr>
					<td>Created Date</td>
					<td><input type="Date" name="created_date" /></td>
				</tr>
				<tr>
					<td>Updated Date</td>
					<td><input type="Date" name="updated_date" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Submit" /></td>
				</tr>
			</table>
			<div style="color: red">${error}</div>

		</div>
	</form:form>
</body>
</html>