package Manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Characters.Entities.Character;
import Characters.Creator.CharacterFactory;
import Characters.Creator.CharacterCreator;

// A CLASS THAT SETS UP THE PARTY AND THE BOSS TO BE FOUGHT AND THEN THE MAIN METHOD 
// RETURNS IT AS A GAMESTATE OBJECT CONTAINING THE PARTY AND THE BOSS CHARACTER

public class GameSetup {

    private Scanner sc = new Scanner(System.in);

    // CALLED TO INITIALIZE THE GAME, RETURNS A GAMESTATE WITH THE TEAM AND BOSS THAT THE METHODS CALLED INSIDE RETURN
    public GameState initializeGame() {

        List<Character> team = selectTeam();
        Character boss = selectBoss();

        return new GameState(team, boss);
    }

    // METHOD CALLED FROM INITIALIZEGAME, ALLOWS YOU TO PICK YOUR PARTY FROM PRE-BUILT CHARACTERS
    // OR TO CREATE CUSTOM ONES
    private List<Character> selectTeam() {

        List<Character> team = new ArrayList<>();

        // PRINTS TITLE, PRESS TO PLAY
        GamePrinter.printTitle();
        GamePrinter.println("Press Enter to start game...");
        try {
            System.in.read();
        } catch (Exception e) {}

        GamePrinter.printDivider();
        GamePrinter.println("        SELECT YOUR CHARACTERS        ");
        GamePrinter.printDivider();

        GamePrinter.println("Available characters:");
        GamePrinter.println("1. Knight   - Tank (High Defense, Team Heal)");
        GamePrinter.println("2. Mage     - Magic DPS (Fireball, Self-Boost, Team Heal)");
        GamePrinter.println("3. Assassin - Physical DPS (Burst, Self Sustain)");
        GamePrinter.println("4. Custom   - Create your own");
        GamePrinter.printDivider();

        // LOOPS THRICE, MAKES YOU PICK 3 PARTY MEMBERS
        for (int i = 0; i < 3; i++) {

            System.out.print("Choose Member " + (i + 1) + ": ");
            int c = InputUtil.readIntInRange(sc, 1, 4);

            if (c == 1) team.add(CharacterFactory.createKnight(team));
            if (c == 2) team.add(CharacterFactory.createMage(team));
            if (c == 3) team.add(CharacterFactory.createAssassin(team));
            if (c == 4) team.add(CharacterCreator.create(sc, team));
        }

        return team;
    }

    // CALLED TO HAVE YOU PICK WHICH BOSS TO FIGHT
    private Character selectBoss() {
        // BOSS SELECTION
        GamePrinter.println("");
        GamePrinter.printDivider();
        GamePrinter.println("      CHOOSE YOUR BOSS TO FIGHT      ");
        GamePrinter.printDivider();

        GamePrinter.println("1. Dragon - Balanced, can charge up strong attacks");
        GamePrinter.println("2. Golem  - Tanky, can defend itself, able to sap away your health using druidic power");
        GamePrinter.printDivider();

        System.out.print("Choose boss: ");

        int bossChoice = InputUtil.readIntInRange(sc, 1, 2);

        if (bossChoice == 1) {
            return CharacterFactory.createDragon();
        } else {
            return CharacterFactory.createGolem();
        }
    }
}