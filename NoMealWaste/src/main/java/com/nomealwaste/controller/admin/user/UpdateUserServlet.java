package com.nomealwaste.controller.admin.user;

import java.io.IOException;

import com.nomealwaste.service.UserService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Admin/update_user")
public class UpdateUserServlet extends HttpServlet {

	public UpdateUserServlet() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer userID = Integer.valueOf(request.getParameter("userId"));
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String fullname = request.getParameter("fullname");

		UserService userService = new UserService();
		String result = userService.updateUser(userID, email, fullname, password);

		request.setAttribute("updateSuccessStatus", result);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Admin/list_users");

		requestDispatcher.forward(request, response);
	}

}
