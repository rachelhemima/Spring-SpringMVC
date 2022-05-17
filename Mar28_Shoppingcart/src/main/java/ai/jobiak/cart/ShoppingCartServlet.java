package ai.jobiak.cart;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet("/cart")
public class ShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShoppingCartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();// .append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		for(int i=1;i<10;i++)
		{
			out.println("<a href='cart'>Add Items"+i+"</a></br>");
		}

		ArrayList<Product> itemList = null;
	     HttpSession shoppingCart=request.getSession(); 
	  
	     if(shoppingCart.isNew()) {
		 itemList=new ArrayList<>(); shoppingCart.setAttribute("items",itemList );
		 }
		 else
			 itemList=(ArrayList<Product>)shoppingCart.getAttribute("items");
	     Product p=new Product("HYFG","Wireless earbuds",999.00);
	     itemList.add(p);
	  
	     shoppingCart.setAttribute("items", itemList);
	for(Product product:itemList)
	{
		out.println("Description:"+"<h3>"+product.getDescription()+"</h3>");
	}
	}
}
