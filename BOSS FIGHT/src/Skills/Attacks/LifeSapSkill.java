package Skills.Attacks;

import java.util.List;

import Manager.GamePrinter;
import Characters.Entities.Character;
import Skills.Skill;

// MOVE USED BY THE DRAGON BOSS, A MEDIUM STRENGTH MAGICAL ATTACK THAT HITS THE FULL PARTY, ALSO HEALS THE BOSS SLIGHTLY

public class LifeSapSkill implements Skill {

    @Override
    public void use(Character user, List<Character> allies, List<Character> enemies) {

        GamePrinter.println(user.name + " saps life from the party!");

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
            // CHECKS FOR INVULNERABILITY AND GUARDS WHICH AFFECT HEALING(DAMAGE IS CALCULATED INSIDE CHARACTER)
            if (!e.isUntouchable && !e.isGuarding) {
                user.heal((int)(dmg * 0.3));
            } else if (e.isGuarding) {
                user.heal((int)((dmg/2) * 0.3));
            }
            e.magicDefenseRevealed = true;
        }
    }

    @Override
    public String getName() {
        return "Life Sap : Deals medium magical damage to all enemies, Leeches aways health";
    }
}