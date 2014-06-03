package com.geoffdigital.yaef.domain.model;

import java.util.List;

public interface ItemRepository {

	Sku nextSku();

	Item find(Sku id);
	
	List<Item> findAll();
	
	void store(Item item);
	
}
