package in.ac.adit.pwj.miniproject.shopping;

public abstract class Product {
    protected int id;
    protected String name;
    protected double price;
    protected int stock;

    public Product(int id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public abstract String getCategory();

    public void reduceStock(int quantity) throws CartException {
        if (quantity > stock) {
            throw new CartException("Out of stock!");
        }
        stock -= quantity;
    }

    public String toString() {
        return id + " - " + name + " | ₹" + price + " | Stock: " + stock;
    }
}