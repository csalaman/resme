package com.menuu.merchant_menu_service.models.dto;

import java.util.List;

import com.menuu.merchant_menu_service.models.ItemOption;

/**
 * Data-Transfer-Object for modifier item options
 */
public class ModifierOptionsDTO {
	private List<ItemOption> options;

	public List<ItemOption> getOptions() {
		return options;
	}

	public void setOptions(List<ItemOption> options) {
		this.options = options;
	}
}
