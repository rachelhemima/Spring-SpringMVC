<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="ai.jobiak.cart.Product"%>
    <%@page import="java.util.ArrayList"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shopping Cart</title>
</head>
<body>
<%!
float total=0;
private ArrayList<Product> getProductIds()
{
		String userName = "root";
		String password = "admin";
		String url = "jdbc:mysql://localhost:3306/employee";
		Connection con=null;
		ArrayList<Product> productList=new ArrayList<>();
		try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				 con = DriverManager.getConnection(url,userName, password);
					Statement st=con.createStatement();
					String sql="select *from products";
					ResultSet rs=st.executeQuery(sql);
	while(rs.next())
	{
	Product p=new Product(rs.getString(1),rs.getString(2),rs.getDouble(3));
	productList.add(p);
	} 
	}catch (Exception e) { 
		 e.printStackTrace(); 
		 }
		finally {
			if(con!=null){
				try{
					con.close();
				}catch (Exception e) { 
					 e.printStackTrace(); 
					 }
			}
		}
		return productList;
	}
%>
	<hr/>
<% 
	ArrayList<Product> itemsList=null;
		itemsList=getProductIds();	
		for(int i=0;i<itemsList.size();i++){
			out.println("<a href='delete.jsp?item="+itemsList.get(i).getProductId()+"'>Delete  Items  :"+itemsList.get(i).getProductId()+"</a></br>");
		}	
		 HttpSession shoppingCart=request.getSession(); 
		 	ArrayList<Product> selectedItemsList = null;
		 	try{
/* 		if (request.getQueryString()!=null) //to avoid NullPointer Exception
		      { */
				 String queryStr=request.getQueryString();
					//System.out.println(queryStr);
					String splitArray[]=queryStr.split("=");
					String ProductId=splitArray[1];
					
					 for(int i=0;i<itemsList.size();i++) {
						   if(itemsList.get(i).getProductId().equals(ProductId)) {
					selectedItemsList=(ArrayList<Product>)shoppingCart.getAttribute("items");
					
					if(selectedItemsList!=null) {
					selectedItemsList.remove(i);		
					     shoppingCart.setAttribute("items", selectedItemsList);
					}
				break;
					}
				   }
		      
		      
	 for(Product p:selectedItemsList){
				out.println(p.getProductId()+"::"+p.getDescription()+"::"+p.getPrice()+"</br>");
			}
		 	}catch(Exception e){}
     %>
	<hr/>	
	<%
out.println("<h3><br/>Deleted items in the cart #"+selectedItemsList.size());	
%>
	   
</body>
</html>