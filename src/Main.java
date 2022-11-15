import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileService file = new FileService();
        String filename = "src/user.csv";
        file.ReadCSV(filename);
    }
}