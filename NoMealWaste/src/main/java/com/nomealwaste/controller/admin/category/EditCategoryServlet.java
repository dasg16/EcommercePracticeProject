package com.nomealwaste.controller.admin.category;

import java.io.IOException;

import com.nomealwaste.entity.Category;
import com.nomealwaste.service.CategoryService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Admin/category_edit")
public class EditCategoryServlet extends HttpServlet {
	public EditCategoryServlet() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CategoryService categoryService = new CategoryService();
		String categoryID = (String) request.getParameter("id");
		request.setAttribute("editCategory", categoryID);
		Category category = categoryService.editCategory(categoryID);
		request.setAttribute("categoryObj", category);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("CreateCategoryForm.jsp");
		requestDispatcher.forward(request, response);
	}

}
