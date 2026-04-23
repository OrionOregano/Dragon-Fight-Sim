package Skills.Attacks;

import java.util.List;
import java.util.Random;

import Manager.GamePrinter;
import Characters.Entities.Character;
import Skills.Skill;

// 1-3 WEAK HITS OF MAGICAL DAMAGE, CHARGING GUARANTEES 3 HITS

public class MagicMissileSkill implements Skill {

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


        int baseDmg = user.magicAttack - target.magicDefense - 4;
        baseDmg = Math.max(baseDmg, 1);

        GamePrinter.println(user.name + " casts Magic Missile!");

        int hits;

        if (user.nextTripleDamage) {
            hits = 3;
            user.nextTripleDamage = false;
            GamePrinter.println("CHARGED, Hits three times!");
        } else {
            hits = r.nextInt(3) + 1;
        }

        // DOES 1-3 HITS, EACH HIT MAY GAIN A SMALL BONUS TO DAMAGE FROM 1-3
        for (int i = 1; i <= hits; i++) {

            int dmg = baseDmg + (r.nextInt(3) + 1);

            boolean crit = r.nextDouble() < 0.1;

            if (crit || user.nextCrit) {
                GamePrinter.println("Magic Missile CRIT!");
                dmg *= 2;
                user.nextCrit = false;
            }

            target.takeDamage(dmg);

            if (!target.isAlive()) break;
        }

        target.magicDefenseRevealed = true;
    }

    @Override
    public String getName() {
        return "Magic Missile : 1-3 hits of magical damage, charged guarantees 3";
    }
}