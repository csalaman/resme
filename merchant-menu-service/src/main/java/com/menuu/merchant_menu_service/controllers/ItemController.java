package com.menuu.merchant_menu_service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.menuu.merchant_menu_service.models.Item;
import com.menuu.merchant_menu_service.models.dto.ItemDetailsDTO;
import com.menuu.merchant_menu_service.models.dto.ItemModifiersDTO;
import com.menuu.merchant_menu_service.services.ItemService;

@RestController()
@RequestMapping("/v1.0/items")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@PostMapping("/menu/{uuidMenu}")
	public Item createItem(@PathVariable() final String uuidMenu, @RequestBody() final Item item) {
		return itemService.createItem(uuidMenu, item);
	}

	@GetMapping("/menu/{uuidMenu}")
	public List<Item> getAllItemsForMenu(@PathVariable() final String uuidMenu) {
		return itemService.getAllItemsForMenu(uuidMenu);
	}

	@PutMapping("/details/{uuid}")
	public Item updateItemDetails(@PathVariable() final String uuid, @RequestBody() final ItemDetailsDTO details) {
		return itemService.updateItemDetails(uuid, details);
	}

	@PutMapping("/modifiers/{uuid}")
	public Item addItemModifiers(@PathVariable final String uuid, @RequestBody final ItemModifiersDTO modifiers) {
		return itemService.addItemModifiers(uuid, modifiers);
	}

	@DeleteMapping("/modifiers/{uuid}")
	public Item removeItemModifiers(@PathVariable final String uuid, @RequestBody final ItemModifiersDTO modifiers) {
		return itemService.removeItemModifiers(uuid, modifiers);
	}

	@DeleteMapping("/{uuid}")
	public Item removeItem(@PathVariable() final String uuid) {
		return itemService.removeItem(uuid);
	}

	@GetMapping("/{uuid}")
	public Item getItem(@PathVariable final String uuid) {
		return itemService.getItem(uuid);
	}
}
