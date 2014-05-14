package com.geoffdigital.yaef.domain;

import java.io.Serializable;

public class Item implements Serializable {

	private static final long serialVersionUID = -15104029270094872L;

	private String sku;
	private String description;
	
	public Item(String sku, String description) {
		this.sku = sku;
		this.description = description;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
