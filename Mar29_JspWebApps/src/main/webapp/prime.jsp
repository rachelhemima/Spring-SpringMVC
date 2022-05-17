<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>prime number</title>  
</head>  
<body>
<h3>Prime Or Not Check</h3> 
<h4 align='center'>
<form style="background:yellow; border-width:5px; border-style:solid; border-style: inset; height:100px; width:600px">
Enter Number<input type="text" name="value"  ><br><br>
<input type="submit" placeholder="evaluate">
</form> 
</h4>
<%
if(request.getParameter("value")!=null){
String str = request.getParameter("value");
Integer n = Integer.valueOf(str);
  int i,m=0,flag=0;      
  m=n/2;      
  if(n==0||n==1){  
   out.println(n+" is not prime number");      
  }else{  
   for(i=2;i<=m;i++){      
    if(n%i==0){      
     out.println(n+" is not prime number");      
     flag=1;      
     break;      
    }      
   }      
   if(flag==0)  { out.println(n+" is prime number"); }  
  }//end of else  
}
%>
</body>  
</html>