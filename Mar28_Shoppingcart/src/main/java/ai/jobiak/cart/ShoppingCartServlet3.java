package ai.jobiak.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShoppingCartServlet
 */
@WebServlet("/cart3")
public class ShoppingCartServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String[] productPrice = null;

	public ShoppingCartServlet3() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private String[] getProductIds()
	{
		String userName = "root";
		String password = "admin";
		String url = "jdbc:mysql://localhost:3306/employee";
       String productIds[]=new String[10];
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,userName, password);
			Statement st=con.createStatement();
			String sql="select productId from products";
			ResultSet rs=st.executeQuery(sql);
	int i=0;
	while(rs.next())
	{
		productIds[i]=rs.getString(1);	
		i++;
	} 
	}catch (Exception e) 
	{ 
		 e.printStackTrace(); 
		 }
				return productIds;
	}
	private String[] getDescriptions() {
		String userName = "root";
		String password = "admin";
		String url = "jdbc:mysql://localhost:3306/employee";
       String productDesc[]=new String[10];
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,userName, password);
			Statement st=con.createStatement();
			String sql="select description from products";
			ResultSet rs=st.executeQuery(sql);
	int i=0;
	while(rs.next())
	{
		productDesc[i]=rs.getString(2);	
		i++;
	} 
	}catch (Exception e) 
	{ 
		 e.printStackTrace(); 
		 }
				return productDesc;
	}
	private double[] getPrices() {
		String userName = "root";
		String password = "admin";
		String url = "jdbc:mysql://localhost:3306/employee";
       double[] productPrice=new double[10];
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,userName, password);
			Statement st=con.createStatement();
			String sql="select price from products";
			ResultSet rs=st.executeQuery(sql);
	int i=0;
	while(rs.next())
	{
		productPrice[i]=rs.getDouble(1);	
		i++;
	} 
	}catch (Exception e) 
	{ 
		 e.printStackTrace(); 
		 }
				return productPrice;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();// .append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		
		String productIds[]=getProductIds();
		String productDesc[]=getDescriptions();
		double[] productPrice=getPrices();
		for(int i=0;i<productIds.length;i++)
		{
			out.println("<a href='cart3?item="+productIds[i]+"'>Add Items  :"+productIds[i]+"</a></br>");
		}	
		ArrayList<Product> itemList = null;	
		HttpSession shoppingCart=request.getSession(); 
		if(shoppingCart.isNew()) 
		{
		 itemList=new ArrayList<>();
		 shoppingCart.setAttribute("items",itemList );
		 }
		 else
		 {
			 String queryStr=request.getQueryString();
				//System.out.println(queryStr);
				String splitArray[]=queryStr.split("=");
				String ProductId=splitArray[1];
	
			//	String ProductDesc=splitArray[2];
			//	System.out.println(ProductId);
			 itemList=(ArrayList<Product>)shoppingCart.getAttribute("items");
			 itemList.add(new Product(ProductId,"Products",90.0));
		     shoppingCart.setAttribute("items", itemList);
		 }
		for(Product p:itemList)
		{
			out.println(p.getProductId()+"::"+p.getDescription()+"::"+p.getPrice()+"</br>");
		}
		out.println("<h3>Items in the cart"+itemList.size());
		 }



	}

