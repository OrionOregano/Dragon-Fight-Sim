package Skills.Defensives;

import java.util.List;

import Characters.Entities.Character;
import Skills.Skill;

public class DefendSkill implements Skill {

    @Override
    public void use(Character user, List<Character> allies, List<Character> enemies) {

        System.out.println(user.name + " defends the team!");

        for (Character c : allies) {
            if (c.isAlive()) {
                c.isGuarding = true;
                System.out.println(c.name + " is guarding!");
            }
        }
    }

    @Override
    public String getName() {
        return "Defend : Reduces damage for the whole party";
    }
}