package com.menuu.merchant_menu_service.utils;

import java.util.Optional;

/**
 * Utility class for Data-Transfer Objects
 */
public class DtoUtils {

	/*
	 * Returns a nullable optional of a DTO field
	 */
	public static <T> Optional<T> dtoField(final T field) {
		return Optional.ofNullable(field);
	}

}
