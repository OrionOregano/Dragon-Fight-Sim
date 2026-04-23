package Skills.Attacks;

import java.util.List;
import java.util.Random;

import Manager.GamePrinter;
import Characters.Entities.Character;
import Skills.Skill;

// HIGH SINGLE TARGET MAGICAL ATTACK, HIGH CRIT RATE(50% CHANCE), CAN BE AFFECTED BY CHARGE, TARGETS RANDOMLY

public class FireballSkill implements Skill {

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

        int dmg = user.magicAttack + 6 - target.magicDefense;
        dmg = Math.max(dmg, 1);

        GamePrinter.println(user.name + " casts Fireball!");

        if (user.nextTripleDamage) {
            dmg *= 3;
            user.nextTripleDamage = false;
            GamePrinter.println("CHARGED, Triple Damage!");
        }

        boolean crit = r.nextDouble() < 0.5;

        if (crit || user.nextCrit) {
            GamePrinter.println("Fireball CRIT!");
            dmg *= 2;
            user.nextCrit = false;
        }

        target.takeDamage(dmg);
        target.magicDefenseRevealed = true;
    }

    @Override
    public String getName() {
        return "Fireball : High damage, high crit rate";
    }
}