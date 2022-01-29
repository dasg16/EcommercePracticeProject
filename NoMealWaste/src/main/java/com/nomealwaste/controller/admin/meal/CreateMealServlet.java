package com.nomealwaste.controller.admin.meal;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.nomealwaste.entity.Category;
import com.nomealwaste.service.CategoryService;
import com.nomealwaste.service.MealService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/Admin/create_meal")
@MultipartConfig(fileSizeThreshold = 1024 * 50, maxFileSize = 1024 * 500, maxRequestSize = 1024 * 1024)
public class CreateMealServlet extends HttpServlet {

	public CreateMealServlet() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CategoryService categoryService = new CategoryService();
		String categoryString = request.getParameter("category").replace("\r\n", "");
		List<Category> category = categoryService.findByCategoryName(categoryString);

		String name = request.getParameter("name");
		String provider = request.getParameter("provider");
		DateFormat publish_dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date publish_date = null;
		try {
			publish_date = publish_dateFormat.parse(request.getParameter("publish_date"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String description = request.getParameter("description");
		Part image = request.getPart("image");
		byte[] imageByte = null;
		if (image != null && image.getSize() > 0) {
			long size = image.getSize();
			imageByte = new byte[(int) size];

			InputStream inputStream = image.getInputStream();
			inputStream.read(imageByte);
			inputStream.close();

		}

		float price = Float.parseFloat(request.getParameter("price"));

		MealService mealService = new MealService();
		mealService.createMeal(category.get(0).getCategoryId(), name, provider, publish_date, description, imageByte,
				price);

		request.setAttribute("updateSuccessStatus", "Successfully Added New Meal");

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Admin/list_meals");

		requestDispatcher.forward(request, response);

	}

}
