<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h4 align='center'>
<form style="background:pink; border-width:5px; border-style:solid; border-style: inset; height:200px; width:500px">
<h3 align="center">Armstrong App</h3>
Enter number:<input type="text" name="number">
<input type="submit" value="Check">
</form>
</h4>
<%
String input=request.getParameter("number");
if(input!=null){
int num=Integer.parseInt(input);
int i = num;
int number=0,remainder;
while(num > 0){
remainder = num % 10;
number = number + (int)Math.pow(remainder,3);
num = num / 10;
}
if(number == i){
out.println(i+" is an Armstrong Number");
}
else{
out.println(i+" is not a Armstrong Number");
}
}
%>
</body>
</html>