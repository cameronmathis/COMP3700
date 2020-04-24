package sample;

public class matchController {

   public static boolean joinMatch(Account Player) {
      // Verify that the given Account can actually join matches/is of player type.
      return Accounts.canJoinMatch(Player.getUsername());
   }

}
