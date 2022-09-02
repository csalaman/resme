package com.menuu.merchant_menu_service.models.dto;

import java.util.List;

import com.menuu.merchant_menu_service.models.OperationalDay;

/**
 * Data-Transfer-Object for menu hours
 */
public class MenuHoursDTO {
	private List<OperationalDay> hours;

	public List<OperationalDay> getHours() {
		return hours;
	}

	public void setHours(List<OperationalDay> hours) {
		this.hours = hours;
	}
}
