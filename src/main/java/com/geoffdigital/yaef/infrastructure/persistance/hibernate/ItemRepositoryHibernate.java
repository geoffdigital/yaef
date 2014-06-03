package com.geoffdigital.yaef.infrastructure.persistance.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.geoffdigital.yaef.domain.model.Item;
import com.geoffdigital.yaef.domain.model.ItemRepository;
import com.geoffdigital.yaef.domain.model.Sku;

@Repository
@Transactional
public class ItemRepositoryHibernate extends HibernateRepository implements
		ItemRepository {

	@Override
	public Sku nextSku() {
		return new Sku(getUUID());
	}

	@Override
	public Item find(final Sku sku) {
		return (Item) getSession()
				.createQuery("from Item where sku = :sku")
				.setParameter("sku", sku).uniqueResult();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Item> findAll() {
		return getSession().createQuery("from Item").list();
	}
	
	@Override
	public void store(final Item item) {
		getSession().saveOrUpdate(item);
	}

}
