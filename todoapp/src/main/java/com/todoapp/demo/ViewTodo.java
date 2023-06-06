package com.todoapp.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todoapp.doaimpl.TodoDoaImpl;
import com.todoapp.pojo.TodoData;

@WebServlet(urlPatterns = "/ViewTodo")
public class ViewTodo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		TodoDoaImpl todo = new TodoDoaImpl();
		
		List<TodoData> lst = todo.viewTodo();
		
		if(lst.size() > 0) 
		{
			//lst.forEach(System.out::println);

			pw.println("<!DOCTYPE html>");
			pw.println("<html>");
			pw.println("<head>");
			pw.println("<title>View Todo Page</title>");
			pw.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
			pw.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
			pw.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>");
			pw.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>");
			pw.println("</head>");
			pw.println("<body>");
			pw.println("<div class=\"container\">");
			pw.println("<h1 style=\"color:blue;text-align:center\">"+"Todo's are : <br />"+"</h1>");
			pw.println("<h1 style=\"color:blue;text-align:center\">"+"<br />"+lst.toString()+"<br />"+"</h1>");
			
			//table structure
			pw.println("<table style=\"border:1px solid black;text-align:center\">"
					+ "<tr style=\"border:1px solid black;text-align:center\">"
					+ "<th style=\"border:1px solid black;text-align:center\">Id"
					+ "</th>"
					+ "<th style=\"border:1px solid black;text-align:center\">desc "
					+ "</th>"
					+ "<th style=\"border:1px solid black;text-align:center\">target_date"
					+ "</th>"
					+ "</tr>"
					+ "<tr style=\"border:1px solid black;text-align:center\">"
					+ "<td style=\"border:1px solid black;text-align:center\">"
					+ "sharda<td >"
					+ "<td style=\"border:1px solid black;text-align:center\">"
					+ "Germany<td >"
					+ "</tr>"
					+ "</table>");
//			pw.println("\"<h1 align = \"center\">" + lst.toString() + "</h1>\n\" +\r\n"
//					+ " \"<ul>\n\" +\r\n"
//					+ " \"  <li><b>First Name</b>: \"\r\n"
//					+ " + request.getParameter(\"first_name\") + \"\n\" +\r\n"
//					+ " \"  <li><b>Last Name</b>: \"\r\n"
//					+ " + request.getParameter(\"last_name\") + \"\n\" +\r\n"
//					+ "               \"</ul>");
			
			pw.println("<h1 style=\"color:yellow;text-align:center\">"+"<br />"+"<a href=\"updatetodo.html\">click here to update record</a>"+"<br />"+"</h1>");
			pw.println("<h1 style=\"color:red;text-align:center\">"+"<br />"+"<a href=\"deletetodo.html\">click here to delete record</a>"+"<br />"+"</h1>");
			pw.println("</div>");
			pw.println("</body>");
			pw.println("</html>");
			
		}
		else 
		{
			pw.println("<!DOCTYPE html>");
			pw.println("<html>");
			pw.println("<head>");
			pw.println("<title>View Todo Page</title>");
			pw.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
			pw.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
			pw.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>");
			pw.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>");
			pw.println("</head>");
			pw.println("<body>");
			pw.println("<div class=\"container\">");
			pw.println("<h1 style=\"color:red;text-align:center\">"+"no data found"+"</h1>");
			pw.println("</div>");
			pw.println("</body>");
			pw.println("</html>");
			
		}
	}
}
