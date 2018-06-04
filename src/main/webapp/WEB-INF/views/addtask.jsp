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
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<h2>Add a Task</h2>
	<form action="add">
	
		Description: <input type="text" name="description"><br>
		Due Date: <input type="date" name="duedate">
		<input type ="hidden" name="status" value = "false">
		<input type="hidden" name="userid" value="${userid}" > <input
				type="submit" value="Submit"><br>
		</form>
	</div>
</body>
</html>