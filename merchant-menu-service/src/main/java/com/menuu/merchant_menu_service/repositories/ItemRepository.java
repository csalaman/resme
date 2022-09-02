package com.menuu.merchant_menu_service.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.menuu.merchant_menu_service.models.Item;

public interface ItemRepository extends MongoRepository<Item, String> {
}
