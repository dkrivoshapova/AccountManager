public class Account {
    private String name;
    private String date;
    private String email;
    private String password;
    private Boolean blocked = false;

    public Account(String name, String date, String email, String password, boolean blocked) {
        this.name = name;
        this.date = date;
        this.email = email;
        this.password = password;
        this.blocked = false;
    }
}
