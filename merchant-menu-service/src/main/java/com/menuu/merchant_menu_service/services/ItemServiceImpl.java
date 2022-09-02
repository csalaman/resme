package com.menuu.merchant_menu_service.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.menuu.merchant_menu_service.models.Item;
import com.menuu.merchant_menu_service.models.dto.ItemDetailsDTO;
import com.menuu.merchant_menu_service.models.dto.ItemModifiersDTO;
import com.menuu.merchant_menu_service.repositories.ItemRepository;
import com.menuu.merchant_menu_service.repositories.MenuRepository;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepo;

	@Autowired
	private MenuRepository menuRepo;

	@Override
	public Item createItem(final String uuidMenu, final Item item) {
		item.setMenuId(uuidMenu);
		final Item newItem = itemRepo.save(item);
		menuRepo.findById(uuidMenu).ifPresentOrElse((menu) -> {
			if (menu.getMenuItemIds() == null) {
				menu.setMenuItems(new ArrayList<>());
			}
			menu.getMenuItemIds().add(item.getId());
			menuRepo.save(menu);
		}, () -> {
			itemRepo.delete(newItem);
		});
		return newItem;
	}

	@Override
	public Item updateItemDetails(String uuid, ItemDetailsDTO details) {
		final Optional<Item> item = itemRepo.findById(uuid);
		if (item.isPresent()) {
			final Item updateItem = item.get();
			updateItem.setName(details.getName());
			updateItem.setDescription(details.getDescription());
			updateItem.setPrice(details.getPrice());
			updateItem.setTax(details.getTax());
			return itemRepo.save(updateItem);
		} else {
			return null;
		}
	}

	@Override
	public Item addItemModifiers(String uuid, ItemModifiersDTO modifiers) {
		final Optional<Item> item = itemRepo.findById(uuid);
		if (item.isPresent()) {
			final Item updateItem = item.get();
			if (updateItem.getModifiers() == null) {
				updateItem.setModifiers(new ArrayList<>());
			}
			modifiers.getModifiers().forEach((opt) -> {
				updateItem.getModifiers().add(opt);
			});
			return itemRepo.save(updateItem);
		} else {
			return null;
		}
	}

	@Override
	public Item removeItemModifiers(String uuid, ItemModifiersDTO modifiers) {
		final Optional<Item> item = itemRepo.findById(uuid);
		if (item.isPresent()) {
			final Item updateItem = item.get();
			if (updateItem.getModifiers() == null) {
				updateItem.setModifiers(new ArrayList<>());
			}
			modifiers.getModifiers().forEach((opt) -> {
				updateItem.getModifiers().remove(opt);
			});
			return itemRepo.save(updateItem);
		} else {
			return null;
		}
	}

	@Override
	public Item removeItem(final String uuid) {
		final Optional<Item> deletedItem = itemRepo.findById(uuid);
		deletedItem.ifPresent((item) -> {
			itemRepo.delete(item);
			menuRepo.findById(item.getMenuId()).ifPresent((menu) -> {
				menu.getMenuItemIds().remove(item.getId());
				menuRepo.save(menu);
			});
		});
		return deletedItem.isPresent() ? deletedItem.get() : null;
	}

	@Override
	public Item getItem(final String uuid) {
		return itemRepo.findById(uuid).get();
	}

	@Override
	public List<Item> getAllItemsForMenu(final String uuidMenu) {
		return itemRepo.findAll().stream().filter((item) -> item.getMenuId().equals(uuidMenu))
				.collect(Collectors.toList());
	}

}
