package com.nomealwaste.controller.admin.category;

import java.io.IOException;

import com.nomealwaste.service.CategoryService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Admin/update_categories")
public class UpdateCategoryServlet extends HttpServlet {

	public UpdateCategoryServlet() {
		super();

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer categoryID = Integer.valueOf(request.getParameter("categoryId"));
		String name = request.getParameter("name");

		CategoryService categoryService = new CategoryService();
		String result = categoryService.updateCategory(categoryID, name);

		request.setAttribute("updateSuccessStatus", result);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Admin/list_categories");

		requestDispatcher.forward(request, response);
	}

}
