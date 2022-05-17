package ai.jobiak.three;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/querystring")
public class QueryStringExample extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public QueryStringExample() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println("Third Question On QueryString");
		String queryString=request.getQueryString();
		String keyvalues[]=queryString.split("&");
		for(String data:keyvalues) {
			out.println(data);
	}
	}
}

