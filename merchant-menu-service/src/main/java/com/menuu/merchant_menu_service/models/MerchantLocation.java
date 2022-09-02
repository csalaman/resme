package com.menuu.merchant_menu_service.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Model representation of a merchant's physical location
 */
@Document(collection = "MerchantLocation")
public class MerchantLocation {

	@Id()
	private String id;
	private String name;
	private String addressPrimary;
	private String addressSecondary;
	private String city;
	private String state;
	private String zipcode;
	private String country;
	private List<String> menuIds;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddressPrimary() {
		return addressPrimary;
	}

	public void setAddressPrimary(String addressPrimary) {
		this.addressPrimary = addressPrimary;
	}

	public String getAddressSecondary() {
		return addressSecondary;
	}

	public void setAddressSecondary(String addressSecondary) {
		this.addressSecondary = addressSecondary;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<String> getMenuIds() {
		return menuIds;
	}

	public void setMenuIds(List<String> menuIds) {
		this.menuIds = menuIds;
	}

	@Override
	public String toString() {
		return "MerchantLocation [id=" + id + ", name=" + name + ", addressPrimary=" + addressPrimary
				+ ", addressSecondary=" + addressSecondary + ", city=" + city + ", state=" + state + ", zipcode="
				+ zipcode + ", country=" + country + ", menuIds=" + menuIds + "]";
	}

}
