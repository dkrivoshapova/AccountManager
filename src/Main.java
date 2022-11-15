import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        FileService file = new FileService();
        String filename = "src/user.csv";
        ArrayList<Account> group = file.readCSV(filename);
        System.out.println(group);
        file.writeCSV(filename, group);
    }
}