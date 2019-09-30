package com.hhs.boodschapp.model.repository;

import com.hhs.boodschapp.model.entity.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingListRepository extends JpaRepository<ShoppingList, Integer> {
}
