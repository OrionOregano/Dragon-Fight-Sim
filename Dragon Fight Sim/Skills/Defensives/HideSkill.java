package Skills.Defensives;

import java.util.List;

import Characters.Entities.Character;
import Skills.Skill;

public class HideSkill implements Skill {

    @Override
    public void use(Character user, List<Character> allies, List<Character> enemies) {

        System.out.println(user.name + " uses Hide");

        user.isGuarding = true;
        user.isUntouchable = true;

        user.nextCrit = true;

        System.out.println("Next attack is Guaranteed Crit!");
        System.out.println(user.name + " becomes untouchable!");
    }

    @Override
    public String getName() {
        return "Hide : Become untouchable, next attack crits";
    }
}