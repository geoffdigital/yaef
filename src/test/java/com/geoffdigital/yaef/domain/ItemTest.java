package com.geoffdigital.yaef.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ItemTest {
	
	@Test
	public void itemTest() {
		Item item = new Item("blah", "blah");
		
		assertEquals("blah", item.getSku());
		assertEquals("blah", item.getDescription());
	}

}
