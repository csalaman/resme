package com.menuu.merchant_menu_service.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.menuu.merchant_menu_service.models.ItemOption;
import com.menuu.merchant_menu_service.models.MerchantLocation;
import com.menuu.merchant_menu_service.models.Modifier;
import com.menuu.merchant_menu_service.models.dto.ModifierDetailsDTO;
import com.menuu.merchant_menu_service.models.dto.ModifierOptionsDTO;
import com.menuu.merchant_menu_service.repositories.MerchantLocationRepository;
import com.menuu.merchant_menu_service.repositories.ModifierRepository;

/**
 * Service for managing modifiers and modifier item options
 */
@Service
public class ModifierServiceImpl implements ModifierService {

	@Autowired
	private ModifierRepository modRepo;
	@Autowired
	private MerchantLocationRepository mlRepo;

	@Override
	public Modifier createModifier(final String uuidML, final Modifier modifier) {
		final Optional<MerchantLocation> merchantLoc = mlRepo.findById(uuidML);
		if (merchantLoc.isPresent()) {
			modifier.setMerchantLocationId(uuidML);
			final Modifier newModifier = modRepo.save(modifier);
			return newModifier;
		} else {
			return null;
		}
	}

	@Override
	public Modifier addModifierOptions(final String uuid, final ModifierOptionsDTO modifierOptions) {
		modRepo.findById(uuid).ifPresent((curMod) -> {
			if (curMod.getOptions() == null) {
				curMod.setOptions(new ArrayList<ItemOption>());
			}
			modifierOptions.getOptions().forEach((opt) -> {
				curMod.getOptions().add(opt);
			});
			modRepo.save(curMod);
		});
		return modRepo.findById(uuid).get();
	}

	@Override
	public Modifier removeModifierOptions(final String uuid, final ModifierOptionsDTO modifierOptions) {
		modRepo.findById(uuid).ifPresent((curMod) -> {
			if (curMod.getOptions() == null) {
				curMod.setOptions(new ArrayList<ItemOption>());
			}
			modifierOptions.getOptions().forEach((opt) -> {
				curMod.getOptions().remove(opt);
			});
			modRepo.save(curMod);
		});
		return modRepo.findById(uuid).get();
	}

	@Override
	public List<Modifier> getAllModifiersForLocation(final String uuidML) {
		return modRepo.findAll().stream().filter((mod) -> mod.getMerchantLocationId().equals(uuidML))
				.collect(Collectors.toList());
	}

	@Override
	public Modifier getModifier(final String uuid) {
		final Optional<Modifier> modifier = modRepo.findById(uuid);
		if (modifier.isPresent()) {
			return modifier.get();
		} else {
			return null;
		}
	}

	@Override
	public Modifier removeModifier(final String uuid) {
		final Optional<Modifier> modifier = modRepo.findById(uuid);
		if (modifier.isPresent()) {
			modRepo.deleteById(uuid);
			return modifier.get();
		} else {
			return null;
		}
	}

	@Override
	public Modifier updateModifierDetails(final String uuid, final ModifierDetailsDTO details) {
		final Optional<Modifier> mod = modRepo.findById(uuid);
		if (mod.isPresent()) {
			final Modifier updateMod = mod.get();
			updateMod.setTitle((details.getTitle() == null) ? updateMod.getTitle() : details.getTitle());
			updateMod.setOptionsMaxLimit(details.getOptionsMaxLimit());
			updateMod.setLimitRequired((details.isLimitRequired() && details.getOptionsMaxLimit() > 0));
			return modRepo.save(updateMod);
		} else {
			return null;
		}
	}

}
