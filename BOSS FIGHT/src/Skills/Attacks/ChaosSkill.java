package Skills.Attacks;

import java.util.List;

import Manager.GamePrinter;
import Characters.Entities.Character;
import Skills.Skill;

public class ChaosSkill implements Skill {

    @Override
    public void use(Character user, List<Character> allies, List<Character> enemies) {

        GamePrinter.println(user.name + " unleashes a chaotic storm of attacks!");

        boolean isCharged = user.nextTripleDamage;
        user.nextTripleDamage = false;

        int hits = isCharged ? 2 : 1;

        // NUMBER OF TIMES THE ATTACK HITS
        for (int h = 0; h < hits; h++) {

            if (hits == 2 && h == 1) {
                GamePrinter.println("Chaos! Chaos!");
            }

            // LOOP THROUGH THE PARTY
            for (Character e : enemies) {
                if (!e.isAlive()) continue;

                int dmg = user.magicAttack - e.magicDefense;
                dmg = Math.max(dmg, 1);

                if (user.nextCrit) {
                    GamePrinter.println("Chaos CRIT!");
                    dmg *= 2;
                }

                e.takeDamage(dmg);
                e.defenseRevealed = true;
            }
        }
        user.nextCrit = false;
    }

    @Override
    public String getName() {
        return "Chaos : Unleashes chaos upon the battlefield, Medium magical damage, Hits all enemies (Twice if Charged)";
    }
}