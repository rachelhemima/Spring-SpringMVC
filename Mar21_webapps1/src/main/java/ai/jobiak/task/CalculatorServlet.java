package ai.jobiak.task;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public CalculatorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		out.println("<html><head><title>CalculatorServlet</title></head><body>"); 
		double n1 = Double.parseDouble(request.getParameter("num1"));
		double n2 = Double.parseDouble(request.getParameter("num2"));
		double result =0;
		String opr=request.getParameter("opr");
		if(opr.equals("+"))
		{
		result=n1+n2;
out.println("<h1>Result = "+result);
		}
else if(opr.equals("*"))
{
		result=n1*n2;
   out.println("<h1>Result = "+result);
}
else if(opr.equals("-")) {
		result=n1-n2;
		out.println("<h1>Result = "+result);
}
else if(opr.equals("/")) {
		result=n1/n2;
		out.println("<h1>Result = "+result);
}
else
		out.print(false);
		out.println("</body></html>");
		 }
}

