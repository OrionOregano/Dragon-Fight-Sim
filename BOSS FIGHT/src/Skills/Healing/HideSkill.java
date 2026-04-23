package Skills.Healing;

import java.util.List;

import Manager.GamePrinter;
import Characters.Entities.Character;
import Skills.Skill;

// GRANTS IMMUNITY FOR THAT TURN, GUARANTEES THE NEXT HIT TO BE A CRITICAL

public class HideSkill implements Skill {

    @Override
    public void use(Character user, List<Character> allies, List<Character> enemies) {

        GamePrinter.println(user.name + " uses Hide");

        user.isGuarding = true;
        user.isUntouchable = true;

        user.nextCrit = true;

        GamePrinter.println("Next attack is a Guaranteed Crit!");
        GamePrinter.println(user.name + " becomes untouchable!");
    }

    @Override
    public String getName() {
        return "Hide : Become untouchable, next attack crits";
    }
}