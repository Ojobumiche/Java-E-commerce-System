package com.ecommerce;

import java.util.HashMap;
import java.util.Map;

    public class ShoppingCart {
        private final Map<Product, Integer> items;

        public ShoppingCart() {
            this.items = new HashMap<>();
        }

        public void addItem(Product product, int quantity) {
            items.merge(product, quantity, Integer::sum);
        }

        public void removeItem(Product product) {
            items.remove(product);
        }

        public void updateItemQuantity(Product product, int newQuantity) {
            if (newQuantity <= 0) {
                items.remove(product);
            } else {
                items.put(product, newQuantity);
            }
        }

        public double calculateTotal() {
            return items.entrySet().stream()
                    .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                    .sum();
        }

        public boolean isEmpty() {
            return items.isEmpty();
        }

        public void clear() {
            items.clear();
        }

        public Map<Product, Integer> getItems() {
            return new HashMap<>(items);
        }

        public void displayCart() {
            if (items.isEmpty()) {
                System.out.println("Your shopping cart is empty.");
                return;
            }

            System.out.println("Shopping Cart Contents:");
            items.forEach((product, quantity) ->
                    System.out.printf("- %s x%d: $%.2f%n",
                            product.getName(),
                            quantity,
                            product.getPrice() * quantity)
            );
            System.out.printf("Total: $%.2f%n", calculateTotal());
        }
    }

