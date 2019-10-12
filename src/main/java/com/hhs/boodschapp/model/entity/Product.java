package com.hhs.boodschapp.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "product")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "product_name")
    private String productName;

    @NotNull
    @Column(name = "product_amount")
    private int productAmount;

    @NotNull
    @Column(name = "product_price")
    private double productPrice;
}
