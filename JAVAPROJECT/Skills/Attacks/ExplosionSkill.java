package Skills.Attacks;

import java.util.List;
import java.util.Random;

import Characters.Entities.Character;
import Skills.Skill;

public class ExplosionSkill implements Skill {

    @Override
    public void use(Character user, List<Character> allies, List<Character> enemies) {

        System.out.println(user.name + " casts Explosion!");

        Random r = new Random();

        for (Character t : enemies) {
            if (!t.isAlive()) continue;

            int dmg = user.magicAttack - t.magicDefense + r.nextInt(5);
            dmg = Math.max(dmg, 1);

            System.out.println("→ " + t.name + " takes " + dmg);

            t.takeDamage(dmg);
            t.magicDefenseRevealed = true;
        }
    }

    @Override
    public String getName() {
        return "Explosion : Deals medium damage to all enemies";
    }
}