<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="com.yuvaraj.model.UserDetail" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<% UserDetail ud=(UserDetail) session.getAttribute("userid");%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>welcome <%= ud.getName() %></h1>
 <h1> successfull login</h1>
 CreateTicket : <a href="../createticket.jsp">CreateTicket</a></br>
 UpdateTicket :<a href="../updateticket.jsp">UpdateTicket</a></br>
 CloseTicket  :<a href="../closeticket.jsp">CloseTicket</a></br>
 ViewTicket   :<a href="../viewticket.jsp">ViewTicket</a>
 logout       :<a href="../login/logout">logout</a>
</body>
</html>