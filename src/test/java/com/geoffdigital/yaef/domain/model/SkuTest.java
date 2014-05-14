package com.geoffdigital.yaef.domain.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SkuTest {

	@Test(expected = IllegalArgumentException.class)
	public void constructorTest() {
		final Sku id = new Sku(null);
	}
	
	@Test
	public void sameValueAsTest() {
		final Sku id1 = new Sku("foo");
		assertFalse(id1.sameValueAs(null));
		
		final Sku id2 = new Sku("bar");
		assertFalse(id2.sameValueAs(id1));

		final Sku id3 = new Sku("bar");
		assertTrue(id3.sameValueAs(id2));
	}
	
	@Test
	public void equalsTest() {
		final Sku id1 = new Sku("foo");
		assertFalse(id1.equals(null));
		assertFalse(id1.equals(""));
		
		final Sku id2 = new Sku("bar");
		assertFalse(id2.equals(id1));

		final Sku id3 = new Sku("bar");
		assertTrue(id3.equals(id2));
	}
}
