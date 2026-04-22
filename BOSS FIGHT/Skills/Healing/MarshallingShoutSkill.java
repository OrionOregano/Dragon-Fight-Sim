package Skills.Healing;

import java.util.List;

import Manager.GamePrinter;
import Characters.Entities.Character;
import Skills.Skill;

// SMALL PARTY HEAL, USES THE HEAL METHOD LOOPING THROUGH THE PARTY

public class MarshallingShoutSkill implements Skill {

    @Override
    public void use(Character user, List<Character> allies, List<Character> enemies) {

        GamePrinter.println(user.name + " uses Marshalling Shout!");

        // LOOPS THROUGH THE PARTY
        for (Character c : allies) {
            if (!c.isAlive()) continue;

            int heal = (int)(c.maxHealth * 0.3);
            c.heal(heal);
        }
    }

    @Override
    public String getName() {
        return "Marshalling Shout : Heal the entire party";
    }
}