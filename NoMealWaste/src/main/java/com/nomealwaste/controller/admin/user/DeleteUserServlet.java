package com.nomealwaste.controller.admin.user;

import java.io.IOException;

import com.nomealwaste.service.UserService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Admin/delete_user")
public class DeleteUserServlet extends HttpServlet {

	public DeleteUserServlet() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer userID = Integer.valueOf(request.getParameter("id"));
		UserService userService = new UserService();
		userService.deleteUser(userID);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Admin/list_users");
		requestDispatcher.forward(request, response);

	}

}
