<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${ERROR_MESSAGE}
 <h1>Update Ticket</h1>
  <form action="ticket/updateticket" method="GET">
		Ticket Id : <input type="text" name="ticketid" /></br>
		Subject    : <input type="text" name="subject"/> </br>
		<button type="submit">Submit</button>
		</form>
		CreateTicket:<a href="createticket.jsp">createticket</a><br>
		CloseTicket :<a href="closeticket.jsp">closeticket</a><br>
		ViewTicket  :<a href="viewticket.jsp">viewticket</a><br>
		 Logout :<a href="../index.jsp">Logout</a>
</body>
</html>