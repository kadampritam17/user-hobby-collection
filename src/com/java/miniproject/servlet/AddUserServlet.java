package com.java.miniproject.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.miniproject.db.DBManager;
import com.java.miniproject.pojo.User;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		User newUser = new User();


		//		newUser.setID(request.getParameter("id"));   //i taken it as  default
		newUser.setFirstName(request.getParameter("first_name"));
		newUser.setLastName(request.getParameter("last_name"));
		newUser.setEmail(request.getParameter("email"));
		newUser.setMobNo(request.getParameter("mob"));
		newUser.setUserName(request.getParameter("uname"));
		newUser.setPassword(request.getParameter("pass"));

		DBManager dbManager = new DBManager();

		if(dbManager.createUser(newUser))
		{
			//User Created Successfully....redirect to login.jsp
			String successMsg = "User Created Successfully...!!!";
			request.setAttribute("success", successMsg);
			ServletContext context = super.getServletContext();
			RequestDispatcher rd = context.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}
		//		else
		//		{
		//			//User Not Created....redirect to signup.jsp
		//			String errorMsg = "User Not Created...!!!";
		//			request.setAttribute("error", errorMsg);
		//			ServletContext context = super.getServletContext();
		//			RequestDispatcher rd = context.getRequestDispatcher("/signup.jsp");
		//			rd.forward(request, response);
		//		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
