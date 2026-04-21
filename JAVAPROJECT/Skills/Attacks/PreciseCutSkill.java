package Skills.Attacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Characters.Entities.Character;
import Skills.Skill;

public class PreciseCutSkill implements Skill {

    @Override
    public void use(Character user, List<Character> allies, List<Character> enemies) {

        List<Character> alive = new ArrayList<>();
        for (Character e : enemies) {
            if (e.isAlive()) alive.add(e);
        }

        if (alive.isEmpty()) return;

        Character target = alive.get(new Random().nextInt(alive.size()));
        Random rand = new Random();

        int base = user.attack - target.defense - 2;
        base = Math.max(base, 1);

        boolean crit;

        if (user.nextCrit) {
            crit = true;
            user.nextCrit = false;
        } else {
            crit = rand.nextDouble() < 0.5;
        }

        int dmg = base;

        if (crit) {
            System.out.println("CRITICAL HIT!");
            dmg *= 2;
        }

        if (user.nextTripleDamage) {
            dmg *= 3;
            user.nextTripleDamage = false;
            System.out.println("CHARGED, TRIPLE DAMAGE!");
        }

        System.out.println(user.name + " uses Precise Cut!");
        System.out.println("→ " + dmg);

        target.takeDamage(dmg);
        target.defenseRevealed = true;
    }

    @Override
    public String getName() {
        return "Precise Cut : Low damage, high crit chance";
    }
}