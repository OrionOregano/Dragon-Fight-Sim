package Skills.Attacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Characters.Character;
import Manager.GamePrinter;
import Skills.Skill;

// MEDIUM POWER PHYSICAL MOVE, HIGH CRIT CHANCE(50%)

public class PreciseCutSkill implements Skill {
    Random r = new Random();

    @Override
    public void use(Character user, List<Character> allies, List<Character> enemies) {

        List<Character> alive = new ArrayList<>();
        for (Character e : enemies) {
            if (e.isAlive()) alive.add(e);
        }

        if (alive.isEmpty()) return;

        Character target = alive.get(new Random().nextInt(alive.size()));

        int base = user.attack + 4 - target.defense;
        base = Math.max(base, 1);
        int dmg = base;
        boolean crit = r.nextDouble() < 0.5;

        GamePrinter.println(user.name + " uses Precise Cut!");

        if (user.nextTripleDamage) {
            dmg *= 3;
            user.nextTripleDamage = false;
            GamePrinter.println("CHARGED, Triple Damage!");
        }

        if (crit || user.nextCrit) {
            GamePrinter.println("Precise Cut CRIT!");
            dmg *= 2;
            user.nextCrit = false;
        }

        target.takeDamage(dmg);
        target.defenseRevealed = true;
    }

    @Override
    public String getName() {
        return "Precise Cut : Low damage, high crit chance";
    }
}
