<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Jsp@Jobiak#AnilBoppuri Sir</title>
</head>
<body>
<%!
int a=10;
public int cube(int n)
{
return n*n*n;	
}

ArrayList<String> topics=new ArrayList<>();
%>	
<h1>
<%=new String("Welcome Jobiak Java Giants +Hulks+Marvels"+a) %>>
</h1>
<h2>
<%out.println("We can write Java in tags-which are known as Scriplets/expressions/declartions/comments"); %>
</h2>

<h3>
5^3:
<%=cube(5) %>
</h3>

<h3 align='center'>
<% 
	topics.add("html,css,Js");
	topics.add("Typescript and Angular 10");
	topics.add("Spring,Springboot,Hibernates,JPA");
	topics.add("GIT,JENKINS,JNIT &AWS");
	for(String topic:topics)
	{
	out.println(topic+"<br/>");
	}
	%>	
</h3>
</body>
</html>