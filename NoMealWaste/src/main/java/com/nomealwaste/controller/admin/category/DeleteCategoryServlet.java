package com.nomealwaste.controller.admin.category;

import java.io.IOException;

import com.nomealwaste.service.CategoryService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Admin/delete_category")
public class DeleteCategoryServlet extends HttpServlet {

	public DeleteCategoryServlet() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer categoryID = Integer.valueOf(request.getParameter("id"));
		CategoryService categoryService = new CategoryService();
		categoryService.deleteCategory(categoryID);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Admin/list_categories");
		requestDispatcher.forward(request, response);

	}

}
