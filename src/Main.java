import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        FileService file = new FileService();
        String filename = "src/user.csv";

        FileAccountManager accountManager = new FileAccountManager(filename);
        Account a = new Account("Дмитрий Ершов", "01.10.2000", "de2000@mail.ru", "12345", false);
        Account b = new Account("Иванов Иван", "24.11.2005", "ii2005@mail.ru", "54321", false);
        try {
            accountManager.register(a);
        } catch (AccountAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
        try {
            accountManager.register(b);
        } catch (AccountAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
        try {
            accountManager.register(a);
        } catch (AccountAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
        //wrong password A 1
        try {
            accountManager.login(a.getEmail(), "123");
        } catch (WrongCredentialsException | AccountBlockedException e) {
            System.out.println(e.getMessage());
        }
        //wrong password B 1
        try {
            accountManager.login(b.getEmail(), "543");
        } catch (WrongCredentialsException | AccountBlockedException e) {
            System.out.println(e.getMessage());
        }
        //wrong password A 2
        try {
            accountManager.login(a.getEmail(), "123");
        } catch (WrongCredentialsException | AccountBlockedException e) {
            System.out.println(e.getMessage());
        }
        //wrong password A 3
        try {
            accountManager.login(a.getEmail(), "123");
        } catch (WrongCredentialsException | AccountBlockedException e) {
            System.out.println(e.getMessage());
        }
        //wrong password A 4
        try {
            accountManager.login(a.getEmail(), "123");
        } catch (WrongCredentialsException | AccountBlockedException e) {
            System.out.println(e.getMessage());
        }

        //wrong password A 5
        try {
            accountManager.login(a.getEmail(), "123");
        } catch (WrongCredentialsException | AccountBlockedException e) {
            System.out.println(e.getMessage());
        }

        //right password A
        try {
            accountManager.login(a.getEmail(), a.getPassword());
        } catch (WrongCredentialsException | AccountBlockedException e) {
            System.out.println(e.getMessage());
        }

        //wrong password B 2
        try {
            accountManager.login(b.getEmail(), "543");
        } catch (WrongCredentialsException | AccountBlockedException e) {
            System.out.println(e.getMessage());
        }

        //right password B
        try {
            accountManager.login(b.getEmail(), b.getPassword());
        } catch (WrongCredentialsException | AccountBlockedException e) {
            System.out.println(e.getMessage());
        }
        //wrong password B 1
        try {
            accountManager.login(b.getEmail(), "543");
        } catch (WrongCredentialsException | AccountBlockedException e) {
            System.out.println(e.getMessage());
        }
        //wrong password B 2
        try {
            accountManager.login(b.getEmail(), "543");
        } catch (WrongCredentialsException | AccountBlockedException e) {
            System.out.println(e.getMessage());
        }

        //wrong password B 3
        try {
            accountManager.login(b.getEmail(), "543");
        } catch (WrongCredentialsException | AccountBlockedException e) {
            System.out.println(e.getMessage());
        }

        //wrong password B 4
        try {
            accountManager.login(b.getEmail(), "543");
        } catch (WrongCredentialsException | AccountBlockedException e) {
            System.out.println(e.getMessage());
        }

        //right password B
        try {
            accountManager.login(b.getEmail(), b.getPassword());
        } catch (WrongCredentialsException | AccountBlockedException e) {
            System.out.println(e.getMessage());
        }
        //delete A right password
        try {
            accountManager.removeAccount(a.getEmail(), a.getPassword());
        } catch (WrongCredentialsException e) {
            System.out.println(e.getMessage());
        }

        //delete B wrong password
        try {
            accountManager.removeAccount(b.getEmail(), "654");
        } catch (WrongCredentialsException e) {
            System.out.println(e.getMessage());
        }
        //delete B right password
        try {
            accountManager.removeAccount(b.getEmail(), b.getPassword());
        } catch (WrongCredentialsException e) {
            System.out.println(e.getMessage());
        }
    }
}