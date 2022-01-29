package com.nomealwaste.controller.admin.meal;

import java.io.IOException;

import com.nomealwaste.service.MealService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Admin/delete_meal")
public class DeleteMealServlet extends HttpServlet {

	public DeleteMealServlet() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer mealID = Integer.valueOf(request.getParameter("id"));
		MealService mealService = new MealService();
		mealService.deleteMeal(mealID);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Admin/list_meals");
		requestDispatcher.forward(request, response);

	}

}
