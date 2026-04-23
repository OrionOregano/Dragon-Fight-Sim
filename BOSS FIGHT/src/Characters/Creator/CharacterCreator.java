package Characters.Creator;

import java.util.*;

import Characters.Entities.Player;
import Characters.Entities.Character;
import Skills.*;
import Manager.GamePrinter;

import Skills.Attacks.*;
import Skills.Buffs.*;
import Skills.Healing.*;

// THIS CLASS IS FOR CREATING A CUSTOM CHARACTER, IT IS CALLED FROM THE GAMEMANAGER WHEN THE PLAYER CHOOSES THE OPTION IN THE MENU

public class CharacterCreator {

    public static Character create(Scanner sc, List<Character> team) {

        // GETS PLAYER INPUT FOR EACH STAT
        sc.nextLine();

        System.out.print("Enter character name: ");
        String name = sc.nextLine();

        System.out.print("Enter Max HP: ");
        int hp = Math.max(0, readInt(sc));

        System.out.print("Enter Attack: ");
        int attack = Math.max(0, readInt(sc));

        System.out.print("Enter Magic Attack: ");
        int magicAttack = Math.max(0, readInt(sc));

        System.out.print("Enter Defense: ");
        int defense = readInt(sc);

        System.out.print("Enter Magic Defense: ");
        int magicDefense = readInt(sc);

        GamePrinter.println("\nChoose 4 skills:");
        printSkillMenu();

        // ARRAY TO STORE SKILLS
        List<Skill> skills = new ArrayList<>();

        // LOOPS 4 TIMES FOR 4 SKILLS
        for (int i = 0; i < 4; i++) {
            System.out.print("Skill " + (i + 1) + ": ");
            int choice = readIntInRange(sc, 1, 10);
            skills.add(getSkill(choice));
        }

        // CREATES THE NEW CHARACTER USING THE PARAMETERS
        return new Player(
                name,
                hp,
                attack,
                magicAttack,
                defense,
                magicDefense,
                skills
        );
    }

    // ================= SKILL MENU =================
    private static void printSkillMenu() {
       GamePrinter.println("1. Slash");
        GamePrinter.println("2. Fireball");
        GamePrinter.println("3. Defend");
        GamePrinter.println("4. First Aid");
        GamePrinter.println("5. Precise Cut");
        GamePrinter.println("6. Holy Blessing");
        GamePrinter.println("7. Hide");
        GamePrinter.println("8. Charge");
        GamePrinter.println("9. Holy Pierce");
        GamePrinter.println("10. Magic Missile");
    }

    // ADDS SKILL TO SKILL ARRAY BASED ON CHOICE FROM PLAYER
    private static Skill getSkill(int choice) {
        switch (choice) {
            case 1: return new SlashSkill();
            case 2: return new FireballSkill();
            case 3: return new GuardSkill();
            case 4: return new FirstAidSkill();
            case 5: return new PreciseCutSkill();
            case 6: return new HolyBlessingSkill();
            case 7: return new HideSkill();
            case 8: return new ChargeSkill();
            case 9: return new HolyPierceSkill();
            case 10: return new MagicMissileSkill();
            default: return new SlashSkill();
        }
    }

    // FOR CHECKING INPUT VALIDITY
    private static int readInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input. Enter a number: ");
            sc.next();
        }
        return sc.nextInt();
    }

    // FOR CHECKING INPUT VALIDITY IN SPECIFIC RANGE
    private static int readIntInRange(Scanner sc, int min, int max) {
        int value;
        while (true) {
            value = readInt(sc);
            if (value >= min && value <= max) return value;
            System.out.print("Enter a number between " + min + " and " + max + ": ");
        }
    }
}
