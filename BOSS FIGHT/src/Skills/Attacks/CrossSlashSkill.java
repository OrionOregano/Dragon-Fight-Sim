package Skills.Attacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Characters.Character;
import Manager.GamePrinter;
import Skills.Skill;

// MEDIUM STRENGTH PHYSICAL ATTACK, HITS TWICE

public class CrossSlashSkill implements Skill {
    Random r = new Random();

    @Override
    public void use(Character user, List<Character> allies, List<Character> enemies) {

        // ONLY NEEDED IF A NEW BOSS USES THE SKILL, CHECKS TO SEE WHICH CHARACTERS ARE ALIVE, ADDS THEM TO A LIST
        // FOR RANDOM PICKING LATER
        List<Character> alive = new ArrayList<>();
        int hits = 2;
        for (Character e : enemies) {
            if (e.isAlive()) alive.add(e);
        }

        for (int h = 0; h < hits; h++) {
            if (alive.isEmpty()) return;

            Character target = alive.get(new Random().nextInt(alive.size()));

            int dmg = Math.max(user.attack + 2 - target.defense, 1);

            GamePrinter.println(user.name + " uses Cross Slash!");

            if (user.nextTripleDamage) {
                dmg *= 3;
                user.nextTripleDamage = false;
                GamePrinter.println("CHARGED, Triple Damage!");
            }

            boolean crit = r.nextDouble() < 0.15;

            if (crit || user.nextCrit) {
                GamePrinter.println("Cross Slash CRIT!");
                dmg *= 2;
            }

            target.takeDamage(dmg);
            target.defenseRevealed = true;
        }
        user.nextCrit = false;
    }

    @Override
    public String getName() {
        return "Cross Slash : Draws your blade in a cross-like line, hits twice, deals medium physical damage";
    }
}
