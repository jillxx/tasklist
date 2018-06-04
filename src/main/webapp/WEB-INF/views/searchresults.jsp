<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">
<title>Search Results</title>
</head>
<body>
<table class="table" border="1">
			<thead>
				<tr>
					<th>Description</th>
					<th>Due Date</th>
					<th>Status</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach var="searchItem" items="${searchTasks}">
					<tr>
						<td>${searchItem.description}</td>
						<td>${searchItem.duedate}</td>
						<td>$ ${searchItem.status}</td>
					</tr>
					<br>
					
				</c:forEach>
			</tbody>
		</table>
</body>
</html>