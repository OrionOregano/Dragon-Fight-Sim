package Skills.Attacks;

import java.util.List;

import Manager.GamePrinter;
import Characters.Entities.Character;
import Skills.Skill;

// MOVE USED BY THE DRAGON BOSS, A MEDIUM STRENGTH MAGICAL ATTACK THAT HITS THE FULL PARTY

public class FireBreathSkill implements Skill {

    @Override
    public void use(Character user, List<Character> allies, List<Character> enemies) {

        GamePrinter.println(user.name + " spews an Inceinerating Breath!");

        boolean isCharged = user.nextTripleDamage;
        user.nextTripleDamage = false;

        // LOOPS THROUGH THE PARTY
        for (Character e : enemies) {
            if (!e.isAlive()) continue;

            int dmg = user.magicAttack - e.magicDefense + 4;
            dmg = Math.max(dmg, 1);

            if (isCharged) {
                dmg *= 3;
            }

            e.takeDamage(dmg);
            e.magicDefenseRevealed = true;
        }
    }

    @Override
    public String getName() {
        return "Fire Breath : Deals medium magical damage to all enemies";
    }
}