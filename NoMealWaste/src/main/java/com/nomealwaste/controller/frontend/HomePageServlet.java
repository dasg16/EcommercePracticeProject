package com.nomealwaste.controller.frontend;

import java.io.IOException;
import java.util.List;

import com.nomealwaste.entity.Category;
import com.nomealwaste.service.CategoryService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/homepage")
public class HomePageServlet extends HttpServlet {

	public HomePageServlet() {
		super();
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CategoryService categoryDAO = new CategoryService();
		List<Category> categoryList = categoryDAO.listCategory();
		request.setAttribute("categoryList", categoryList);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("Homepage.jsp");
		requestDispatcher.forward(request, response);

	}

}
