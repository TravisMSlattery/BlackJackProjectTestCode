public class Player {

    public static boolean validAmount(String s) { // This is to assure that the values entered for the initial balance and the player's bet are natural numbers.
        try {
            if (Integer.parseInt(s) > 0) // Ensure amount entered is > 0
                return true;
            else
                return false;
        } catch (NumberFormatException e) { // If not valid integer
            return false;
        }
    }

}
