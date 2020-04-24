package sample;

public class Match {
    public boolean matchStatus;
    public int matchID;
    public static int matchCounter = 0;
public Match() {
    matchID = matchCounter;
    matchStatus = true;
    matchCounter++;
}
    public boolean checkMatchStatus() {
        return matchStatus;
    }
}
