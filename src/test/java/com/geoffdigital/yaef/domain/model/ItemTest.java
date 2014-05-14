package com.geoffdigital.yaef.domain.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.geoffdigital.yaef.domain.model.Item;

public class ItemTest {
	
	@Test
	public void itemTest() {
		Item item = new Item(new Sku("blah"), "blah");
		
		assertEquals(new Sku("blah"), item.getSku());
		assertEquals("blah", item.getDescription());
	}

}
