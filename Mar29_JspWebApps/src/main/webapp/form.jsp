<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form Example</title>
</head>
<body>
<h2>Enter  Your Data</h2>
<form>
Enter first name:<input type="text"name="fname"><br/>
Enter email:<input type="text" name="email"><br/>
Enter mobile:<input type="text" name="mobile"><br/>
Click to send data:<input type="submit"value="Send"><br/>
Click to reset data:<input type="reset" value="clean"><br/>
</form>
<hr>
First Name:<%=request.getParameter("fname") %><br/>
		Email:<%=request.getParameter("email") %><br/>
       Mobile:<%=request.getParameter("mobile") %><br/>
<hr/>
</body>
</html>