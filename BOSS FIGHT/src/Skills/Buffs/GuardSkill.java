package Skills.Buffs;

import java.util.List;

import Characters.Character;
import Manager.GamePrinter;
import Skills.Skill;

// GIVES THE ENTIRE PARTY GUARDING STATUS, REDUCES DAMAGE TAKEN

public class GuardSkill implements Skill {

    @Override
    public void use(Character user, List<Character> allies, List<Character> enemies) {

        GamePrinter.println(user.name + " guards!");

        // LOOPS THROUGH THE PARTY
        for (Character c : allies) {
            if (c.isAlive()) {
                c.isGuarding = true;
            }
        }
    }

    @Override
    public String getName() {
        return "Guard : Reduces damage for the whole party";
    }
}