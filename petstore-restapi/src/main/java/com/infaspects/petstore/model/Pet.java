/*
 * @Copyright 2016 - Infinite Aspects, All rights reserved
 */

package com.infaspects.petstore.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pets")
public class Pet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8080279845340587820L;

	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	@OneToOne(optional=false, targetEntity=Category.class, cascade=CascadeType.ALL)
	Category category;
	
	@Column(name = "name", length=20)
	String name;
	
	@OneToMany(targetEntity=PhotoUrl.class, cascade=CascadeType.ALL)
	Set<PhotoUrl> photoUrls;
	
	@OneToMany(targetEntity=Tag.class, cascade=CascadeType.ALL)
	Set<Tag> tags;
	
	Status status;
	
	protected Pet() {}
	
	public Pet (Category category, String name, 
			Set<PhotoUrl> photoUrls, Set<Tag> tags, Status status) {
		this.category = category;
		this.name = name;
		this.photoUrls = photoUrls;
		this.tags = tags;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<PhotoUrl> getPhotoUrls() {
		return photoUrls;
	}

	public void setPhotoUrls(Set<PhotoUrl> photoUrls) {
		this.photoUrls = photoUrls;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		StringBuffer returnString = new StringBuffer();
		returnString.append("id ").append(this.id);
		returnString.append(" name ").append(name);
		returnString.append(" status ").append(status);
		
		return returnString.toString();
	}
}
