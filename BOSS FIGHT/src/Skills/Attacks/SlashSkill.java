package Skills.Attacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Characters.Character;
import Manager.GamePrinter;
import Skills.Skill;

// MEDIUM STRENGHT PHYSICAL ATTACK

public class SlashSkill implements Skill {
    Random r = new Random();

    @Override
    public void use(Character user, List<Character> allies, List<Character> enemies) {

        // ONLY NEEDED IF A NEW BOSS USES THE SKILL, CHECKS TO SEE WHICH CHARACTERS ARE ALIVE, ADDS THEM TO A LIST
        // FOR RANDOM PICKING LATER
        List<Character> alive = new ArrayList<>();
        for (Character e : enemies) {
            if (e.isAlive()) alive.add(e);
        }

        if (alive.isEmpty()) return;

        Character target = alive.get(new Random().nextInt(alive.size()));

        int dmg = Math.max(user.attack + 5 - target.defense, 1);

        GamePrinter.println(user.name + " uses Slash!");

        if (user.nextTripleDamage) {
            dmg *= 3;
            user.nextTripleDamage = false;
            GamePrinter.println("CHARGED, Triple Damage!");
        }

        boolean crit = r.nextDouble() < 0.1;

        if (crit || user.nextCrit) {
            GamePrinter.println("Slash CRIT!");
            dmg *= 2;
            user.nextCrit = false;
        }

        target.takeDamage(dmg);
        target.defenseRevealed = true;
    }

    @Override
    public String getName() {
        return "Slash : Slashes enemy with your blade, Medium physical damage";
    }
}