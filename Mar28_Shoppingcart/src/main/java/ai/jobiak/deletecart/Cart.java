package ai.jobiak.deletecart;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ai.jobiak.cart.Product;

/**
 * Servlet implementation class Cart
 */
@WebServlet("/getCart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
					String sql="select *from products";
					ResultSet rs=st.executeQuery(sql);
	while(rs.next())
	{
	Product p=new Product(rs.getString(1),rs.getString(2),rs.getDouble(3));
	productList.add(p);
	//add(p);
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
		double total=0;
		ArrayList<Product> itemsList=null;
		itemsList=getProductIds();
	out.println("<h3>Select Items To Add into the Cart!!!<h3>");
		for(int i=0;i<itemsList.size();i++){
			out.println("<a href='getCart?item="+itemsList.get(i).getProductId()+"'>Add Items  :"+itemsList.get(i).getProductId()+"</a></br>");
		}	
		out.print("<hr/>");
	//	System.out.println(ProductId);
	
	     HttpSession shoppingCart=request.getSession(); 
	 	ArrayList<Product> selectedItemsList = null;
	     if(shoppingCart.isNew()) {
	    	 selectedItemsList=new ArrayList<>(); 
		 shoppingCart.setAttribute("items",selectedItemsList );
		 }
	      else {
			 String queryStr=request.getQueryString();
				//System.out.println(queryStr);
				String splitArray[]=queryStr.split("=");
				String ProductId=splitArray[1];
				
		   for(int i=0;i<itemsList.size();i++) {
			   if(itemsList.get(i).getProductId().equals(ProductId)) {
		selectedItemsList=(ArrayList<Product>)shoppingCart.getAttribute("items");
		selectedItemsList.add(itemsList.get(i));		
		     shoppingCart.setAttribute("items", selectedItemsList);
		 	if(selectedItemsList!=null) {
				selectedItemsList.remove(i);		
				     shoppingCart.setAttribute("items", selectedItemsList);
			break;
			   }
			   }
	      }
	      }	
	    out.println("<h2>Cart</h2>");
 for(Product p:selectedItemsList){
			out.println(p.getProductId()+"::"+p.getDescription()+"::"+p.getPrice()+"</h3></br>");
			total+=p.getPrice();
		}
 out.println("<hr/>");
		out.println("<h3>Items Added in the cart #"+selectedItemsList.size());	
		out.println("<h3>Total Cost of Items::"+total+"</h3>");
		   out.println("<h2><a href='cart'>Click to Delete items from cart</h2></a></br>");
	out.println("<h3>Select Items to delete from cart!!!!<h3>");
	for(int i=0;i<=itemsList.size();++i){
		out.println("<a href='getCart?item="+itemsList.get(i).getProductId()+"'>Delete Items  :"+itemsList.get(i).getProductId()+"</a></br>");
	}	
out.print("<hr/>");
	out.println("<h2>After Removing Items In Cart::"+selectedItemsList.size()+"</h2>");
	if(selectedItemsList.size()==0)
	{
		out.println("<h2>Your cart is Empty!! Add Items  <a href='deletecart'>Click to Add items into  Cart</h2></a></br>");
	}
      
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
