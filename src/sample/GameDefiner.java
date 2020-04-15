package sample;

public class GameDefiner  {
    public final String gameName;
    public final int numPlayers;
    public int requiredPoints;

    public GameDefiner(String gameName, int numPlayers) {
        this.gameName = gameName;
        this.numPlayers = numPlayers;
    }
    public GameDefiner age(int age) {
        this.requiredPoints = age;
        return this;
    }
    //Return the finally constructed Game object
    public Game define() {
        Game game =  new Game(this);
        validateUserObject(game);
        return game;
    }
    private void validateUserObject(Game game) {
        //Do some basic validations to check
        //if user object does not break any assumption of system
    }
}
