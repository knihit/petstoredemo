/*
 * @Copyright 2016 - Infinite Aspects, All rights reserved
 */

package com.infaspects.petstore.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5502996154190105745L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	@Column(name = "name", length=20)
	String name;
	
	protected Category() {}
	
	public Category(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
