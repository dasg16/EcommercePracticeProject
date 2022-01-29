package com.nomealwaste.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.nomealwaste.entity.Users;

public class UserDAO extends JpaDAO<Users> implements CommonDAO<Users> {

	public UserDAO(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public Users create(Users users) {
		return super.create(users);
	}

	@Override
	public Users update(Users users) {
		return super.update(users);
	}

	@Override
	public Users get(Object id) {
		return super.find(Users.class, id);
	}

	@Override
	public void delete(Object id) {
		super.delete(Users.class, id);
	}

	public List<Users> findByEmail(String query) {
		return super.findEmailWithQuery(query);
	}

	@Override
	public List<Users> listAll(String query) {
		return super.findWithQuery(query);
	}

	@Override
	public long count() {
		return 0;
	}

}
