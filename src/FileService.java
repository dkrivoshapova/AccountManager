import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileReader;

public class FileService {
    private static FileService instance;

    public static synchronized FileService getInstance() {
        if (instance == null) {
            instance = new FileService();
        }
        return instance;
    }

    public static ArrayList<Account> ReadCSV(String filename) throws IOException {
        BufferedReader reader = null;
        String line = "";
        try {
            reader = new BufferedReader(new FileReader(filename));
            boolean checkFirstLine = true;
            while ((line = reader.readLine()) != null) {
                if (checkFirstLine) {
                    checkFirstLine = false;
                }
                String[] row = line.split(",");
                boolean b = (Integer.parseInt(row[4]) != 0);
                Account account = new Account(row[0],row[1], row[2], row[3], b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
        ArrayList<Account> group = new ArrayList<Account>();
        return  group;
    }
}

