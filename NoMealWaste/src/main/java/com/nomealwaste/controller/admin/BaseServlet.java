package com.nomealwaste.controller.admin;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jakarta.servlet.http.HttpServlet;

public class BaseServlet extends HttpServlet {

	protected EntityManagerFactory entityManagerFactory;
	protected EntityManager entityManager;

	public void init() {

		entityManagerFactory = Persistence.createEntityManagerFactory("NoMealWaste");
		entityManager = entityManagerFactory.createEntityManager();
	}

	public void tearDown() {
		entityManager.close();
		entityManagerFactory.close();

	}

}
