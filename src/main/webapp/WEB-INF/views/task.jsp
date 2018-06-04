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
<title>Your Tasks</title>
<script>
	function ready(callback) {
		// in case the document is already rendered
		if (document.readyState != 'loading')
			callback();
		// modern browsers
		else if (document.addEventListener)
			document.addEventListener('DOMContentLoaded', callback);
	}

	ready(function checkStatus() {
		// this happens after the DOM is loaded
		if (document.getElementsByTagName('input') != null
				&& document.getElementsByTagName('input').length > 0) {
			// get the total number of checkboxes and loop through each one to change its checked value
			var l = document.getElementsByTagName('input').length;
			for (var i = 0; i < l; i++) {
				var elm = document.getElementsByTagName('input')[i];
				elm.checked = (elm.name == 'true') ? true : false;
			}
		}
	});
</script>

</head>
<body>
<br>
		<form action="/search">

			<h4>
				Please enter the product you want:<input type="text" name="name" />

				<button type="submit" class="btn btn-primary">Search!</button>
			</h4>
		</form>
		<br> <br>

	<div class="container">				
		<h1>Your Tasks</h1>
		<table class="table" id="table1">
			<thead>
				<tr>
					<th>Task</th>
					<th>Due Date</th>
					<th>Mark as Complete</th>
					<th>Delete</th>
				</tr>
			</thead>
				<tbody>
			
				<c:forEach var="task" items="${tasklist}">
					<tr>
						<td>${task.description}</td>
						<!-- 						<td> 2018-06-01	</td>  -->
						<td><fmt:parseDate value="${task.duedate}" var="parsedDate"
								pattern="yyyy-MM-dd" />${parsedDate}</td>
						<td><input type="checkbox" name="status" onclick="location.href='/changestatus?status=" + ${task}></td>
						<td><a type="button" href="delete?idtask=${task.idtask}&email=${task.email}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		
		</table>
		<form action ="addtask">
		<input type = "hidden" name = "email" value ="${email}"></input>
		
		<button type="submit">Add a task</button>
		</form>

	</div>
</body>
</html>