package com.nomealwaste.controller.frontend;

import java.io.IOException;
import java.util.List;

import com.nomealwaste.entity.Meal;
import com.nomealwaste.service.MealService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/view_category")
public class ListViewByCategoryServlet extends HttpServlet {
	public ListViewByCategoryServlet() {
		super();
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String mealID = request.getParameter("id");
		MealService mealService = new MealService();
		List<Meal> mealListCategory = mealService.listByCategory(mealID);

		request.setAttribute("categoryList", mealListCategory);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view_category");

		requestDispatcher.forward(request, response);

	}

}
