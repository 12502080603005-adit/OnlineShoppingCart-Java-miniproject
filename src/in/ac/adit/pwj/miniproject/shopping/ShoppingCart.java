package in.ac.adit.pwj.miniproject.shopping;

import java.util.*;

public class ShoppingCart {

    private Map<Product, Integer> cartItems = new HashMap<>();

    public class CartManager {

        public void addItem(Product p, int qty) throws CartException {
            p.reduceStock(qty);
            cartItems.put(p, cartItems.getOrDefault(p, 0) + qty);
            System.out.println("Added: " + p.name);
        }

        public void viewCart() {
            double total = 0;

            for (Map.Entry<Product, Integer> e : cartItems.entrySet()) {
                Product p = e.getKey();
                int qty = e.getValue();
                total += p.price * qty;
                System.out.println(p.name + " x " + qty);
            }

            System.out.println("Total: ₹" + total);
        }

        // ✅ Bill
        public void generateBill(String user) {

            double total = 0;

            System.out.println("\n========= INVOICE =========");
            System.out.println("Customer: " + user);
            System.out.println("--------------------------------");

            for (Map.Entry<Product, Integer> e : cartItems.entrySet()) {
                Product p = e.getKey();
                int qty = e.getValue();
                double itemTotal = p.price * qty;

                total += itemTotal;

                System.out.println(p.name + " x " + qty + " = ₹" + itemTotal);
            }

            System.out.println("--------------------------------");
            System.out.println("Grand Total: ₹" + total);
            System.out.println("===============================");
        }

        public void checkout() {
            System.out.println("Checkout Done!");
            cartItems.clear();
        }
    }
}