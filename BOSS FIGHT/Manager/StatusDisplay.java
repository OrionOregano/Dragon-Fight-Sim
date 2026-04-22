package Manager;

import java.util.List;
import Characters.Entities.Character;

// FOR SHOWING THE STATUS OF YOUR PARTY

public class StatusDisplay {

    // PRINTS OUT YOUR PARTY'S DETAILS
    public void showTeamStatus(List<Character> team) {

        GamePrinter.println("\n================ PARTY STATUS ===============");

        for (Character c : team) {
            GamePrinter.println(
                c.name +
                " | HP: " + c.health + " / " + c.maxHealth +
                " | Alive: " + (c.isAlive() ? "Yes" : "No")
            );
        }

        GamePrinter.println("=============================================\n");
    }
}