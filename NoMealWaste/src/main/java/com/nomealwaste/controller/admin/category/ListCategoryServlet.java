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

@WebServlet("/Admin/list_categories")
public class ListCategoryServlet extends HttpServlet {

	public ListCategoryServlet() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CategoryService categoryService = new CategoryService();
		List<Category> category = categoryService.listCategory();
		request.setAttribute("listCategories", category);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("CategoryList.jsp");
		requestDispatcher.forward(request, response);
	}

}
