<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Assign Ticket</h1>
<center>
<div style="text-align:center;">

<form action="/ticket/assignticket" method="get">
Ticket Id  :<input type="number" name="ticketid" /></br>
Employee Id:<input type="number" name="employeeid" /></br>
 <button type="submit">Submit</button>

</form>

  View Ticket :<a href="../viewticket.jsp">View Ticket</a></br>
       Reply Ticket:<a href="../replyticket.jsp">Reply Ticket</a></br>
       Reassign Ticket:<a href="../reassignticket.jsp">Reassign Ticket</a>
        Logout :<a href="../index.jsp">Logout</a>
</div>
</center>
</body>
</html>