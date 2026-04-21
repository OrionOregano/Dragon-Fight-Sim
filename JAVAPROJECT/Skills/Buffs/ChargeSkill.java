package Skills.Buffs;

import java.util.List;

import Characters.Entities.Character;
import Skills.Skill;

public class ChargeSkill implements Skill {

    @Override
    public void use(Character user, List<Character> allies, List<Character> enemies) {

        System.out.println(user.name + " uses Charge!");

        user.nextTripleDamage = true;

        System.out.println("Next attack will deal TRIPLE damage!");
    }

    @Override
    public String getName() {
        return "Charge : Next attack deals triple damage";
    }
}