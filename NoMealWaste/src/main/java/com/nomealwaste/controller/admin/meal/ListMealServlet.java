package com.nomealwaste.controller.admin.meal;

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

@WebServlet("/Admin/list_meals")
public class ListMealServlet extends HttpServlet {

	public ListMealServlet() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MealService mealService = new MealService();
		List<Meal> meal = mealService.listMeals();
		request.setAttribute("listOfMeals", meal);
		request.setAttribute("imageAsBase64", meal.get(0).getBase64Image());

		RequestDispatcher requestDispatcherList = request.getRequestDispatcher("MealList.jsp");
		requestDispatcherList.forward(request, response);
	}

}
