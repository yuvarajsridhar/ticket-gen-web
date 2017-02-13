<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Employee Register</h3>
<h2>${ERROR_MESSAGE}</h2>
 <form action="login/employeeregistration" method="GET">
		EmployeeId : <input type="text" name="employeeid"  /><br>
		 Name : <input type="text" name="employeename"  /><br>
			EmailId:<input type="text" name="emailid"/><br>
			Password:<input type="password" name="password" /><br>
			Department:<select name="department">
		<option value="1">admin</option>
		<option value="2">software</option>
		<option value="3">hardware</option>	</select><br>
		Role:<select name="role">
		<option value="1">admin</option></select>
				
		<button type="submit">Submit</button>
		
     </form>
</body>
</html>