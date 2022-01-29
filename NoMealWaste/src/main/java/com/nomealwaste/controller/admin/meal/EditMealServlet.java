package com.nomealwaste.controller.admin.meal;

import java.io.IOException;

import com.nomealwaste.entity.Meal;
import com.nomealwaste.service.MealService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Admin/meal_edit")
public class EditMealServlet extends HttpServlet {
	public EditMealServlet() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MealService mealService = new MealService();
		String mealID = (String) request.getParameter("id");
		request.setAttribute("editMeal", mealID);
		Meal meal = mealService.editMeal(mealID);
		request.setAttribute("mealObj", meal);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("CreateMealForm.jsp");
		requestDispatcher.forward(request, response);
	}

}
