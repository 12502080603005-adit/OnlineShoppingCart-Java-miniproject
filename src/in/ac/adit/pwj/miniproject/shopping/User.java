package in.ac.adit.pwj.miniproject.shopping;

public class User implements Runnable {

    private String name;

    public User(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println(name + " is shopping...");
    }
}