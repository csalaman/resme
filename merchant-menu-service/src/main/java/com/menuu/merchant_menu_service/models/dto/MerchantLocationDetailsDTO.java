package com.menuu.merchant_menu_service.models.dto;

/**
 * Data-Transfer-Object for merchant location's details
 */
public class MerchantLocationDetailsDTO {

	private String name;
	private String addressPrimary;
	private String addressSecondary;
	private String city;
	private String state;
	private String zipcode;
	private String country;

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
}
