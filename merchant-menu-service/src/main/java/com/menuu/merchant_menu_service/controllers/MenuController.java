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

import com.menuu.merchant_menu_service.models.Menu;
import com.menuu.merchant_menu_service.models.dto.MenuHoursDTO;
import com.menuu.merchant_menu_service.models.dto.NameFieldDTO;
import com.menuu.merchant_menu_service.services.MenuService;

@RestController()
@RequestMapping("/v1.0/menus")
public class MenuController {

	@Autowired
	private MenuService menuService;

	@GetMapping("/{uuid}")
	public Menu getMenu(@PathVariable() final String uuid) {
		return menuService.getMenu(uuid);
	}

	@PostMapping("/location/{uuidML}")
	public Menu createMenu(@PathVariable() final String uuidML, @RequestBody() final Menu menu) {
		return menuService.createMenu(uuidML, menu);
	}

	@GetMapping("/location/{uuidML}")
	public List<Menu> getMenusForLocation(@PathVariable() final String uuidML) {
		return menuService.getMenusForLocation(uuidML);
	}

	@PutMapping("/name/{uuid}")
	public Menu updateMenuName(@PathVariable() final String uuid, @RequestBody() final NameFieldDTO menuNameDto) {
		return menuService.updateMenuName(uuid, menuNameDto);
	}

	@PutMapping("/hours/{uuid}")
	public Menu updateMenuHours(@PathVariable() final String uuid, @RequestBody() final MenuHoursDTO menuHoursDto) {
		return menuService.updateMenuHours(uuid, menuHoursDto);
	}

	@DeleteMapping("/{uuid}")
	public Menu removeMenu(@PathVariable() final String uuid) {
		return menuService.removeMenu(uuid);
	}
}
