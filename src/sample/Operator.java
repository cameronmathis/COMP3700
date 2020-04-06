package sample;

public class Operator extends Account {

    Operator() {
        super(AccountType.OPERATOR);
        construct();
    }

    @Override
    protected void construct() {
        System.out.println("Building operator");
        // add accessories
    }
}
