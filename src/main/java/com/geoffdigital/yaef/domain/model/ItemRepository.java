package com.geoffdigital.yaef.domain.model;

public interface ItemRepository {

	Sku nextSku();

	Item findItemBySku(Sku id);
	
}
