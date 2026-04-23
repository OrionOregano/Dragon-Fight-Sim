package Skills.Attacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Manager.GamePrinter;
import Characters.Entities.Character;
import Skills.Skill;

// STRONG MAGICAL ATTACK, SINGLE TARGET

public class HolyPierceSkill implements Skill {

    @Override
    public void use(Character user, List<Character> allies, List<Character> enemies) {
        Random r = new Random();

        // ONLY NEEDED IF A NEW BOSS USES THE SKILL, CHECKS TO SEE WHICH CHARACTERS ARE ALIVE, ADDS THEM TO A LIST
        // FOR RANDOM PICKING LATER
        List<Character> alive = new ArrayList<>();
        for (Character e : enemies) {
            if (e.isAlive()) alive.add(e);
        }

        if (alive.isEmpty()) return;

        Character target = alive.get(new Random().nextInt(alive.size()));

        int dmg = Math.max(user.magicAttack + 5 - target.magicDefense, 1);

        if (user.nextTripleDamage) {
            dmg *= 3;
            user.nextTripleDamage = false;
            GamePrinter.println("CHARGED, Triple Damage!");
        }

        boolean crit = r.nextDouble() < 0.1;

        if (crit || user.nextCrit) {
            GamePrinter.println("Holy Pierce CRIT!");
            dmg *= 2;
            user.nextCrit = false;
        }

        GamePrinter.println(user.name + " uses Holy Pierce!");

        target.takeDamage(dmg);
        target.defenseRevealed = true;
    }

    @Override
    public String getName() {
        return "Holy Pierce : Pierces enemy with a blessed blade, Medium magical damage";
    }
}