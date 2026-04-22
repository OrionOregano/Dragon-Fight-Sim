package Skills.Attacks;

import java.util.List;
import java.util.Random;

import Manager.GamePrinter;
import Characters.Entities.Character;
import Skills.Skill;

// MOVE USED BY THE GOLEM BOSS, A HIGH STRENGTH PHYSICAL ATTACK THAT HITS ONE RANDOM TARGET

public class RockThrowSkill implements Skill {

    @Override
    public void use(Character user, List<Character> allies, List<Character> enemies) {

        Character target = null;
        Random r = new Random();
        for (Character e : enemies) {
            if (e.isAlive()) {
                target = e;
                break;
            }
        }
        if (target == null) return;

        int dmg = user.attack + 4 - target.defense;
        dmg = Math.max(dmg, 1);

        GamePrinter.println(user.name + " hurls a rock!");

        boolean crit = r.nextDouble() < 0.1;

        if (crit || user.nextCrit) {
            GamePrinter.println("Rock Throw CRIT!");
            dmg *= 2;
            user.nextCrit = false;
        }

        target.takeDamage(dmg);
        target.defenseRevealed = true;
    }

    @Override
    public String getName() {
        return "Fireball : High damage, high crit rate";
    }
}