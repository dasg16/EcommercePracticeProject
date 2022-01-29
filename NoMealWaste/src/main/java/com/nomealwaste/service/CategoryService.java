package com.nomealwaste.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.nomealwaste.dao.CategoryDAO;
import com.nomealwaste.entity.Category;

public class CategoryService {
	private EntityManagerFactory entityManagerFactory;
	private CategoryDAO categoryDAO;
	private EntityManager entityManager;

	public CategoryService() {
		entityManagerFactory = Persistence.createEntityManagerFactory("NoMealWaste");
		entityManager = entityManagerFactory.createEntityManager();
		categoryDAO = new CategoryDAO(entityManager);
	}

	public List<Category> listCategory() {
		String query = "select c from Category c";
		List<Category> category = categoryDAO.listAll(query);
		return category;
	}

	public List<Category> findByCategoryName(String name) {
		String query = "select u from Category u where u.name='" + name + "'";
		List<Category> category = categoryDAO.findByEmail(query);
		return category;
	}

	public void createCategory(String name) {
		Category newCategory = new Category();
		newCategory.setName(name);
		categoryDAO.create(newCategory);

	}

	public Category editCategory(String categoryIDString) {
		int categoryId = Integer.parseInt(categoryIDString);
		Category category = categoryDAO.get(categoryId);
		return category;
	}

	public String updateCategory(Integer categoryID, String name) {
		String result = "Meal Category already exists! Please choose another email name.";
		Category categoryById = categoryDAO.get(categoryID);
		List<Category> categoryList = findByCategoryName(name);

		if (categoryList.size() < 1) {
			Category category = new Category();
			category.setCategoryId(categoryID);
			category.setName(name);
			categoryDAO.update(category);
			result = "Successfully Update User Record";
		}
		return result;

	}

	public void deleteCategory(Integer categoryID) {
		categoryDAO.delete(categoryID);

	}
}
