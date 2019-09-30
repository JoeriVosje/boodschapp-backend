package com.hhs.boodschapp.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_amount")
    private int productAmount;

    @Column(name = "product_price")
    private double productPrice;

    @Column(name = "shopping_list_position")
    private int shoppingListPosition;

    @Column(name = "checked")
    private boolean checked;

    public Product() {
    }

    public Product(String productName, int productAmount, double productPrice, int shoppingListPosition, boolean checked) {
        this.productName = productName;
        this.productAmount = productAmount;
        this.productPrice = productPrice;
        this.shoppingListPosition = shoppingListPosition;
        this.checked = checked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getShoppingListPosition() {
        return shoppingListPosition;
    }

    public void setShoppingListPosition(int shoppingListPosition) {
        this.shoppingListPosition = shoppingListPosition;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productAmount='" + productAmount + '\'' +
                ", productPrice=" + productPrice +
                ", shoppingListPosition=" + shoppingListPosition +
                ", checked=" + checked +
                '}';
    }
}
