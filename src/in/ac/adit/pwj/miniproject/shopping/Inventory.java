package in.ac.adit.pwj.miniproject.shopping;

import java.util.*;

public class Inventory {

    private Map<Integer, Product> productMap = new HashMap<>();

    public void addProduct(Product p) {
        productMap.put(p.id, p);
    }

    public Product getProduct(int id) {
        return productMap.get(id);
    }

    // ✅ Categorized display
    public void displayByCategory() {

        System.out.println("\n========= ELECTRONICS =========");
        for (Product p : productMap.values()) {
            if (p.getCategory().equals("Electronics")) {
                System.out.println(p);
            }
        }

        System.out.println("\n========= CLOTHING =========");
        for (Product p : productMap.values()) {
            if (p.getCategory().equals("Clothing")) {
                System.out.println(p);
            }
        }
    }
}