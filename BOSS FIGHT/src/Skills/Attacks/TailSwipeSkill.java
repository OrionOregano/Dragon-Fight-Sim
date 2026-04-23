package Skills.Attacks;

import java.util.List;

import Manager.GamePrinter;
import Characters.Entities.Character;
import Skills.Skill;

// MOVE USED BY THE DRAGON BOSS, A MEDIUM STRENGTH PHYSICAL ATTACK THAT HITS THE FULL PARTY

public class TailSwipeSkill implements Skill {

    @Override
    public void use(Character user, List<Character> allies, List<Character> enemies) {

        GamePrinter.println(user.name + " swipes its tail!");

        boolean isCharged = user.nextTripleDamage;
        user.nextTripleDamage = false;
        
        // LOOPS THROUGH THE PARTY
        for (Character e : enemies) {
            if (!e.isAlive()) continue;

            int dmg = user.attack - e.defense + 4;
            dmg = Math.max(dmg, 1);

            if (isCharged) {
                dmg *= 3;
            }

            e.takeDamage(dmg);
            e.defenseRevealed = true;
        }
    }

    @Override
    public String getName() {
        return "Tail Swipe : Medium phsyical damage, Hits all enemies";
    }
}