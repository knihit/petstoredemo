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
@Table(name = "tags")
public class Tag implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3650108307901838579L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	@Column(name = "name", length=20)
	String name;
	
	protected Tag(){}
	
	public Tag (String name) {
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
