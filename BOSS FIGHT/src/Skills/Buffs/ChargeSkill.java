package Skills.Buffs;

import java.util.List;

import Characters.Character;
import Manager.GamePrinter;
import Skills.Skill;

// GIVES THE USER CHARGE WHICH MAKES THEIR NEXT ATTACK DEAL THRICE AS MUCH DAMAGE( AFTER DEFENSE IS TAKEN INTO ACCOUNT )

public class ChargeSkill implements Skill {

    @Override
    public void use(Character user, List<Character> allies, List<Character> enemies) {

        GamePrinter.println(user.name + " uses Charge!");

        if (user.nextTripleDamage) {
            GamePrinter.println("Already Charged"); return;
        }

        user.nextTripleDamage = true;

        GamePrinter.println("Next attack will deal TRIPLE damage!");
    }

    @Override
    public String getName() {
        return "Charge : Next attack deals triple damage";
    }
}