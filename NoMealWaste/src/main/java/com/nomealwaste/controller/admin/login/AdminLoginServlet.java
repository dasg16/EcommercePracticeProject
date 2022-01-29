package com.nomealwaste.controller.admin.login;

import java.io.IOException;

import com.nomealwaste.service.UserService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Admin/login_form")
public class AdminLoginServlet extends HttpServlet {
	public AdminLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String username = request.getParameter("email");
		String password = request.getParameter("password");

		UserService userService = new UserService();
		try {
			if (userService.checkLogin(username, password)) {
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				response.sendRedirect("AdminHomepage.jsp");
			} else {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("AdminLogin.jsp");
				request.setAttribute("LoginStatus", "Incorrect Email or Password! Please try again.");
				requestDispatcher.forward(request, response);
				response.sendRedirect("AdminLogin.jsp");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
