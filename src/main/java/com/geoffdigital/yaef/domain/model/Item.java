package com.geoffdigital.yaef.domain.model;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.geoffdigital.yaef.domain.model.shared.Entity;

public class Item implements Entity<Item> {

	private Long id;
	private Sku sku;
	private String description;
	
	public Item(Sku sku, String description) {
		Validate.notNull(sku, "sku must be set");
		Validate.notEmpty(description, "description must be set");

		this.sku = sku;
		this.description = description;
	}

	public Sku getSku() {
		return sku;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public boolean sameIdentityAs(final Item other) {
		return other != null
				&& (sku != null && sku.sameValueAs(other.sku));
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(sku).toHashCode();
	}

	@Override
	public boolean equals(final Object obj) {
		if (obj == this) {
			return true;
		}

		if (!(obj instanceof Item)) {
			return false;
		}

		final Item other = (Item) obj;

		return sameIdentityAs(other);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE).toString();
	}

	Item() {
		// Hibernate
	}
	
}
