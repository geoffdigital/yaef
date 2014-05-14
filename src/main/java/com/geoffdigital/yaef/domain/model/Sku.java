package com.geoffdigital.yaef.domain.model;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.geoffdigital.yaef.domain.model.shared.ValueObject;

public class Sku implements ValueObject<Sku> {

	private static final long serialVersionUID = -1951112629365322702L;

	private String sku;

	public Sku(final String sku) {
		Validate.notNull(sku, "sku must be set");
		this.sku = sku;
	}

	public String getSku() {
		return sku;
	}

	@Override
	public boolean sameValueAs(final Sku other) {
		return other != null && StringUtils.equals(sku, other.sku);
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

		if (!(obj instanceof Sku)) {
			return false;
		}

		final Sku other = (Sku) obj;

		return sameValueAs(other);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE).toString();
	}

	Sku() {
		// Hibernate
	}

}
