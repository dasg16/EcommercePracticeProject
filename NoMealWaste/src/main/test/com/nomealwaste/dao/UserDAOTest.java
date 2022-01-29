package com.nomealwaste.dao;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.nomealwaste.entity.Users;

public class UserDAOTest {

	public static EntityManagerFactory entityManagerFactory;
	public static EntityManager entityManager;
	public static UserDAO userDAO;

	@BeforeClass
	public void testSetup() {
		entityManagerFactory = Persistence.createEntityManagerFactory("NoMealWaste");
		entityManager = entityManagerFactory.createEntityManager();
		userDAO = new UserDAO(entityManager);

	}

	@Test(enabled = false)
	private void validateCreateUser() {
		Users user = new Users();
		user.setEmail("new1@gmail.com");
		user.setFullName("Das");
		user.setPassword("hellowworld");
		user = userDAO.create(user);

		assertTrue(user.getUserID() > 0);
	}

//	@Test(expectedExceptions = PersistenceException.class)
	private void validateCreateUsersFieldNotNull() {
		Users user = new Users();
		user = userDAO.create(user);
	}

//	@Test
	private void validateUpdateUsers() {
		Users user = new Users();
		user.setUserID(23);
		user.setEmail("new1@gmail.com");
		user.setFullName("Das");
		user.setPassword("newpassword");

		user = userDAO.update(user);
	}

//	@Test
	private void validateGetUsers() {
		Integer userID = 22;
		Users user = userDAO.get(userID);
		System.out.println(user.getEmail());
		assertNotNull(user, null);
	}

//	@Test
	private void validateDeleteUsers() {
		Integer userID = 21;
		userDAO.delete(userID);
//		assertNull(userDAO.get(userID), null);
	}

	@Test
	private void validateListOfUsers() {
		String str = "select u from Users u";
		List<Users> user = userDAO.listAll(str);

		for (int i = 0; i < user.size(); i++) {
			System.out.println(user.get(i).getFullName());
		}

	}

	@AfterClass
	public void testTearDown() {
		entityManager.close();
		entityManagerFactory.close();

	}

}
