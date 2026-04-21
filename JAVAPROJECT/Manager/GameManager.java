package Manager;
import java.util.*;

import Characters.Creator.*;
import Characters.Entities.Character;

public class GameManager {

    private static GameManager instance;

    private boolean bossWillExplode = false;

    private GameManager() {}

    public static GameManager getInstance() {
        if (instance == null) instance = new GameManager();
        return instance;
    }

    public void startGame() {

        Scanner sc = new Scanner(System.in);

        List<Character> team = new ArrayList<>();

        // =====================================================
        // CHARACTER SELECTION MENU
        // =====================================================
        System.out.println("====================================");
        System.out.println("     WELCOME TO DRAGON FIGHT SIM    ");
        System.out.println("        PICK YOUR CHARACTERS        ");
        System.out.println("====================================");

        System.out.println("Available characters:");
        System.out.println("1. Knight   - Tank (High Defense, Team Heal)");
        System.out.println("2. Mage     - Magic DPS (Fireball, Self-Boost, Elemental Damage)");
        System.out.println("3. Assassin - Physical DPS (Burst, Self Sustain)");
        System.out.println("4. Custom   - Create your own");
        System.out.println("====================================");

        for (int i = 0; i < 2; i++) {
            System.out.print("Choose character " + (i + 1) + ": ");

            int c = readIntInRange(sc, 1, 4);

            if (c == 1) team.add(CharacterFactory.createKnight(team));
            if (c == 2) team.add(CharacterFactory.createMage(team));
            if (c == 3) team.add(CharacterFactory.createAssassin(team));
            if (c == 4) team.add(CharacterCreator.create(sc, team));
        }

        // =====================================================
        // BOSS SETUP
        // =====================================================
        Character boss = CharacterFactory.createBoss();

        // =====================================================
        // GAME LOOP
        // =====================================================
        while (boss.isAlive() && teamAlive(team)) {

            // Show party status
            showTeamStatus(team);

            // Show boss info
            boss.displayStats();

            // ================= PLAYER TURN =================
            for (Character p : team) {

                if (!p.isAlive()) continue;

                System.out.println("\n" + p.name + "'s turn");
                p.showSkills();

                int choice = readIntInRange(sc, 0, p.skills.size() - 1);
                
                p.useSkill(choice, team, List.of(boss));

                if (!boss.isAlive()) break;
            }

            // ================= BOSS TURN =================
            if (boss.isAlive()) {
                bossTurn(boss, team);
            }
            for (Character c : team) {
                c.isGuarding = false;
                c.isUntouchable = false;
            }
        }

        // =====================================================
        // RESULT
        // =====================================================
        System.out.println(boss.isAlive() ? "[[ You Died... ]]" : "|| Dragon Defeated! ||");
    }

    // =====================================================
    // BOSS LOGIC
    // =====================================================
    private void bossTurn(Character boss, List<Character> team) {

        System.out.println("\nBoss's Turn!");

        Random rand = new Random();

        // ================= SPECIAL TURN =================
        if (bossWillExplode) {

            int choice = rand.nextInt(2); // Explosion or Tail Swipe

            if (choice == 0) {
                System.out.println("THE DRAGON RELEASES AN EXPLOSION!");
                boss.useSkill(2, List.of(boss), team);
            } else {
                System.out.println("THE DRAGON SWEEPS ITS TAIL!");
                boss.useSkill(3, List.of(boss), team);
            }

            bossWillExplode = false;

        // ================= NORMAL TURN =================
        } else {

            int choice = rand.nextInt(2); // Slash or Fireball

            if (choice == 0) {
                System.out.println("The dragon slashes!");
                boss.useSkill(1, List.of(boss), team);
            } else {
                System.out.println("The dragon casts fireball!");
                boss.useSkill(0, List.of(boss), team);
            }

            System.out.println("The dragon is charging up a massive attack...");
            bossWillExplode = true;
        }
    }

    // =====================================================
    // HELPERS
    // =====================================================
    private int readInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input. Enter a number: ");
            sc.next();
        }
        return sc.nextInt();
    }

    private int readIntInRange(Scanner sc, int min, int max) {
        int value;
        while (true) {
            value = readInt(sc);
            if (value >= min && value <= max) return value;
            System.out.print("Enter a number between " + min + " and " + max + ": ");
        }
    }
    
    private void showTeamStatus(List<Character> team) {

        System.out.println("\n================ PARTY STATUS ================");

        for (Character c : team) {
            System.out.println(
                    c.name +
                    " | HP: " + c.health + " / " + c.maxHealth +
                    " | Alive: " + (c.isAlive() ? "Yes" : "No")
            );
        }

        System.out.println("=============================================\n");
    }

    private boolean teamAlive(List<Character> team) {

        for (Character c : team) {
            if (c.isAlive()) return true;
        }

        return false;
    }
}