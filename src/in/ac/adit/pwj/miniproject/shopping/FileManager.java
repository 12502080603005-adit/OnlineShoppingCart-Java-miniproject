package in.ac.adit.pwj.miniproject.shopping;

import java.io.*;

public class FileManager {

    public static void save(String data) {
        try (FileWriter fw = new FileWriter("bill.txt")) {
            fw.write(data);
        } catch (Exception e) {}
    }
}