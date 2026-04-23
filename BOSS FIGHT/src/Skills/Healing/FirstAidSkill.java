package Skills.Healing;

import java.util.List;

import Manager.GamePrinter;
import Characters.Entities.Character;
import Skills.Skill;

// SELF HEALING SKILL THAT HEALS BY 50% OF MAX HEALTH

public class FirstAidSkill implements Skill {

    @Override
    public void use(Character user, List<Character> allies, List<Character> enemies) {

        GamePrinter.println(user.name + " uses First Aid!");

        user.heal((int)(user.maxHealth * 0.5));
    }

    @Override
    public String getName() {
        return "First Aid : Heal 50% of your HP";
    }
}