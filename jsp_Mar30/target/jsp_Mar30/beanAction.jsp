<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BeanAction</title>
</head>
<body>
<h3 align="center">
<form  action="beanAction.jsp">
Enter First Name:<input type="text" name="fname"placeholder=" fisrt name"></br>
Enter Email         :<input type="text" name="email" placeholder="enter mail"></br>
Enter Mobile       :<input type="text" name="mobile"placeholder="+91 "></br>
<input type="submit" value="signUp">
<input type="reset" value="clear">
</form>
</h3>
<h3>check...</h3>
<jsp:useBean id="userBean" class="ai.jobiak.model.User" scope="request"></jsp:useBean>
<jsp:setProperty  property="fname" name="userBean" param="fname"/>
<jsp:setProperty  property="email" name="userBean" param="email"/>
<jsp:setProperty  property="mobile" name="userBean" param="mobile"/>
<hr>
<jsp:forward page="showBeanData.jsp" ></jsp:forward>
<hr>
</body>
</html>