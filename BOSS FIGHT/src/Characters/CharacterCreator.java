package Characters;

import java.util.*;

import Skills.*;
import Manager.GamePrinter;

import Skills.Attacks.*;
import Skills.Buffs.*;
import Skills.Healing.*;

// THIS CLASS IS FOR CREATING A CUSTOM CHARACTER, IT IS CALLED FROM THE GAMEMANAGER WHEN THE PLAYER CHOOSES THE OPTION IN THE MENU

public class CharacterCreator {

    public static Character create(Scanner sc, List<Character> team) {

        GamePrinter.println("");
        // GETS PLAYER INPUT FOR EACH STAT
        sc.nextLine();

        GamePrinter.print("Enter character name: ");
        String name = sc.nextLine();

        GamePrinter.print("Enter Max HP: ");
        int hp = Math.max(0, readInt(sc));

        GamePrinter.print("Enter Attack: ");
        int attack = Math.max(0, readInt(sc));

        GamePrinter.print("Enter Magic Attack: ");
        int magicAttack = Math.max(0, readInt(sc));

        GamePrinter.print("Enter Defense: ");
        int defense = readInt(sc);

        GamePrinter.print("Enter Magic Defense: ");
        int magicDefense = readInt(sc);

        GamePrinter.print("\nChoose 4 skills:\n");
        printSkillMenu(Skill_List);

        // ARRAY TO STORE SKILLS
        List<Skill> skills = new ArrayList<>();

        GamePrinter.println("");
        // LOOPS 4 TIMES FOR 4 SKILLS
        for (int i = 0; i < 4; i++) {
            GamePrinter.print("Skill " + (i + 1) + ": ");
            int choice = readIntInRange(sc, 1, 11);
            skills.add(getSkill(choice));
        }

        // CREATES THE NEW CHARACTER USING THE PARAMETERS
        return new Character(
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
    private static void printSkillMenu(List<Skill> skills) {
        for (int i = 0; i < skills.size(); i++) {
            GamePrinter.println((i + 1) + ". " + skills.get(i).getName());
        }
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
            case 11: return new CrossSlashSkill();
            default: return new SlashSkill();
        }
    }

    // FOR CHECKING INPUT VALIDITY
    private static int readInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            GamePrinter.print("Invalid input. Enter a number: ");
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
            GamePrinter.print("Enter a number between " + min + " and " + max + ": ");
        }
    }

    // LIST OF SKILLS AVAILABLE TO THE PLAYER
    public static final List<Skill> Skill_List = new ArrayList<>();

    static {
        Skill_List.add(new SlashSkill());
        Skill_List.add(new FireballSkill());
        Skill_List.add(new GuardSkill());
        Skill_List.add(new FirstAidSkill());
        Skill_List.add(new PreciseCutSkill());
        Skill_List.add(new HolyBlessingSkill());
        Skill_List.add(new HideSkill());
        Skill_List.add(new ChargeSkill());
        Skill_List.add(new HolyPierceSkill());
        Skill_List.add(new MagicMissileSkill());
        Skill_List.add(new CrossSlashSkill());
    }
}
