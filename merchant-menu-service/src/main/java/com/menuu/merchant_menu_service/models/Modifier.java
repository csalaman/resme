package com.menuu.merchant_menu_service.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Model to represent a modifier group of options for menu items
 */
@Document(collection = "Modifier")
public class Modifier {

	@Id()
	private String id;
	private String merchantLocationId;
	private String title;
	private int optionsMaxLimit;
	private List<ItemOption> options;
	private boolean limitRequired;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<ItemOption> getOptions() {
		return options;
	}

	public void setOptions(List<ItemOption> options) {
		this.options = options;
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

	@Override
	public String toString() {
		return "Modifier [id=" + id + ", merchantLocationId=" + merchantLocationId + ", title=" + title
				+ ", optionsMaxLimit=" + optionsMaxLimit + ", options=" + options + ", isLimitRequired=" + limitRequired
				+ "]";
	}

}
