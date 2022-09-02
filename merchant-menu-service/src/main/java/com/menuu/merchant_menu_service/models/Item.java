package com.menuu.merchant_menu_service.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Model representation of a menu item
 */
@Document(collection = "Item")
public class Item {

	@Id()
	private String id;
	private String menuId;
	private String name;
	private String description;
	private double price;
	private double tax;
	private List<String> modifiers;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

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

	public List<String> getModifiers() {
		return modifiers;
	}

	public void setModifiers(List<String> modifiers) {
		this.modifiers = modifiers;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", menuId=" + menuId + ", name=" + name + ", description=" + description + ", price="
				+ price + ", tax=" + tax + ", modifiers=" + modifiers + "]";
	}

}
