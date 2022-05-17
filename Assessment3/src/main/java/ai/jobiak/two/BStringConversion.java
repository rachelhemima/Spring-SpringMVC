package ai.jobiak.two;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/b")
public class BStringConversion extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BStringConversion() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		out.println("<html><head><title>ReverseOfString Servlet</title></head><body>"); 
		String Str=request.getParameter("str");
	    StringBuffer newStr=new StringBuffer(Str); 
		for(int i = 0; i < Str.length(); i++) {  
            if(Character.isLowerCase(Str.charAt(i))) {  
                newStr.setCharAt(i, Character.toUpperCase(Str.charAt(i)));  
            }  
            else if(Character.isUpperCase(Str.charAt(i))) {   
                newStr.setCharAt(i, Character.toLowerCase(Str.charAt(i)));  
            }  
	}
		 out.println("<h2>String after case conversion: " + newStr+"</h2>");  
			out.println("</body></html>");
	}
}
