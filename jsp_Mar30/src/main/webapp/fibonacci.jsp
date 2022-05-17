<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "java.io.*" import = "java.lang.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h4 align='center'>
<form style="background:pink; border-width:5px; border-style:solid; border-style: inset; height:200px; width:500px">
<h3 align="center">FibonacciSeries App</h3>
Enter Numbers Count:	<input type="text" name="num"><br><br>
<input type="submit" value="Show FibonacciSeries" >
</form>
</h4>
<%
 String s = request.getParameter("num");
 if (s != null) {
%>
<%
    int n=0;
    n=Integer.parseInt(s);
   out.println("No of terms to be printed is  "+n);
%>
<br>
<br>
<br>
The series generated are listed below :<br><br>
<%
    int a=1;
    int b=1;
   out.println(""+a+",\t"+b+",\t");
  for(int i=3;i<= n;i++)
{
    int c=a+b;
   out.print(""+c+",\t");
  a=b;
 b=c;
}
}
%>