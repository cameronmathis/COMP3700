package sample;

public class Game {
    //All final attributes
    private final String gameName; // required
    private final int numPlayers; // required
    private final int requiredPoints; // optional

    Game(GameDefiner definer) {
        this.gameName = definer.gameName;
        this.numPlayers = definer.numPlayers;
        this.requiredPoints = definer.requiredPoints;
    }

    //All getter, and NO setter to provide immutability
    public String getGameName() {
        return gameName;
    }
    public int getNumPlayers() {
        return numPlayers;
    }
    public int getRequiredPoints() {
        return requiredPoints;
    }

    @Override
    public String toString() {
        return "User: "+this.gameName+", "+this.numPlayers+", "+this.requiredPoints;
    }
}
