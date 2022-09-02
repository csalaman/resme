package com.menuu.merchant_menu_service.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.menuu.merchant_menu_service.models.Menu;
import com.menuu.merchant_menu_service.models.MerchantLocation;
import com.menuu.merchant_menu_service.models.OperationalDay;
import com.menuu.merchant_menu_service.models.dto.MenuHoursDTO;
import com.menuu.merchant_menu_service.models.dto.NameFieldDTO;
import com.menuu.merchant_menu_service.repositories.MenuRepository;
import com.menuu.merchant_menu_service.repositories.MerchantLocationRepository;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MerchantLocationRepository mlRepo;

	@Autowired
	private MenuRepository menuRepo;

	@Override
	public Menu createMenu(final String uuidML, final Menu menu) {
		final Optional<MerchantLocation> merchantLocation = mlRepo.findById(uuidML);
		if (merchantLocation.isPresent()) {
			final String merchantLocationId = merchantLocation.get().getId();
			menu.setMerchantLocationId(merchantLocationId);
			final Menu newMenu = menuRepo.save(menu);
			final MerchantLocation mercLoc = merchantLocation.get();
			if (mercLoc.getMenuIds() == null) {
				mercLoc.setMenuIds(new ArrayList<>());
			}
			mercLoc.getMenuIds().add(newMenu.getId());
			mlRepo.save(mercLoc);
			return newMenu;
		} else {
			return null;
//			throw new Exception("Merchant Location for this menu not found.");
		}
	}

	@Override
	public Menu updateMenuName(final String uuid, final NameFieldDTO menuNameDto) {
		final Optional<Menu> selectedMenu = menuRepo.findById(uuid);
		if (selectedMenu.isPresent() && menuNameDto.getName() != null && menuNameDto.getName().length() > 0) {
			final Menu updateMenu = selectedMenu.get();
			updateMenu.setName(menuNameDto.getName());
			return menuRepo.save(updateMenu);
		} else {
			return null;
		}
	}

	@Override
	public Menu getMenu(String uuid) {
		return menuRepo.findById(uuid).get();
	}

	@Override
	public Menu removeMenu(String uuid) {
		final Optional<Menu> menuToDelete = menuRepo.findById(uuid);
		menuToDelete.ifPresent((menu) -> {
			menuRepo.deleteById(menu.getId());
			mlRepo.findById(menu.getMerchantLocationId()).ifPresent((merchantLocation) -> {
				merchantLocation.getMenuIds().remove(menu.getId());
				mlRepo.save(merchantLocation);
			});
		});
		return menuToDelete.get();
	}

	@Override
	public Menu updateMenuHours(final String uuid, final MenuHoursDTO hours) {
		final Optional<Menu> updatedMenu = menuRepo.findById(uuid);
		updatedMenu.ifPresent((menu) -> {
			if (menu.getAvailableHours() == null) {
				menu.setAvailableHours(new ArrayList<OperationalDay>());
			}
			hours.getHours().forEach((day) -> {
				menu.getAvailableHours().add(day);
			});
			menuRepo.save(menu);
		});
		return menuRepo.findById(uuid).get();
	}

	@Override
	public List<Menu> getMenusForLocation(String uuidML) {
		return menuRepo.findAll().stream().filter((menu) -> menu.getMerchantLocationId().equals(uuidML))
				.collect(Collectors.toList());
	}
}
