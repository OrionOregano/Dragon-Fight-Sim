package Skills.Attacks;

import java.util.List;
import java.util.Random;

import Characters.Entities.Character;
import Skills.Skill;

public class FireballSkill implements Skill {

    @Override
    public void use(Character user, List<Character> allies, List<Character> enemies) {

        Character target = null;

        for (Character e : enemies) {
            if (e.isAlive()) {
                target = e;
                break;
            }
        }

        if (target == null) return;

        Random r = new Random();

        int dmg = user.magicAttack - target.magicDefense;
        dmg = Math.max(dmg, 1);

        if (user.nextTripleDamage) {
            dmg *= 3;
            user.nextTripleDamage = false;
            System.out.println("CHARGED, TRIPLE DAMAGE!");
        }

        boolean crit = r.nextDouble() < 0.3;

        if (crit || user.nextCrit) {
            System.out.println("Fireball CRIT!");
            dmg *= 2;
            user.nextCrit = false;
        }

        System.out.println(user.name + " casts Fireball!");
        System.out.println("→ " + dmg + " damage");

        target.takeDamage(dmg);
        target.magicDefenseRevealed = true;
    }

    @Override
    public String getName() {
        return "Fireball : High damage, can crit";
    }
}