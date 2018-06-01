<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">
<title>Your Tasks</title>
</head>
<body>
	<div class="container">
		<h1>Your Tasks</h1>
		<table class="table">
			<thead>
				<tr>
					<th>Task</th>
					<th>Due Date</th>
					<th>Complete</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="task" items="${tasks}">
					<tr>
						<td>${task.description}</td>
						<td>${task.duedate}</td>
						<td><input type="checkbox" name="status" value="status"> Mark as Complete<br>
						<td><a href="delete?id=${task.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>