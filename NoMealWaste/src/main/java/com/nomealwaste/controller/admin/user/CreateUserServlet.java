package com.nomealwaste.controller.admin.user;

import java.io.IOException;
import java.util.List;

import com.nomealwaste.entity.Users;
import com.nomealwaste.service.UserService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Admin/create_user")
public class CreateUserServlet extends HttpServlet {

	public CreateUserServlet() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String fullname = request.getParameter("fullname");

		UserService userService = new UserService();
		List<Users> user = userService.findByEmailUser(email);
		if (user.isEmpty()) {
			userService.createUser(email, fullname, password);

			request.setAttribute("updateSuccessStatus", "Successfully Added New User");
		} else {
			request.setAttribute("updateFailedStatus", "User Email " + email + " already exists");
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Admin/list_users");

		requestDispatcher.forward(request, response);

	}

}
