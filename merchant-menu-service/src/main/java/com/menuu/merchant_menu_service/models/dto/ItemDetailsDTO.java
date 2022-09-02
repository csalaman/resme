package com.menuu.merchant_menu_service.models.dto;

/**
 * Data-Transfer-Object for menu item details
 */
public class ItemDetailsDTO {

	public String name;
	public String description;
	public double price;
	public double tax;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}
}
