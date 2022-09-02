package com.menuu.merchant_menu_service.models;

import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * Model to represent the opening hours for a day
 */
public class OperationalDay {

	private DayOfWeek day;
	private LocalTime startTime;
	private LocalTime endTime;

	public DayOfWeek getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = DayOfWeek.valueOf(day);
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "OperationalDay [day=" + day + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
}
