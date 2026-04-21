package Skills.Defensives;

import java.util.List;

import Characters.Entities.Character;
import Skills.Skill;

public class MarshallingShoutSkill implements Skill {

    @Override
    public void use(Character user, List<Character> allies, List<Character> enemies) {

        System.out.println(user.name + " uses Marshalling Shout!");

        for (Character c : allies) {
            if (!c.isAlive()) continue;

            int heal = (int)(c.maxHealth * 0.4);
            c.heal(heal);

            System.out.println(c.name + " heals " + heal);
        }
    }

    @Override
    public String getName() {
        return "Marshalling Shout : Heal all allies";
    }
}