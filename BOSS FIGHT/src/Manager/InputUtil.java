package Manager;

import java.util.Scanner;

import Characters.Character;

// SCANNER USED FOR GLOBAL INPUTS

public class InputUtil {

    private static Scanner sc = new Scanner(System.in);

    // READS AN INTEGER
    public static int readInt() {
        while (!sc.hasNextInt()) {
            System.out.print("Enter a number: ");
            sc.next();
        }
        return sc.nextInt();
    }

    // READS AN INTEGER INSIDE A SPECIFIC RANGE, OUTSIDE OF RANGE WILL ASK AGAIN
    public static int readIntInRange(Scanner sc, int min, int max) {
        int value;
        while (true) {
            while (!sc.hasNextInt()) {
                System.out.print("Enter a number: ");
                sc.next();
            }
            value = sc.nextInt();

            if (value >= min && value <= max) return value;
            System.out.print("Enter between " + min + " and " + max + ": ");
        }
    }

    // CONVERTS THE CHOSEN SKILL INTO A NUMBER TO BE USED
    // LIMITS NUMBERS TO THE SIZE OF THE SKILL LIST OF THAT CHARACTER
    public static int readSkillChoice(Character p) {
        return readIntInRange(sc, 0, p.skills.size() - 1);
    }
}