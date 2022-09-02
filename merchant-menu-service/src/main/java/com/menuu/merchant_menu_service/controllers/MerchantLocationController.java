package com.menuu.merchant_menu_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.menuu.merchant_menu_service.models.MerchantLocation;
import com.menuu.merchant_menu_service.models.dto.AddressDTO;
import com.menuu.merchant_menu_service.models.dto.NameFieldDTO;
import com.menuu.merchant_menu_service.services.MerchantLocationService;

@RestController()
@RequestMapping("/v1.0/merchant-locations")
public class MerchantLocationController {

	@Autowired
	private MerchantLocationService mlService;

	@GetMapping("/{uuid}")
	public MerchantLocation getMerchantLocation(@PathVariable() final String uuid) {
		return mlService.getMerchantLocation(uuid);
	}

	@PostMapping
	public MerchantLocation createMerchantLocation(@RequestBody() final MerchantLocation merchantLocation) {
		return mlService.createMerchantLocation(merchantLocation);
	}

	//TODO: Refactor as MerchantLocationDetailsDTO
	@PutMapping("/name/{uuid}")
	public MerchantLocation updateMerchantLocationName(@PathVariable() final String uuid,
			@RequestBody() final NameFieldDTO mlNameDto) {
		return mlService.updateMerchantLocationName(uuid, mlNameDto);
	}

	@PutMapping("/address/{uuid}")
	public MerchantLocation updateMerchantLocationAddress(@PathVariable() final String uuid,
			@RequestBody() final AddressDTO mlAddressDto) {
		return mlService.updateMerchantLocationAddress(uuid, mlAddressDto);
	}
}
