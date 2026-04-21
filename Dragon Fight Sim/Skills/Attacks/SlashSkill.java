package Skills.Attacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Characters.Entities.Character;
import Skills.Skill;

public class SlashSkill implements Skill {

    @Override
    public void use(Character user, List<Character> allies, List<Character> enemies) {

        List<Character> alive = new ArrayList<>();
        for (Character e : enemies) {
            if (e.isAlive()) alive.add(e);
        }

        if (alive.isEmpty()) return;

        Character target = alive.get(new Random().nextInt(alive.size()));

        int dmg = Math.max(user.attack - target.defense, 1);

        if (user.nextTripleDamage) {
            dmg *= 3;
            user.nextTripleDamage = false;
            System.out.println("CHARGED, TRIPLE DAMAGE!");
        }

        System.out.println(user.name + " uses Slash!");
        System.out.println("→ " + dmg + " damage");

        target.takeDamage(dmg);
        target.defenseRevealed = true;
    }

    @Override
    public String getName() {
        return "Slash : Medium physical damage";
    }
}