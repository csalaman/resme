package com.menuu.merchant_menu_service.models.dto;

import java.util.List;

/**
 * Data-Transfer-Object for menu item's modifiers
 */
public class ItemModifiersDTO {

	private List<String> modifiers;

	public List<String> getModifiers() {
		return modifiers;
	}

	public void setModifiers(List<String> modifiers) {
		this.modifiers = modifiers;
	}
}
