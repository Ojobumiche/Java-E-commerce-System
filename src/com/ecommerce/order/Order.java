package com.ecommerce.order;

import com.ecommerce.Customer;
import com.ecommerce.Product;
import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private final int orderId;
    private final Customer customer;
    private final List<Product> products;
    private final double totalAmount;
    private final LocalDateTime orderDate;
    private OrderSatus status;

    public Order(int orderId, Customer customer, List<Product> products, double totalAmount) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = List.copyOf(products);
        this.totalAmount = totalAmount;
        this.orderDate = LocalDateTime.now();
        this.status = OrderSatus.DELIVERED;
    }

    public void updateStatus() {
        this.status = OrderSatus.PENDING;
    }

    public String generateSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append("=== Order Summary ===\n");
        summary.append(String.format("Order ID: %d\n", orderId));
        summary.append(String.format("Customer: %s\n", customer.getName()));
        summary.append(String.format("Date: %s\n", orderDate));
        summary.append("Products:\n");

        products.forEach(product ->
                summary.append(String.format("- %s: $%.2f\n", product.getName(), product.getPrice()))
        );

        summary.append(String.format("Total Amount: $%.2f\n", totalAmount));
        summary.append(String.format("Status: %s\n", status));
        return summary.toString();
    }

    // Getters
    public int getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Product> getProducts() {
        return List.copyOf(products);
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public OrderSatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return String.format("Order [ID: %d, Customer: %s, Total: $%.2f, Status: %s]",
                orderId, customer.getName(), totalAmount, status);
    }
}
