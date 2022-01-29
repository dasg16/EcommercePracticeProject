package com.nomealwaste.dao;

import java.util.List;

public interface CommonDAO<E> {

	public E create(E t);

	public E update(E t);

	public E get(Object id);

	public void delete(Object id);

	public List<E> listAll(String query);

	public long count();

}
