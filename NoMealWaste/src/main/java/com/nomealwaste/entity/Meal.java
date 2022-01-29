package com.nomealwaste.entity;
// Generated Jan 7, 2022, 5:56:42 AM by Hibernate Tools 5.5.7.Final

import java.util.Base64;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Meal {

	private Integer mealId;
	private Integer category;
	private String mealName;
	private String provider;
	private String description;
	private byte[] image;
	private float price;
	private Date publishDate;
	private Date lastUpdateTime;
	private String base64Image;

	private Set<OrderDetail> orderDetails = new HashSet<OrderDetail>(0);
	private Set<Review> reviews = new HashSet<Review>(0);

	public Meal() {
	}

	public Meal(Integer category, String mealName, String provider, String description, String isbn, byte[] image,
			float price, Date publishDate, Date lastUpdateTime) {
		this.category = category;
		this.mealName = mealName;
		this.provider = provider;
		this.description = description;
		this.image = image;
		this.price = price;
		this.publishDate = publishDate;
		this.lastUpdateTime = lastUpdateTime;
	}

	public Meal(Integer category, String mealName, String provider, String description, String isbn, byte[] image,
			float price, Date publishDate, Date lastUpdateTime, Set orderDetails, Set reviews) {
		this.category = category;
		this.mealName = mealName;
		this.provider = provider;
		this.description = description;
		this.image = image;
		this.price = price;
		this.publishDate = publishDate;
		this.lastUpdateTime = lastUpdateTime;
		/*
		 * this.orderDetails = orderDetails; this.reviews = reviews;
		 */
	}

	@Column(name = "meal_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getMealId() {
		return this.mealId;
	}

	public void setMealId(Integer mealId) {
		this.mealId = mealId;
	}

	@Column(name = "category_id")
	public Integer getCategory() {
		return this.category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	@Column(name = "meal_name")
	public String getMealName() {
		return this.mealName;
	}

	public void setMealName(String mealName) {
		this.mealName = mealName;
	}

	@Column
	public String getProvider() {
		return this.provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	@Column
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column
	public byte[] getImage() {
		return this.image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Column
	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Column(name = "publish_date")
	public Date getPublishDate() {
		return this.publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	@Column(name = "last_update_time")
	public Date getLastUpdateTime() {
		return this.lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	@Transient
	public String getBase64Image() {
		return this.base64Image = Base64.getEncoder().encodeToString(this.image);
	}

	@Transient
	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}

}
