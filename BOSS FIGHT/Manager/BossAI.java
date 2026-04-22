package Manager;

import java.util.List;
import java.util.Random;

import Characters.Entities.Character;

// CALLED WHEN IT'S THE BOSS'S TURN, MAKES IT DECIDE WHAT MOVE TO USE, IF IT CHARGED, IT WILL USE AN AOE

public class BossAI {

    private Random r = new Random();

    // THE ACTUAL METHOD CALLED
    public void execute(Character boss, List<Character> team) {

        if (boss.nextTripleDamage) {
            useChargedAttack(boss, team);
            return;
        }

        int choice = rollSkill();

        GamePrinter.println("");
        boss.useSkill(choice, List.of(boss), team);
    }

    // METHOD FOR WHEN THE BOSS HAS CHARGED UP
    private void useChargedAttack(Character boss, List<Character> team) {
        GamePrinter.println("");
        int roll = r.nextInt(2);
        boss.useSkill(roll == 0 ? 3 : 4, List.of(boss), team);
    }

    // ON A NORMAL TURN, THE BOSS WILL RANDOMLY CHOOSE ON OF IT'S 5 SKILLS, 
    // THE CHARGE SKILL HAS DOUBLE ODDS COMPARED TO THE OTHERS
    private int rollSkill() {
        int roll = r.nextInt(6);

        switch (roll) {
            case 0: return 0;
            case 1: return 1;
            case 2:
            case 5: return 2;
            case 3: return 3;
            case 4: return 4;
            default: return 0;
        }
    }
}