package com.nomealwaste.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.nomealwaste.entity.Category;

public class CategoryDAO extends JpaDAO<Category> implements CommonDAO<Category> {

	public CategoryDAO(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Category create(Category category) {
		return super.create(category);
	}

	@Override
	public Category update(Category category) {
		return super.update(category);
	}

	@Override
	public Category get(Object id) {
		return super.find(Category.class, id);
	}

	@Override
	public void delete(Object id) {
		super.delete(Category.class, id);
	}

	@Override
	public List<Category> listAll(String query) {

		return super.findWithQuery(query);
	}

	@Override
	public long count() {
		return 0;
	}

	public List<Category> findByEmail(String query) {
		return super.findEmailWithQuery(query);

	}

}
