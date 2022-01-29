package com.nomealwaste.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.nomealwaste.dao.UserDAO;
import com.nomealwaste.entity.Users;

public class UserService {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private UserDAO userDAO;

	public UserService() {
		entityManagerFactory = Persistence.createEntityManagerFactory("NoMealWaste");
		entityManager = entityManagerFactory.createEntityManager();
		userDAO = new UserDAO(entityManager);
	}

	public List<Users> listUser() {
		String query = "select u from Users u";
		List<Users> users = userDAO.listAll(query);
		return users;
	}

	public List<Users> findByEmailUser(String email) {
		String query = "select u from Users u where u.email='" + email + "'";
		List<Users> users = userDAO.findByEmail(query);
		return users;
	}

	public void createUser(String email, String fullName, String password) {
		Users newUser = new Users();
		newUser.setEmail(email);
		newUser.setPassword(password);
		newUser.setFullName(fullName);
		userDAO.create(newUser);
	}

	public Users editUser(String userIDString) {
		int userId = Integer.parseInt(userIDString);
		Users user = userDAO.get(userId);
		return user;
	}

	public String updateUser(Integer userID, String email, String fullName, String password) {
		String result = "User Email Already exists. Please choose another email name.";
		List<Users> userList = findByEmailUser(email);

		if (userList.size() < 1) {
			Users user = new Users();
			user.setUserID(userID);
			user.setEmail(email);
			user.setPassword(password);
			user.setFullName(fullName);
			userDAO.update(user);
			result = "Successfully Update User Record";
		}
		return result;
	}

	public void deleteUser(Integer userID) {
		userDAO.delete(userID);
	}

	public boolean checkLogin(String email, String password) {
		boolean decision = false;
		String query = "Select u from Users u where u.email = '" + email + "' and u.password = '" + password + "'";
		List<Users> userList = userDAO.listAll(query);
		if (userList.size() == 1) {
			decision = true;
		}
		return decision;
	}

}
