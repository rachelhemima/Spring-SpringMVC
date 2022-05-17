<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>calculator</title>
</head>
<body>
<h4 align='center'>
<form action="calculator" style="background:yellow; border-width:5px; border-style:solid; border-style: inset; height:200px; width:600px">
<h3 align="center">Calculator App</h3>
Enter First Number <input type="text" name="txtN1"><br>
Enter Second Number <input type="text" name="txtN2" ><br>
Select an Operation<input type="radio" name="opr" value="+">
ADDTION <input type="radio" name="opr" value="-">
SUBSTRACTION <input type="radio" name="opr" value="*">
MULTIPLY <input type="radio" name="opr" value="/">
DIVIDE <br><input type="reset">
<input type="submit" value="Calculate" >
</h4>
</form>
<hr/>
<% 
if(request.getParameter("txtN1")!=null){
String fnum=request.getParameter("txtN1");
String snum=request.getParameter("txtN2");
int n1=Integer.parseInt(fnum);  
int n2=Integer.parseInt(snum);  

String opr=request.getParameter("opr");
double result=0;
if(opr.equals("+")) result=n1+n2;
if(opr.equals("-")) result=n1-n2; 
if(opr.equals("*")) result=n1*n2; 
if(opr.equals("/")) result=n1/n2; 

out.println("<h1> Result = "+result); 
 out.println("</body></html>");
} 
 %>

First Number:<%=request.getParameter("txtN1") %><br/>
Second Number:<%=request.getParameter("txtN2") %><br/>

</body>
</html>