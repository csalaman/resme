package com.menuu.merchant_menu_service.services;

import com.menuu.merchant_menu_service.models.MerchantLocation;
import com.menuu.merchant_menu_service.models.dto.AddressDTO;
import com.menuu.merchant_menu_service.models.dto.MerchantLocationDetailsDTO;
import com.menuu.merchant_menu_service.models.dto.NameFieldDTO;

/**
 * Interface for the merchant location service
 */
public interface MerchantLocationService {

	/*
	 * Retrieve a specific merchant location information
	 */
	MerchantLocation getMerchantLocation(final String id);

	/*
	 * Create a new merchant location
	 */
	MerchantLocation createMerchantLocation(final MerchantLocation merchantLocation);

	/*
	 * Update a merchant's location name
	 */
	MerchantLocation updateMerchantLocationName(final String uuid, final NameFieldDTO mlNameDto);

	/*
	 * Update a merchant's location address
	 */
	MerchantLocation updateMerchantLocationAddress(final String uuid, final AddressDTO mlAddressDto);

	/**
	 * Update a merchant location's details
	 * 
	 * @param uuid
	 * @param details
	 * @return
	 */
	MerchantLocation updateMerchantLocationDetails(final String uuid, final MerchantLocationDetailsDTO details);
}
