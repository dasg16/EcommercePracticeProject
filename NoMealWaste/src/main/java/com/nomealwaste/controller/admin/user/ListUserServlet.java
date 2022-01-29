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

@WebServlet("/Admin/list_users")
public class ListUserServlet extends HttpServlet {

	public ListUserServlet() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService userService = new UserService();
		List<Users> user = userService.listUser();
		request.setAttribute("listUsers", user);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("UserList.jsp");
		requestDispatcher.forward(request, response);
	}

}
