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

import com.menuu.merchant_menu_service.models.Modifier;
import com.menuu.merchant_menu_service.models.dto.ModifierDetailsDTO;
import com.menuu.merchant_menu_service.models.dto.ModifierOptionsDTO;
import com.menuu.merchant_menu_service.services.ModifierService;

@RestController()
@RequestMapping("/v1.0/modifiers")
public class ModifierController {

	@Autowired
	private ModifierService modService;

	@PostMapping("/location/{uuidML}")
	public Modifier createModifier(@PathVariable final String uuidML, @RequestBody final Modifier modifier) {
		return modService.createModifier(uuidML, modifier);
	}

	@GetMapping("/location/{uuidML}")
	public List<Modifier> getAllModifierForLocation(@PathVariable final String uuidML) {
		return modService.getAllModifiersForLocation(uuidML);
	}

	@PutMapping("/options/{uuid}")
	public Modifier addModifierOptions(@PathVariable final String uuid,
			@RequestBody final ModifierOptionsDTO modifierOptions) {
		return modService.addModifierOptions(uuid, modifierOptions);
	}

	@PutMapping("/details/{uuid}")
	public Modifier updateModifierDetails(@PathVariable final String uuid,
			@RequestBody final ModifierDetailsDTO details) {
		return modService.updateModifierDetails(uuid, details);
	}

	@DeleteMapping("/options/{uuid}")
	public Modifier removeModifierOptions(@PathVariable final String uuid,
			@RequestBody final ModifierOptionsDTO modifierOptions) {
		return modService.removeModifierOptions(uuid, modifierOptions);
	}

	@GetMapping("/{uuid}")
	public Modifier getModifier(@PathVariable final String uuid) {
		return modService.getModifier(uuid);
	}

	@DeleteMapping("/{uuid}")
	public Modifier removeModifier(@PathVariable final String uuid) {
		return modService.removeModifier(uuid);
	}

}
