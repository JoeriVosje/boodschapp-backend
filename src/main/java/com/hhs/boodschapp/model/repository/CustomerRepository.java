package com.hhs.boodschapp.model.repository;

import com.hhs.boodschapp.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
