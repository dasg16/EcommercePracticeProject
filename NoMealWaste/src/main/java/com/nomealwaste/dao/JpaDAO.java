package com.nomealwaste.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class JpaDAO<E> {

	private EntityManager entityManager;

	public JpaDAO(EntityManager entityManager) {
		super();
		// TODO Auto-generated constructor stub
		this.entityManager = entityManager;
	}

	public E create(E entity) {
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.flush();
		entityManager.refresh(entity);
		entityManager.getTransaction().commit();

		return entity;

	}

	public E update(E entity) {
		entityManager.getTransaction().begin();
		entity = entityManager.merge(entity);
		entityManager.getTransaction().commit();

		return entity;

	}

	public E find(Class<E> type, Object id) {
		E entity = entityManager.find(type, id);
		entity = entityManager.merge(entity);
		entityManager.refresh(entity);

		return entity;

	}

	public void delete(Class<E> type, Object id) {
		entityManager.getTransaction().begin();
		Object reference = entityManager.getReference(type, id);
		entityManager.remove(reference);
		entityManager.getTransaction().commit();

	}

	public List<E> findWithQuery(String queryString) {
		Query query = entityManager.createQuery(queryString);

		List<E> result = query.getResultList();
		return result;

	}

	public List<E> findEmailWithQuery(String queryString) {
		Query query = entityManager.createQuery(queryString);

		List<E> result = query.getResultList();
		return result;

	}

}
