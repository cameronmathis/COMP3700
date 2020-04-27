package sample;

/**
 * matchController facilitates players joining matches and allows for the creation and storage of all running matches.
 */
public class matchController {
   private static Match[] matches = new Match[100];
   private static int matchAmount = 0;

   // Verify that the given Account can actually join matches/is of player type.
   public static boolean joinMatch(Account Player) {
      return Accounts.canJoinMatch(Player.getUsername());
   }

   // Creates a match object and stores it in array for easy finding later.
   public static Match createMatch() {
      Match tempMatch = new Match();
      matchAmount++;
      matches[matchAmount] = tempMatch;
      return tempMatch;
   }

   // Returns match amount.
   public int getMatchAmount() {
      return matchAmount;
   }
}
