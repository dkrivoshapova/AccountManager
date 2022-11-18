import java.io.IOException;

public interface AccountManager {
    void register(Account account) throws IOException;
    Account login(String email, String password) throws AccountBlockedException, WrongCredentialsException;
    void removeAccount(String email, String password);
}
