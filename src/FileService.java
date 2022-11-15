import java.io.*;
import java.util.ArrayList;

public class FileService {
    private static FileService instance;

    public static synchronized FileService getInstance() {
        if (instance == null) {
            instance = new FileService();
        }
        return instance;
    }

    public static ArrayList<Account> readCSV(String filename) throws IOException {
        ArrayList<Account> group = new ArrayList<Account>();
        BufferedReader reader = null;
        String line = "";
        try {
            reader = new BufferedReader(new FileReader(filename));
            boolean checkFirstLine = true;
            while ((line = reader.readLine()) != null) {
                if (checkFirstLine) {
                    checkFirstLine = false;
                    continue;
                }
                String[] row = line.split(",");
                boolean b = Boolean.parseBoolean(row[5]) ;
                Account account = new Account(row[1], row[2], row[3], row[4], b);
                group.add(account);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        return group;
    }
    public static void writeCSV(String filename, ArrayList<Account> group) throws IOException {
        BufferedWriter writer = null;
        try  {
            writer = new BufferedWriter(new FileWriter(filename));
            writer.write("id,ФИО,дата рождения,email,пароль,blocked\n");
            int cnt = 1;
            for (Account person : group) {
                writer.write(cnt + "," + person.toString());
                cnt++;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

}

