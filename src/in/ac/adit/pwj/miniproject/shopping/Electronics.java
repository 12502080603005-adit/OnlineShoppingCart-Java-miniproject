package in.ac.adit.pwj.miniproject.shopping;

public class Electronics extends Product {

    private String brand;
    private int warranty;

    public Electronics(int id, String name, double price, int stock,
                       String brand, int warranty) {
        super(id, name, price, stock);
        this.brand = brand;
        this.warranty = warranty;
    }

    public String getCategory() {
        return "Electronics";
    }

    public String toString() {
        return super.toString() +
                " | Brand: " + brand +
                " | Warranty: " + warranty + " months";
    }
}