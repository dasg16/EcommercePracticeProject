package com.nomealwaste.users;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.testng.annotations.Test;

import com.nomealwaste.entity.Category;
import com.nomealwaste.entity.Users;

public class TestUser {

//	@Test
	public void testUserEntry() {
		Users user = new Users();
		user.setEmail("xyz@gmail.com");
		user.setFullName("Das");
		user.setPassword("hellowworld");

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NoMealWaste");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();

	}

	@Test
	public void testCategoryEntry() {
		Category category = new Category();
		category.setName("Diabetic Meals");

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NoMealWaste");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(category);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();

	}

}
