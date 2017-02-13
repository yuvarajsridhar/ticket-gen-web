<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
        <form action="/ticket/replyticket" method="get">
issue id   :<input type="number" name="id"/><br>        
Ticket Id  :<input type="number" name="ticketid" /></br>
Solution   :<input type="text" name="solution" /></br>
 <button type="submit">Submit</button>
</form>
Assign Ticket :<a href="../assignticket.jsp">Assign Ticket</a></br>
       View Ticket :<a href="../viewticket.jsp">View Ticket</a></br>
         Reassign Ticket:<a href="../reassignticket.jsp">Reassign Ticket</a>
          Logout :<a href="../index.jsp">Logout</a>
</body>
</html>