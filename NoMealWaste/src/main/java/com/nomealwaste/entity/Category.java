package com.nomealwaste.entity;
// Generated Jan 7, 2022, 5:56:42 AM by Hibernate Tools 5.5.7.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category implements java.io.Serializable {

	private Integer categoryId;
	private String name;

	public Category() {
	}

	@Column(name = "category_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
