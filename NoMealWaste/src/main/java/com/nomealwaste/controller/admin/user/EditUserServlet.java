package com.nomealwaste.controller.admin.user;

import java.io.IOException;

import com.nomealwaste.entity.Users;
import com.nomealwaste.service.UserService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Admin/user_edit")
public class EditUserServlet extends HttpServlet {

	public EditUserServlet() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService userService = new UserService();
		String userID = (String) request.getParameter("id");
		request.setAttribute("editUser", userID);
		Users user = userService.editUser(userID);
		request.setAttribute("userObj", user);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("CreateUserForm.jsp");
		requestDispatcher.forward(request, response);
	}

}
