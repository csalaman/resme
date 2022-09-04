package com.menuu.merchant_menu_service.services;

import java.util.Objects;
import java.util.Optional;

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
		final Optional<MerchantLocation> duplicateML = mlRepo.findAll().stream().filter((ml) -> {
			return merchantLocation.getAddressPrimary().equals(ml.getAddressPrimary());
		}).findFirst();
		if (duplicateML.isPresent()) {
			// Failed, duplicate location address
			return null;
		}
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
	public MerchantLocation updateMerchantLocationAddress(final String uuid, final AddressDTO mlAddressDto) {
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
		Objects.requireNonNull(uuid);
		Objects.requireNonNull(details);

		// TODO: Update as patch, with Map of Field:Value pairs
		mlRepo.findById(uuid).ifPresentOrElse((merchantLocation) -> {
			merchantLocation.setName(details.getName());
			merchantLocation.setAddressPrimary(details.getAddressPrimary());
			merchantLocation.setAddressSecondary(details.getAddressSecondary());
			merchantLocation.setCity(details.getCity());
			merchantLocation.setState(details.getState());
			merchantLocation.setZipcode(details.getZipcode());
			merchantLocation.setCountry(details.getCountry());
			mlRepo.save(merchantLocation);
		}, () -> {
			// Failed to find by ID
		});

		return mlRepo.findById(uuid).get();
	}

}
