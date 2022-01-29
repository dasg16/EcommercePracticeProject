package com.nomealwaste.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import com.nomealwaste.entity.Meal;

public class MealDAO extends JpaDAO<Meal> implements CommonDAO<Meal> {

	public MealDAO(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Meal create(Meal meal) {
		meal.setLastUpdateTime(new Date());
		return super.create(meal);
	}

	@Override
	public Meal update(Meal meal) {
		meal.setLastUpdateTime(new Date());
		return super.update(meal);
	}

	@Override
	public Meal get(Object mealId) {
		return super.find(Meal.class, mealId);
	}

	@Override
	public void delete(Object mealId) {
		super.delete(Meal.class, mealId);

	}

	@Override
	public List<Meal> listAll(String query) {
		return super.findWithQuery(query);
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Meal> findByTitle(String query) {
		return super.findWithQuery(query);
	}

	public List<Meal> listByCategory(String query) {
		return super.findWithQuery(query);

	}

}
