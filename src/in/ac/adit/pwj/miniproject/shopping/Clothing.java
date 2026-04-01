package in.ac.adit.pwj.miniproject.shopping;

public class Clothing extends Product {

    private String size, color, fabric;

    public Clothing(int id, String name, double price, int stock,
                    String size, String color, String fabric) {
        super(id, name, price, stock);
        this.size = size;
        this.color = color;
        this.fabric = fabric;
    }

    public String getCategory() {
        return "Clothing";
    }

    public String toString() {
        return super.toString() +
                " | Size: " + size +
                " | Color: " + color +
                " | Fabric: " + fabric;
    }
}