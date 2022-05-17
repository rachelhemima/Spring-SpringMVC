<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Give Your Data</title>
</head>
<body>
    <jsp:useBean id="userBean" class="ai.jobiak.bean.UserData" scope="page">
       <jsp:setProperty   property="fname"   name="userBean"  param="fname"/>
       <jsp:setProperty property="lname" name="userBean"  param="lname"/>
       <jsp:setProperty   property="mobile"   name="userBean"  param="mobile"/>
      <jsp:setProperty property="mailId" name="userBean"  param="mailId"/>
        <jsp:setProperty  name="userBean"  property="method"/>
      </jsp:useBean>
<% userBean.insert();%>
  <hr>
  <jsp:forward page="showDataBean.jsp"></jsp:forward>
</body>
</html>