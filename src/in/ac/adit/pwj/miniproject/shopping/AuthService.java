package in.ac.adit.pwj.miniproject.shopping;

import java.io.*;

public class AuthService {

    private static final String FILE = "users.txt";

    public static boolean signUp(String user, String pass) {

        try (FileWriter fw = new FileWriter(FILE, true)) {
            fw.write(user + "," + pass + "\n");
            System.out.println("Sign Up Successful!");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean login(String user, String pass) {

        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {

            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data[0].equals(user) && data[1].equals(pass)) {
                    return true;
                }
            }

        } catch (Exception e) {}

        return false;
    }
}