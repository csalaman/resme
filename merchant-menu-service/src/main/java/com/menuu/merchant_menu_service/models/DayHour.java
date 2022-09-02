package com.menuu.merchant_menu_service.models;

import com.menuu.merchant_menu_service.models.enums.Hour;
import com.menuu.merchant_menu_service.models.enums.HourPeriod;

/**
 * Model to represent a specific hour/period in the day
 */
public class DayHour {

	private Hour hour;
	private HourPeriod period;

	public Hour getHour() {
		return hour;
	}

	public void setHour(Hour hour) {
		this.hour = hour;
	}

	public HourPeriod getPeriod() {
		return period;
	}

	public void setPeriod(HourPeriod period) {
		this.period = period;
	}

	@Override
	public String toString() {
		return "DayHour [hour=" + hour + ", period=" + period + "]";
	}
}
