import java.io.IOException;
import java.util.ArrayList;

public class FileAccountManager implements AccountManager {
    final ArrayList<Account> group;
    final String filename;

    public FileAccountManager(String str) throws IOException {
        filename = str;
        group = FileService.readCSV(filename);
    }


    public void register(Account account) throws IOException {
        for (Account i : group) {
            if (i.getEmail().equals(account.getEmail())) {
                throw new AccountAlreadyExistsException("Пользователь уже зарегистрирован на  почту ", account.getEmail());
            }
        }
        System.out.println(account.getEmail() + " вы успешно зарегистрированы");
        group.add(account);
        FileService.writeCSV(filename, group);
    }

    public Account login(String email, String password) throws AccountBlockedException, WrongCredentialsException {
        for (Account i : group) {
            if (i.getEmail().equals(email) && i.getPassword().equals(password)) {
                if (i.isBlocked()) {
                    throw new AccountBlockedException("Ошибка, ваш аккаунт заблокирован ", i.getEmail());
                } else {
                    FailedLoginCounter.clean(i);
                    System.out.println(i.getEmail() + " вход выполнен успешно.");
                    return i;
                }
            } else if (i.getEmail().equals(email) || i.getPassword().equals(password)) {
                FailedLoginCounter.countFaildLogin(i);
                if (!i.isBlocked()) {
                    throw new WrongCredentialsException("Ошибка, неправильный логин или пароль ", email, password);
                } else {
                    throw new WrongCredentialsException("Ошибка, ваш аккаунт заблокирован после 5ти неправильных попыток ", email, password);
                }
            }
        }
        throw new WrongCredentialsException("Пользователя с таким логином или паролем не существует ", email, password);
    }

    public void removeAccount(String email, String password) throws WrongCredentialsException {
        boolean isExist = false;
        for (Account i : group) {
            if (i.getEmail().equals(email) && i.getPassword().equals(password)) {
                System.out.println(i.getEmail() + " Аккаунт удален.");
                group.remove(i);
                isExist = true;
                try {
                    FileService.writeCSV("src/user.csv", group);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
        if (!isExist) {
            throw new WrongCredentialsException("Ошибка, невозможно удлить пользователя, попробуйте снова ", email, password);
        }
    }
}
