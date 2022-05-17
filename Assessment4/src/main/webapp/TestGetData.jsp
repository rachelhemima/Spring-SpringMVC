<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="ai.jobiak.bean.Usage"%>
    <%@page import="java.util.ArrayList"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Row To Java Objects</title>
</head>
<body>
<%!String userName = "root";
String password = "admin";
String url = "jdbc:mysql://localhost:3306/employee";%>
<%!private ArrayList<Usage> getProductIds() {
	String userName = "root";
	String password = "admin";
	String url = "jdbc:mysql://localhost:3306/employee";
	Connection con = null;
	ArrayList<Usage> productList = new ArrayList<>();
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, userName, password);
		Statement st = con.createStatement();
		String sql = "select *from products";
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			Usage p = new Usage(rs.getString(1), rs.getString(2), rs.getDouble(3));
			productList.add(p);
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	return productList;
}%>
<%
ArrayList<Usage> List1=null;
HttpSession displayData=request.getSession(); 
	ArrayList<Usage> dataItemsList = null;
 
	if(displayData.isNew()) {
		dataItemsList=new ArrayList<>(); 
	 displayData.setAttribute("items",dataItemsList );
 }
  else {
	 String queryStr=request.getQueryString();
		//System.out.println(queryStr);
		String splitArray[]=queryStr.split("=");
		String ProductId=splitArray[1];
		
   for(int i=0;i<List1.size();i++) {
	   if(List1.get(i).getProductId().equals(ProductId)) //condition
	   {
		   dataItemsList=(ArrayList<Usage>)displayData.getAttribute("items");
		   dataItemsList.add(List1.get(i));		
displayData.setAttribute("items", dataItemsList);
break;
	   }
  }
  }	
for(Usage p:dataItemsList){
	out.println(p.getProductId()+"::"+p.getDescription()+"::"+p.getPrice()+"</br>");
}
%>
</body>
</html>