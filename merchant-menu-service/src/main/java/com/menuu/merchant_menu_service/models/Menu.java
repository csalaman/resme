package com.menuu.merchant_menu_service.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Model representation of a merchant's menu for a location
 */
@Document(collection = "Menu")
public class Menu {

	@Id()
	private String id;
	private String merchantLocationId;
	private String name;
	private List<String> menuItemIds;
	private List<OperationalDay> availableHours;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMerchantLocationId() {
		return merchantLocationId;
	}

	public void setMerchantLocationId(String merchantLocationId) {
		this.merchantLocationId = merchantLocationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getMenuItemIds() {
		return menuItemIds;
	}

	public void setMenuItems(List<String> menuItemIds) {
		this.menuItemIds = menuItemIds;
	}

	public List<OperationalDay> getAvailableHours() {
		return availableHours;
	}

	public void setAvailableHours(List<OperationalDay> availableHours) {
		this.availableHours = availableHours;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", merchantLocationId=" + merchantLocationId + ", name=" + name + ", menuItemIds="
				+ menuItemIds + ", availableHours=" + availableHours + "]";
	}

}
