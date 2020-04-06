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

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }
}
