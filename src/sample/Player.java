package sample;

public class Player extends Account {

    Player() {
        super(AccountType.PLAYER);
        construct();
    }

    @Override
    protected void construct() {
        System.out.println("Building player");
        // add accessories
    }
}
