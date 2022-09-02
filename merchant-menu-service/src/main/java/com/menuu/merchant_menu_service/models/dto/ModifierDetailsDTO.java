package com.menuu.merchant_menu_service.models.dto;

/**
 * Data-Transfer-Object for modifier details
 */
public class ModifierDetailsDTO {
	private String title;
	private int optionsMaxLimit;
	private boolean limitRequired;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getOptionsMaxLimit() {
		return optionsMaxLimit;
	}

	public void setOptionsMaxLimit(int optionsMaxLimit) {
		this.optionsMaxLimit = optionsMaxLimit;
	}

	public boolean isLimitRequired() {
		return limitRequired;
	}

	public void setLimitRequired(boolean limitRequired) {
		this.limitRequired = limitRequired;
	}
}
