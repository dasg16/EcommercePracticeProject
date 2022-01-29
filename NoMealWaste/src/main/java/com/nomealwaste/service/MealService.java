package com.nomealwaste.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.nomealwaste.dao.MealDAO;
import com.nomealwaste.entity.Meal;

public class MealService {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private MealDAO mealDAO;

	public MealService() {
		entityManagerFactory = Persistence.createEntityManagerFactory("NoMealWaste");
		entityManager = entityManagerFactory.createEntityManager();
		mealDAO = new MealDAO(entityManager);
	}

	public List<Meal> listMeals() {
		String query = "select m from Meal m";
		List<Meal> meals = mealDAO.listAll(query);
		return meals;
	}

	public List<Meal> findByMealTitle(String title) {
		String query = "select u from Meal u where u.email='" + title + "'";
		List<Meal> meals = mealDAO.findByTitle(query);
		return meals;
	}

	public void createMeal(Integer category, String name, String provider, Date publish_date, String description,
			byte[] image, float price) {
		Meal meal = new Meal();

		System.out.println(category.toString());
		System.out.println(name);
		System.out.println(provider);
		System.out.println(publish_date);
		System.out.println(description);
		System.out.println(image);
		System.out.println(price);

		meal.setCategory(category);
		meal.setMealName(name);
		meal.setProvider(provider);
		meal.setPublishDate(publish_date);
		meal.setDescription(description);
		meal.setImage(image);
		meal.setPrice(price);

		mealDAO.create(meal);
	}

	public Meal editMeal(String mealIDString) {
		int mealId = Integer.parseInt(mealIDString);
		Meal meal = mealDAO.get(mealId);
		return meal;
	}

	public void updateMeal(Integer category, String name, String provider, Date publish_date, String description,
			byte[] image, float price) {
		Meal meal = new Meal();

		System.out.println(category.toString());
		System.out.println(name);
		System.out.println(provider);
		System.out.println(publish_date);
		System.out.println(description);
		System.out.println(image);
		System.out.println(price);

		meal.setCategory(category);
		meal.setMealName(name);
		meal.setProvider(provider);
		meal.setPublishDate(publish_date);
		meal.setDescription(description);
		meal.setImage(image);
		meal.setPrice(price);

		mealDAO.update(meal);
	}

	public void deleteMeal(Integer mealID) {
		mealDAO.delete(mealID);
	}

	public List<Meal> findByMealCategory(int categoryID) {
		String query = "select m from Meal m JOIN Category c ON m.category.categoryID AND c.categoryID = '" + categoryID
				+ "'";
		List<Meal> meals = mealDAO.findByTitle(query);
		return meals;
	}

	public List<Meal> listByCategory(String categoryID) {
		String query = "select c from Category c where c.categoryId = '" + categoryID + "'";

		List<Meal> meals = mealDAO.findByTitle(query);
		return meals;
	}
}
