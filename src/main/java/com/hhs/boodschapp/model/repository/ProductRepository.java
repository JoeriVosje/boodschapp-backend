package com.hhs.boodschapp.model.repository;

import com.hhs.boodschapp.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
