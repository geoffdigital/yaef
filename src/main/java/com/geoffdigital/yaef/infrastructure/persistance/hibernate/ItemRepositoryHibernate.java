package com.geoffdigital.yaef.infrastructure.persistance.hibernate;

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
	public Item findItemBySku(final Sku sku) {
		return (Item) getSession()
				.createQuery("from Item where sku = :sku")
				.setParameter("sku", sku).uniqueResult();
	}

}
