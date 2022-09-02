package com.menuu.merchant_menu_service.services;

import java.util.List;

import com.menuu.merchant_menu_service.models.Menu;
import com.menuu.merchant_menu_service.models.dto.MenuHoursDTO;
import com.menuu.merchant_menu_service.models.dto.NameFieldDTO;

/**
 * Service interface for menu managements
 */
public interface MenuService {

	/**
	 * Gets a specific menu
	 * 
	 * @param uuid The menu's UUID
	 * @return
	 */
	Menu getMenu(final String uuid);

	/**
	 * Retrieves a list of menus for a specific merchant location
	 * 
	 * @param uuidML
	 * @return
	 */
	List<Menu> getMenusForLocation(final String uuidML);

	/**
	 * Create a menu for a specific merchant location
	 * 
	 * @param uuidML The merchant location's UUID
	 * @param menu   The new menu to add
	 * @return the created menu
	 */
	Menu createMenu(final String uuidML, final Menu menu);

	/**
	 * Update a menu's name
	 * 
	 * @param uuid        The menu's UUID
	 * @param menuNameDto The menu name DTO
	 * @return The updated menu
	 */
	Menu updateMenuName(final String uuid, final NameFieldDTO menuNameDto);

	/**
	 * Deletes a menu
	 * 
	 * @param uuid The menu's UUID to delete
	 * @return The deleted menu
	 */
	Menu removeMenu(final String uuid);

	/**
	 * Update a menu's availability hours
	 * 
	 * @param uuid  The menu's UUID
	 * @param hours List/Set of available hours
	 * @return The menu with the updated hours
	 */
	Menu updateMenuHours(final String uuid, final MenuHoursDTO hours);

}
