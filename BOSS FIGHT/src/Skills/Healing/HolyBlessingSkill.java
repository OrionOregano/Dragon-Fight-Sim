package Skills.Healing;

import java.util.List;

import Characters.Character;
import Manager.GamePrinter;
import Skills.Skill;

// PARTY WIDE 50% HEAL, ALSO REVIVES DOWNED MEMBERS

public class HolyBlessingSkill implements Skill {

    @Override
    public void use(Character user, List<Character> allies, List<Character> enemies) {

        GamePrinter.println(user.name + " calls upon a Holy Blessing!");

        // LOOPS THROUGH THE PARTY
        for (Character c : allies) {
            int heal = (int)(c.maxHealth * 0.5);
            c.heal(heal);
        }
    }

    @Override
    public String getName() {
        return "Holy Blessing : Greatly heals the entire party and revives members who are downed";
    }
}