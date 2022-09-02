package com.menuu.merchant_menu_service.services;

import java.util.List;

import com.menuu.merchant_menu_service.models.Modifier;
import com.menuu.merchant_menu_service.models.dto.ModifierDetailsDTO;
import com.menuu.merchant_menu_service.models.dto.ModifierOptionsDTO;

/**
 * Service interface for menu item modifier options
 */
public interface ModifierService {

	/**
	 * Create a new menu item modifier
	 * 
	 * @param uuidML   Merchant Location UUID
	 * @param modifier
	 * @return
	 */
	Modifier createModifier(final String uuidML, final Modifier modifier);

	/**
	 * Update the modifier details
	 * 
	 * @param uuid
	 * @param details
	 * @return
	 */
	Modifier updateModifierDetails(final String uuid, final ModifierDetailsDTO details);

	/**
	 * Add a list of modifier options to a specific modifier
	 * 
	 * @param uuid
	 * @param modifiers
	 * @return
	 */
	Modifier addModifierOptions(final String uuid, final ModifierOptionsDTO modifiers);

	/**
	 * Remove a list of modifier options from a specific modifier
	 * 
	 * @param uuid
	 * @param modifier
	 * @return
	 */
	Modifier removeModifierOptions(final String uuid, final ModifierOptionsDTO modifier);

	/**
	 * Retrieve all modifiers
	 * 
	 * @param uuidML Merchant Location UUID
	 * @return
	 */
	List<Modifier> getAllModifiersForLocation(final String uuidML);

	/**
	 * Retrieve a modifier
	 * 
	 * @param uuid
	 * @return
	 */
	Modifier getModifier(final String uuid);

	/**
	 * Delete a modifier
	 * 
	 * @param uuid
	 * @return
	 */
	Modifier removeModifier(final String uuid);
}
