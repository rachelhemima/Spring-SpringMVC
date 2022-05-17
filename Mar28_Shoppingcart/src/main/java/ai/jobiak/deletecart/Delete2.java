package ai.jobiak.deletecart;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ai.jobiak.cart.Product;

@WebServlet("/dcart2")
public class Delete2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Delete2() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	private ArrayList<Product> getProductIds()
	{
		String userName = "root";
		String password = "admin";
		String url = "jdbc:mysql://localhost:3306/employee";
			//String productIds[]=new String[10];
		Connection con=null;
		ArrayList<Product> productList=new ArrayList<>();
		try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				 con = DriverManager.getConnection(url,userName, password);
					Statement st=con.createStatement();
					String sql="select* from products";
					ResultSet rs=st.executeQuery(sql);
	while(rs.next())
	{
	Product p=new Product(rs.getString(1),rs.getString(2),rs.getDouble(3));
	productList.add(p);
	} 
	}catch (Exception e) 
	{ 
		 e.printStackTrace(); 
		 }
		finally {
			if(con!=null)
			{
				try{
					con.close();
				}catch (Exception e) { 
					 e.printStackTrace(); 
					 }
			}
		}
		return productList;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();// .append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		
		ArrayList<Product> itemsList=null;
		itemsList=getProductIds();
		out.println("<hr/>");
		for(int i=0;i<itemsList.size();i++){
			out.println("<a href='dcart2?item="+itemsList.get(i).getProductId()+"'>Delete Items  :"+itemsList.get(i).getProductId()+"</a></br>");
		}	
		out.print("<hr/>");
	//	System.out.println(ProductId);
	
	     HttpSession shoppingCart=request.getSession(); 
	 	ArrayList<Product> selectedItemsList = null;
			 String queryStr=request.getQueryString();
				//System.out.println(queryStr);
				String splitArray[]=queryStr.split("=");
				String ProductId=splitArray[1];
				
				 for(int i=0;i<itemsList.size();i++) {
					   if(itemsList.get(i).getProductId().equals(ProductId)) {
				selectedItemsList=(ArrayList<Product>)shoppingCart.getAttribute("items");
				if(selectedItemsList!=null) {
					

			//out.println(itemsList.get(i));
				selectedItemsList.remove(i);		
				     shoppingCart.setAttribute("items", selectedItemsList);
			break;			   
			}
	      }
	      }	
 for(Product p:selectedItemsList){
			out.println(p.getProductId()+"::"+p.getDescription()+"::"+p.getPrice()+"</br>");
		}
 out.println("<hr/>");
		out.println("<h3><br/>Deleted items in the cart #"+selectedItemsList.size());	
		
	      }
	}

