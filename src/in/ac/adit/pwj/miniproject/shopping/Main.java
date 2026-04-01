package in.ac.adit.pwj.miniproject.shopping;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== Welcome for Shopping =====");
        System.out.println("1. Sign Up");
        System.out.println("2. Login");
        System.out.print("Enter choice: ");

        int ch = sc.nextInt();
        sc.nextLine();

        String user = "";
        String pass = "";

        // 🔹 SIGN UP FLOW
        if (ch == 1) {

            System.out.print("Enter Username: ");
            user = sc.nextLine();

            System.out.print("Enter Password: ");
            pass = sc.nextLine();

            AuthService.signUp(user, pass);

            // 👉 Go directly to login
            System.out.println("\nPlease Login Now...");

            System.out.print("Enter Username: ");
            user = sc.nextLine();

            System.out.print("Enter Password: ");
            pass = sc.nextLine();

            if (!AuthService.login(user, pass)) {
                System.out.println("Invalid Login!");
                return;
            }

            System.out.println("Login Successful!");
        }

        // 🔹 LOGIN FLOW
        else if (ch == 2) {

            System.out.print("Enter Username: ");
            user = sc.nextLine();

            System.out.print("Enter Password: ");
            pass = sc.nextLine();

            if (!AuthService.login(user, pass)) {
                System.out.println("Invalid Login!");
                return;
            }

            System.out.println("Login Successful!");
        }

        else {
            System.out.println("Invalid choice!");
            return;
        }

        System.out.println("\nWelcome " + user);

        // 📦 INVENTORY SETUP
        Inventory inv = new Inventory();

        inv.addProduct(new Electronics(1,"Laptop",50000,10,"Dell",24));
        inv.addProduct(new Electronics(2,"Phone",20000,15,"Samsung",12));
        inv.addProduct(new Electronics(3,"Headphones",2000,25,"Sony",6));

        inv.addProduct(new Clothing(4,"T-Shirt",500,20,"M","Black","Cotton"));
        inv.addProduct(new Clothing(5,"Jeans",1500,10,"L","Blue","Denim"));
        inv.addProduct(new Clothing(6,"Jacket",3000,5,"XL","Brown","Leather"));

        // 🛒 CART
        ShoppingCart cart = new ShoppingCart();
        ShoppingCart.CartManager cm = cart.new CartManager();

        int choice;

        // 🔁 MENU LOOP
        do {
            System.out.println("\n========= MENU =========");
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    inv.displayByCategory();
                    break;

                case 2:
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();

                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();

                    Product p = inv.getProduct(id);

                    if (p == null) {
                        System.out.println("Invalid Product ID!");
                        break;
                    }

                    try {
                        cm.addItem(p, qty);
                    } catch (CartException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    cm.viewCart();
                    break;

                case 4:
                    cm.generateBill(user);
                    cm.checkout();
                    break;

                case 5:
                    System.out.println("Thank you for shopping!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        // 🧵 THREADING DEMO
        new Thread(new User("Alice")).start();
        new Thread(new User("Bob")).start();

        sc.close();
    }
}