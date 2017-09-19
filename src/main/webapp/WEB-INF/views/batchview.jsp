<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Batches</title>
<link href="css/style1.css" rel="stylesheet">
</head>
<body>
	<a href="#">Home</a>
	<a href="#">Refresh</a>
	<br>
	<h2>${success}</h2>
	<div class="container">
		<label><b>BATCHNO.</b></label> <input type="text" name="batchno">

		<label><b>PROGRAM</b></label> <input type="text" name="program"><br>

		<label><b>SCHEDULE</b></label> <input type="text" name="schedule">

		<label><b>TRAINER</b></label> <input type="text" name="trainer">

		<button type="submit">Search</button>
		<br>

		<div class="container">
			<h3>Batch List</h3>
			<table>
				<c:if test="${!empty msg}">
					<tr>
						<th width="80">Batch ID</th>
						<th width="100">Program</th>
						<th width="100">course</th>
						<th width="100">trainer name</th>
						<th width="100">student_count</th>
						<th width="100">Created date</th>
						<th width="100">updated date</th>
						<th width="60">Edit</th>
						<th width="60">Delete</th>
					</tr>
					<c:forEach items="${msg}" var="batch">
						<tr>
							<td>${batch.batch_id}</td>
							<td>${batch.program}</td>
							<td>${batch.course}</td>
							<td>${batch.trainer_name}</td>
							<td>${batch.student_count}</td>
							<td>${batch.created_date}</td>
							<td>${batch.updated_date}</td>

						</tr>
					</c:forEach>
				</c:if>
			</table>
		</div>
	</div>
</body>
</html>