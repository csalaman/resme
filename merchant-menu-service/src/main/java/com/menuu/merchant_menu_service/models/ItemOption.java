package com.menuu.merchant_menu_service.models;

import java.util.Objects;

/**
 * Model to represent an item option for modifiers
 */
public class ItemOption {

	public String name;
	public double optionalFee;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getOptionalFee() {
		return optionalFee;
	}

	public void setOptionalFee(double optionalFee) {
		this.optionalFee = optionalFee;
	}

	@Override
	public String toString() {
		return "ItemOption [name=" + name + ", optionalFee=" + optionalFee + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, optionalFee);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemOption other = (ItemOption) obj;
		return Objects.equals(name, other.name)
				&& Double.doubleToLongBits(optionalFee) == Double.doubleToLongBits(other.optionalFee);
	}

}
