<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Form</title>
</head>
<body>
    <jsp:useBean id="userBean" class="ai.jobiak.bean.UserData" scope="request"></jsp:useBean>
<h3>Your Data is <br>
    Full Name:<jsp:getProperty property="fname" name="userBean"/><br>
    Last Name:<jsp:getProperty property="lname" name="userBean"/><br>
    Mobile:<jsp:getProperty property="mobile" name="userBean"/>
    Email :<jsp:getProperty property="mailId" name="userBean"/><br>
  </h3>
</body>
</html>