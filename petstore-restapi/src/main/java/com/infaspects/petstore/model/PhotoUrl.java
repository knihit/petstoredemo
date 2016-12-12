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
@Table(name = "photo_urls")
public class PhotoUrl implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6198140999765865612L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	@Column(name = "url", length=20)
	String url;
	
	protected PhotoUrl() {}
	
	public PhotoUrl(String url) {
		this.url = url;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
