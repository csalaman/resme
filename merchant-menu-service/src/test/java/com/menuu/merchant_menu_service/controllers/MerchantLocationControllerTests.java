package com.menuu.merchant_menu_service.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.menuu.merchant_menu_service.models.MerchantLocation;
import com.menuu.merchant_menu_service.models.dto.AddressDTO;
import com.menuu.merchant_menu_service.models.dto.NameFieldDTO;
import com.menuu.merchant_menu_service.services.MerchantLocationService;

@ExtendWith(MockitoExtension.class)
public class MerchantLocationControllerTests {

	@InjectMocks
	private MerchantLocationController testObject;

	@Mock
	private MerchantLocationService merchantLocationServiceMock;

	@Test
	public void testCreateItem() {
		final MerchantLocation merchantLocation = new MerchantLocation();
		merchantLocation.setId("ML_ID_01");
		when(merchantLocationServiceMock.createMerchantLocation(merchantLocation)).thenReturn(merchantLocation);
		testObject.createMerchantLocation(merchantLocation);

		verify(merchantLocationServiceMock, times(0)).createMerchantLocation(new MerchantLocation());
		verify(merchantLocationServiceMock, times(1)).createMerchantLocation(merchantLocation);
	}

	@Test
	public void testGetMerchantLocation() {
		final MerchantLocation merchantLocation = new MerchantLocation();
		merchantLocation.setId("ML_ID_02");
		when(merchantLocationServiceMock.getMerchantLocation("ML_ID_02")).thenReturn(merchantLocation);
		final MerchantLocation result = testObject.getMerchantLocation("ML_ID_02");

		verify(merchantLocationServiceMock, times(0)).getMerchantLocation("ML_ID_01");
		verify(merchantLocationServiceMock, times(1)).getMerchantLocation("ML_ID_02");
		assertEquals(merchantLocation.getId(), result.getId());
	}

	@Test
	public void testUpdateMerchantLocationName() {
		final String mockId = "ML_ID_03";
		final NameFieldDTO nameUpdate = new NameFieldDTO();
		nameUpdate.setName("Lunch");
		testObject.updateMerchantLocationName(mockId, nameUpdate);

		verify(merchantLocationServiceMock, times(1)).updateMerchantLocationName(mockId, nameUpdate);
	}

	@Test
	public void testUpdateMerchantLocationAddress() {
		final String mockId = "ML_ID_04";
		final AddressDTO addressUpdate = new AddressDTO();
		addressUpdate.setAddressPrimary("123 Main ST");
		testObject.updateMerchantLocationAddress(mockId, addressUpdate);

		verify(merchantLocationServiceMock, times(1)).updateMerchantLocationAddress(mockId, addressUpdate);
	}
	
	@Test 
	public void testUpdateMerchantLocationDetails() {
		
	}
}
