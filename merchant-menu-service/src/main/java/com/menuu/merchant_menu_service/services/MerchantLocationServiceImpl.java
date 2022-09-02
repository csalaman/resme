package com.menuu.merchant_menu_service.services;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.menuu.merchant_menu_service.models.MerchantLocation;
import com.menuu.merchant_menu_service.models.dto.AddressDTO;
import com.menuu.merchant_menu_service.models.dto.MerchantLocationDetailsDTO;
import com.menuu.merchant_menu_service.models.dto.NameFieldDTO;
import com.menuu.merchant_menu_service.repositories.MerchantLocationRepository;
import com.menuu.merchant_menu_service.utils.DtoUtils;

/**
 * The merchant location service implementation
 */
@Service
public class MerchantLocationServiceImpl implements MerchantLocationService {

	@Autowired
	private MerchantLocationRepository mlRepo;

	/*
	 * {@inheritDocs}
	 */
	@Override
	public MerchantLocation getMerchantLocation(final String id) {
		return mlRepo.findById(id).get();
	}

	/*
	 * {@inheritDocs}
	 */
	@Override
	public MerchantLocation createMerchantLocation(final MerchantLocation merchantLocation) {
		Objects.requireNonNull(merchantLocation);
		return mlRepo.save(merchantLocation);
	}

	/*
	 * {@inheritDocs}
	 */
	@Override
	public MerchantLocation updateMerchantLocationName(final String uuid, final NameFieldDTO mlNameDto) {
		Objects.requireNonNull(uuid);
		Objects.requireNonNull(mlNameDto);

		mlRepo.findById(uuid).ifPresent((merchantLocation) -> {
			DtoUtils.dtoField(mlNameDto.getName()).ifPresent((updatedName) -> {
				merchantLocation.setName(updatedName);
			});
			mlRepo.save(merchantLocation);
		});
		return mlRepo.findById(uuid).get();
	}

	/*
	 * {@inheritDocs}
	 */
	@Override
	public MerchantLocation updateMerchantLocationAddress(final String uuid,
			final AddressDTO mlAddressDto) {
		Objects.requireNonNull(uuid);
		Objects.requireNonNull(mlAddressDto);

		mlRepo.findById(uuid).ifPresent((merchantLocation) -> {
			merchantLocation.setAddressPrimary(mlAddressDto.getAddressPrimary());
			merchantLocation.setAddressSecondary(mlAddressDto.getAddressSecondary());
			merchantLocation.setCity(mlAddressDto.getCity());
			merchantLocation.setState(mlAddressDto.getState());
			merchantLocation.setZipcode(mlAddressDto.getZipcode());
			merchantLocation.setCountry(mlAddressDto.getCountry());
			mlRepo.save(merchantLocation);
		});
		return mlRepo.findById(uuid).get();
	}

	@Override
	public MerchantLocation updateMerchantLocationDetails(final String uuid, final MerchantLocationDetailsDTO details) {
		// TODO Auto-generated method stub
		return null;
	}

}
