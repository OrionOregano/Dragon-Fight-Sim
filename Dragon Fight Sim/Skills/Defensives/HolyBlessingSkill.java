package Skills.Defensives;

import java.util.List;

import Characters.Entities.Character;
import Skills.Skill;

public class HolyBlessingSkill implements Skill {

    @Override
    public void use(Character user, List<Character> allies, List<Character> enemies) {

        System.out.println(user.name + " calls upon Holy Blessing!");

        for (Character c : allies) {
            if (c.isAlive()) {
                c.heal(c.maxHealth);
                System.out.println(c.name + " is fully healed!");
            }
        }
    }

    @Override
    public String getName() {
        return "Holy Blessing : Fully heals the entire party";
    }
}