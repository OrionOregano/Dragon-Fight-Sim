package Skills.Attacks;

import java.util.List;

import Manager.GamePrinter;
import Characters.Entities.Character;
import Skills.Skill;

// MOVE USED BY THE JOKER BOSS, A MEDIUM STRENGTH PHYSICAL ATTACK THAT HITS THE FULL PARTY, TWICE IF CHARGED

public class KnifeThrowSkill implements Skill {

    @Override
    public void use(Character user, List<Character> allies, List<Character> enemies) {

        GamePrinter.println(user.name + " hurls knives at the party");

        boolean isCharged = user.nextTripleDamage;
        user.nextTripleDamage = false;

        int hits = isCharged ? 2 : 1;

        // NUMBER OF TIMES THE ATTACK HITS
        for (int h = 0; h < hits; h++) {

            if (hits == 2 && h == 1) {
                GamePrinter.println(user.name + " brandishes another set of knives!");
            }

            // LOOP THROUGH THE PARTY
            for (Character e : enemies) {
                if (!e.isAlive()) continue;

                int dmg = user.attack - e.defense;
                dmg = Math.max(dmg, 1);

                if (user.nextCrit) {
                    GamePrinter.println("Knife throw CRIT!");
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
        return "Knife Throw : Medium physical damage, Hits all enemies (Twice if Charged)";
    }
}