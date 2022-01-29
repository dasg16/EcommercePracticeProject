package com.nomealwaste.controller.admin.category;

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

@WebServlet("/Admin/create_categories")
public class CreateCategoryServlet extends HttpServlet {

	public CreateCategoryServlet() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");

		CategoryService categoryService = new CategoryService();
		List<Category> category = categoryService.findByCategoryName(name);
		if (category.isEmpty()) {
			categoryService.createCategory(name);

			request.setAttribute("updateSuccessStatus", "Successfully Added New Category");
		} else {
			request.setAttribute("updateFailedStatus", "Category name " + name + " already exists");
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Admin/list_categories");

		requestDispatcher.forward(request, response);

	}

}
