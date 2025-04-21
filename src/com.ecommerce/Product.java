package com.ecommerce;

public class Product {
    private final int productId;
    private String name;
    private double price;
    private String description;

    public Product(int productId, String name, double price, String description) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    // Getters
    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    // Setters (only for mutable fields)
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("Product [ID: %d, Name: %s, Price: $%.2f, Description: %s]",
                productId, name, price, description);
    }
}
