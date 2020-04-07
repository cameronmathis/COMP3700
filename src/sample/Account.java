package sample;

public abstract class Account {
    public Account(AccountType type) {
        this.type = type;
        create();
    }

    private void create() {
        // Do one time processing here
    }

    // Do subclass level processing in this method
    protected abstract void construct();

    private AccountType type = null;
    private String email = null;
    private String username = null;
    private String password = null;

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Overriding equals() to compare two Account objects
    @Override
    public boolean equals(Object o) {

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Account)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        Account acct = (Account) o;

        // Compare the data members and return accordingly
        return type.equals(acct.type)
                && CharSequence.compare(this.getUsername(), acct.getUsername()) == 0;
    }
}
