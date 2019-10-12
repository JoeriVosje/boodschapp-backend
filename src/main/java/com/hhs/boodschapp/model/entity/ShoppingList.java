package com.hhs.boodschapp.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.sql.Timestamp;

@Entity
@Table(name = "shopping_list")
@Getter
@Setter
@NoArgsConstructor
public class ShoppingList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "shopping_list_id")
    private List<Product> products;

    public ShoppingList(Timestamp createdAt, Timestamp updatedAt) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }
}
