package com.todoapp.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todoapp.doaimpl.TodoDoaImpl;
import com.todoapp.pojo.TodoData;

@WebServlet(urlPatterns = "/upadatetodo")
public class UpdateTodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		TodoData td = new TodoData();
		td.setTodoid(Integer.parseInt(request.getParameter("textId")));
		td.setDescription(request.getParameter("textDesc"));
		td.setDate(request.getParameter("textDate"));
		
		TodoDoaImpl todo = new TodoDoaImpl();
		
		if(todo.updateTodo(td))
		{
			String pageUrl="/ViewTodo";
			//server side redirection
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher(pageUrl);
			dispatcher.forward(request, response);
		}
		else
		{
			pw.println("<!DOCTYPE html>");
			pw.println("<html>");
			pw.println("<head>");
			pw.println("<title>Dollar Page</title>");
			pw.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
			pw.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
			pw.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>");
			pw.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>");
			pw.println("</head>");
			pw.println("<body>");
			pw.println("<div class=\"container\">");
			pw.println("<h1 style=\"color:red;text-align:center\">"+"failed to update todo list"+"</h1>");
			pw.println("</div>");
			pw.println("</body>");
			pw.println("</html>");
		}
	}
}
