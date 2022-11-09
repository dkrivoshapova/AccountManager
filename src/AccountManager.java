public interface AccountManager {
    void register(Account account);
    Account login(String email, String password);
    void removeAccount(String email, String password);
}
