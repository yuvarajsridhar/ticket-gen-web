<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<form action="/ticket/viewticket">
		UserId <input type="text" name="userId" value=${variable}>
		<button type="submit">Submit</button>
	</form>
	<h2>Ticket</h2>
	<table border="1">
		<thead>
			<tr>
				<th>id</th>
				<th>user</th>
				<th>department</th>
				<th>subject</th>
				<th>description</th>
				<th>priority</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="c" items="${Error_Message}" varStatus="i">
				<tr>
					<td>${c.id}</td>
					<td>${c.userId.id}</td>
					<td>${c.departmentId.id}</td>
					<td>${c.subject}</td>
					<td>${c.description}</td>
					<td>${c.priority}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
CloseTicket:<a href="../closeticket.jsp">closeticket</a></br>
		CreateTicket:<a href="../createticket.jsp">createticket</a></br>
		updateTicket:<a href="../updateticket.jsp">updateticket</a>
</body>

</html>