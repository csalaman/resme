package com.menuu.merchant_menu_service.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.menuu.merchant_menu_service.models.MerchantLocation;
import com.menuu.merchant_menu_service.repositories.MerchantLocationRepository;

@ExtendWith(MockitoExtension.class)
public class MerchantLocationServiceImplTests {

	@InjectMocks
	private MerchantLocationServiceImpl testObject;

	@Mock
	private MerchantLocationRepository merchantLocationRepositoryMock;

	@Test
	public void testGetMerchantLocation() {
		final MerchantLocation merchantLocation = new MerchantLocation();
		merchantLocation.setId("ML_ID_01");
		when(merchantLocationRepositoryMock.findById(merchantLocation.getId()))
				.thenReturn(Optional.of(merchantLocation));
		final MerchantLocation result = testObject.getMerchantLocation(merchantLocation.getId());

		verify(merchantLocationRepositoryMock, times(1)).findById(merchantLocation.getId());
		verify(merchantLocationRepositoryMock, times(0)).findById("ML_ID_02");

	}

	@Test
	public void testCreateMerchantLocation() {
		final MerchantLocation merchantLocation = new MerchantLocation();
		merchantLocation.setId("ML_ID_02");
		when(merchantLocationRepositoryMock.save(merchantLocation)).thenReturn(merchantLocation);
		final MerchantLocation result = testObject.createMerchantLocation(merchantLocation);

		verify(merchantLocationRepositoryMock, times(1)).save(merchantLocation);
		assertEquals(merchantLocation, result);
	}
	
	@Test
	public void testDuplicateAddressMerchantLocation() {
		
	}

	@Test
	public void testUpdateMerchantLocationDetails() {
		//TODO: Update as patch, with Map of Field:Value pairs
		final MerchantLocation ml = new MerchantLocation();
		ml.setName("ABC");
		ml.setAddressPrimary("123");
		ml.setAddressSecondary("PO");
		ml.setCity("X");
		ml.setZipcode("900");
		ml.setState("MD");
		ml.setCountry("USA");
		
	}
}
