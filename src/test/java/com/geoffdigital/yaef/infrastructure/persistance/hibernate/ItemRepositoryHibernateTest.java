package com.geoffdigital.yaef.infrastructure.persistance.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.geoffdigital.yaef.domain.model.Item;
import com.geoffdigital.yaef.domain.model.ItemRepository;
import com.geoffdigital.yaef.domain.model.Sku;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:RepositoryTest-context.xml")
public class ItemRepositoryHibernateTest {
	
	@Autowired
	ItemRepository itemRepository;

	@Test
	@Transactional
	public void testFind(){
		Item item1 = createNewItem("Batman");
		Item item2 = createNewItem("Joker");

		assertSame(item1, itemRepository.find(item1.getSku()));
		assertNotSame(item1, itemRepository.find(item2.getSku()));
		assertNull(itemRepository.find(new Sku("NA")));
	}

	@Test
	@Transactional
	public void testFindAll() {
		int numOfItems = 0;
		for(int i = 0; i < 3; i++) {
			createNewItem("blah");
			numOfItems++;
		}

		List<Item> items = itemRepository.findAll();
		assertEquals(numOfItems, items.size());
	}

	@Test
	@Transactional
	public void testStore(){
		Item item = createNewItem("Batman");
		assertNotNull(item);
	}

	@Test
	public void testNextIssueId(){
		Sku sku1 = itemRepository.nextSku();
		Sku sku2 = itemRepository.nextSku();
		Sku sku3 = itemRepository.nextSku();

		assertNotSame(sku1, sku2);
		assertNotSame(sku1, sku3);
		assertNotSame(sku2, sku3);
	}

	private Item createNewItem(String description){
		Sku sku = itemRepository.nextSku();
		Item item = new Item(sku, description);
		itemRepository.store(item);
		assertNotNull(item.getId());
		return item;
	}

}
