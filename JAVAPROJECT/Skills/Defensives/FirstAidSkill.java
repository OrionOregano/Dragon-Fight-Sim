package Skills.Defensives;

import java.util.List;

import Characters.Entities.Character;
import Skills.Skill;

public class FirstAidSkill implements Skill {

    @Override
    public void use(Character user, List<Character> allies, List<Character> enemies) {

        System.out.println(user.name + " uses First Aid!");

        user.heal((int)(user.maxHealth * 0.5));
    }

    @Override
    public String getName() {
        return "First Aid : Heal 50% of your HP";
    }
}