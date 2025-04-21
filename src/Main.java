import com.ecommerce.Customer;
import com.ecommerce.Product;
import com.ecommerce.order.Order;
import  com.ecommerce.order.OrderSatus;

import java.util.Objects;

public class Main {
    /**
     *
     */
    private static Object OrderStatus;

    public static void main(String[] args) {
        // Create some products
        Product laptop = new Product(1, "Laptop", 999.99, "High-performance laptop");
        Product phone = new Product(2, "Smartphone", 699.99, "Latest smartphone model");
        Product headphones = new Product(3, "Headphones", 149.99, "Noise-cancelling headphones");
        Product mouse = new Product(4, "Wireless Mouse", 29.99, "Ergonomic wireless mouse");

        // Create a customer
        Customer customer = new Customer(101, "James Yunisa");
        System.out.println(customer);

        // Customer browses products and adds to cart
        System.out.println("=== Adding products to cart ===");
        customer.addToCart(laptop, 1);
        customer.addToCart(phone, 2);
        customer.addToCart(headphones, 1);

        // View cart
        System.out.println("\n=== Viewing cart ===");
        customer.viewCart();

        // Update cart
        System.out.println("\n=== Updating cart ===");
        customer.updateCartItem(phone, 1); // Reduce quantity from 2 to 1
        customer.addToCart(mouse, 2);
        customer.viewCart();

        // Place order
        System.out.println("\n=== Placing order ===");
        Order order = customer.placeOrder();

        if (order != null) {
            System.out.println(order.generateSummary());
            System.out.println(OrderSatus.DELIVERED);
        }

        // Update order status
        System.out.println("=== Updating order status ===");
        if (order != null) {
            order.updateStatus();
            System.out.println("New order status: " + order.getStatus());

        }
        System.out.println("New order status: " + Objects.requireNonNull(order).getStatus());

        // View order history
        System.out.println("\n=== Customer order history ===");
        customer.getOrderHistory().forEach(System.out::println);

        // Try to place another order with empty cart
        System.out.println("\n=== Trying to place empty order ===");
        Order emptyOrder = customer.placeOrder();


    }
}
