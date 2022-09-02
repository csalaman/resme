package com.menuu.merchant_menu_service.services;

import java.util.List;

import com.menuu.merchant_menu_service.models.Item;
import com.menuu.merchant_menu_service.models.dto.ItemDetailsDTO;
import com.menuu.merchant_menu_service.models.dto.ItemModifiersDTO;

/**
 * Interface for the menu item service implementation
 */
public interface ItemService {

	/**
	 * Create a menu item for a specific menu
	 * 
	 * @param uuidMenu The menu's UUID
	 * @param item     The item to create
	 * @return Created item
	 */
	Item createItem(final String uuidMenu, final Item item);

	/**
	 * Retrieves a specific menu item
	 * 
	 * @param uuid
	 * @return
	 */
	Item getItem(final String uuid);

	/**
	 * Retrieves all menu items for a menu
	 * 
	 * @param uuidMenu
	 * @return
	 */
	List<Item> getAllItemsForMenu(final String uuidMenu);

	/**
	 * Update a menu item's basic details
	 * 
	 * @param uuid    The menu's UUID
	 * @param details The detail updates DTO
	 * @return The updated menu item
	 */
	Item updateItemDetails(final String uuid, final ItemDetailsDTO details);

	/**
	 * Add the menu item modifiers
	 * 
	 * @param uuid      Menu UUID
	 * @param modifiers List of modifiers to add
	 * @return
	 */
	Item addItemModifiers(final String uuid, final ItemModifiersDTO modifiers);

	/**
	 * Delete the menu item modifiers
	 * 
	 * @param uuid      Menu UUID
	 * @param modifiers List of modifiers to remove
	 * @return
	 */
	Item removeItemModifiers(final String uuid, final ItemModifiersDTO modifiers);

	/**
	 * Deletes a menu item from a menu
	 * 
	 * @param uuid The menu UUID to delete
	 * @return
	 */
	Item removeItem(final String uuid);

}
