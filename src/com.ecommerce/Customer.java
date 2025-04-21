package com.ecommerce;

import com.ecommerce.order.Order;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final int customerId;
    private String name;
    private final ShoppingCart shoppingCart;
    private final List<Order> orderHistory;

    public Customer(int customerId, String name) {
        this.customerId = customerId;
        this.name = name;
        this.shoppingCart = new ShoppingCart();
        this.orderHistory = new ArrayList<>();
    }

    // Shopping cart operations
    public void addToCart(Product product, int quantity) {
        shoppingCart.addItem(product, quantity);
    }

    public void removeFromCart(Product product) {
        shoppingCart.removeItem(product);
    }

    public void updateCartItem(Product product, int newQuantity) {
        shoppingCart.updateItemQuantity(product, newQuantity);
    }

    public void viewCart() {
        shoppingCart.displayCart();
    }

    public double getCartTotal() {
        return shoppingCart.calculateTotal();

    }

    // Order operations
    public Order placeOrder() {
        if (shoppingCart.isEmpty()) {
            System.out.println("Cannot place order: Shopping cart is empty");
            return null;
        }

        Order order = new Order(
                orderHistory.size() + 1,
                this,
                new ArrayList<>(shoppingCart.getItems().keySet()), // Get products from cart
                shoppingCart.calculateTotal()
        );
        orderHistory.add(order);
        shoppingCart.clear();
        return order;
    }

    // Getters
    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public List<Order> getOrderHistory() {
        return new ArrayList<>(orderHistory);
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Customer [ID: %d, Name: %s]", customerId, name);
    }
}
