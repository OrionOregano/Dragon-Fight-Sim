import java.util.Scanner;
import Manager.GameManager;

// MAIN METHOD, CALLS TO MAKE AN INSTANCE

public class Game {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // LOOP MADE SO THAT THE GAME CAN BE PLAYED AGAIN BY CREATING A NEW INSTANCE
        while (true) {

            GameManager.getInstance().startGame();

            // PROMPT ASKING IF THEY WANT TO PLAY AGAIN
            System.out.print("\nPlay again? (y/n): ");
            String input = sc.nextLine().trim().toLowerCase();

            // ENDS GAME IF n
            if (!input.equals("y")) {
                System.out.println("Thank You For Playing!");
                break;
            }
        }
        sc.close();
    }
}