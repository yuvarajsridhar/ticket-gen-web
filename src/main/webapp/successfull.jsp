<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page import="com.yuvaraj.model.EmployeeDetail" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<% EmployeeDetail ud=(EmployeeDetail) session.getAttribute("employeeid");%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>welcome <%= ud.getName() %></h1>
       <h1>successfull login</h1>
     <h1> ${message}</h1>
       Assign Ticket :<a href="../assignticket.jsp">Assign Ticket</a></br>
       View Ticket :<a href="../viewticket.jsp">View Ticket</a></br>
       Reply Ticket:<a href="../replyticket.jsp">Reply Ticket</a></br>
       Reassign Ticket:<a href="../reassignticket.jsp">Reassign Ticket</a><br>
       Delete ticket:<a href="../deleteticket.jsp">Delete Ticket</a>
       Logout:<a href="../login/logout">Log out</a>
</body>
</html>