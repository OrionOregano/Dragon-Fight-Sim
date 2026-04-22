package Characters.Entities;
import java.util.List;

import Manager.GamePrinter;
import Skills.Skill;

// THIS CLASS IS THE BASE ABSTRACT CLASS FOR ENEMY AND PLAYER TO BASE OFF, INCLUDES DAMAGE TAKING AND MANY STATUS FLAGS


public abstract class Character {

    // PARAMETERS AND ARRAYS USED BY CHARACTERS
    public String name;
    public int health;
    public int maxHealth;

    public int attack;
    public int magicAttack;
    public int defense;
    public int magicDefense;

    public List<Skill> skills;

    // STATUS FLAGS
    public boolean isGuarding = false;
    public boolean isUntouchable = false;
    public boolean nextCrit = false;
    public boolean nextTripleDamage = false;

    public boolean defenseRevealed = false;
    public boolean magicDefenseRevealed = false;

    // CONSTRUCTOR
    public Character(String name, int health, int attack, int magicAttack,
                     int defense, int magicDefense,
                     List<Skill> skills) {

        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.attack = attack;
        this.magicAttack = magicAttack;
        this.defense = defense;
        this.magicDefense = magicDefense;
        this.skills = skills;
    }

    // PRINTS OUT THE LIST OF SKILLS OF A CHARACTER, USED ON YOUR PARTY'S TURN
    public void showSkills() {
        for (int i = 0; i < skills.size(); i++) {
            GamePrinter.fastPrint(i + ": " + skills.get(i).getName());
        }
    }

    // MAIN METHOD THAT IS USED TO CALL THE use METHOD INSIDE EACH SKILL, WHICH IN TURN CALLS THAT SKILL
    // IT GETS THE INDEX FROM THE SKILL LIST AND THEN MAKES CALLS THE use METHOD OF THAT SKILL
    public void useSkill(int index, List<Character> allies, List<Character> enemies) {
        skills.get(index).use(this, allies, enemies);
    }

    // =====================================================
    // DAMAGE SYSTEM
    // =====================================================
    public void takeDamage(int dmg) {

        // IMMUNITY WHEN UNTOUCHABLE
        if (isUntouchable) {
            GamePrinter.fastPrint(name + " is untouchable!");
            return;
        }

        // DAMAGE REDUCTION WHEN GUARDING
        if (isGuarding) {
            dmg /= 2;
            GamePrinter.fastPrint(name + " is guarded! Damage reduced!");
        }

        // SUBTRACT FROM CHARACTER'S HEALTH
        health = Math.max(0, health - dmg);

        // PRINTS OUT DAMAGE AND WHO TOOK IT AS WELL AS HEALTH POST-DAMAGE
        GamePrinter.fastPrint(name + " takes " + dmg + " damage!");
        GamePrinter.fastPrint("HP: " + health + " / " + maxHealth);
        
        // IF SOMEONE DIES, PRINTS THIS OUT
        if (health == 0) {
            GamePrinter.fastPrint(">>> " + name + " has fallen! <<<");
        }
    }

    // =====================================================
    // HEALING
    // CALLED WHEN A HEALING SKILL IS USED WITH THE AMOUNT SCALING WITH EACH INDIVIDUAL SKILL THAT CALL THE METHOD
    // =====================================================
    public void heal(int amount) {
        health = Math.min(maxHealth, health + amount);

        GamePrinter.fastPrint(name + " heals " + amount + " HP!");
        GamePrinter.fastPrint("HP: " + health + " / " + maxHealth);
    }

    // =====================================================
    // DISPLAYS THE BOSS'S STATS
    // =====================================================
    public void displayStats() {

        GamePrinter.fastPrint("=== " + name + " ===");
        GamePrinter.fastPrint("HP: " + health + " / " + maxHealth);

        GamePrinter.fastPrint("Defense: " +
                (defenseRevealed ? defense+ " (" + getLevel(defense) + ")" : "???"));

        GamePrinter.fastPrint("Magic Defense: " +
                (magicDefenseRevealed ? magicDefense + " (" + getLevel(magicDefense) + ")" : "???"));
        GamePrinter.fastPrint("==============");
    }

    // ADDS A FURTHER DESCRIPTION ON HOW HIGH THE DEFENSES OF A BOSS ARE
    // TO GIVE THE PLAYER MORE INSIGHT
    private String getLevel(int stat) {
        if (stat < 7) return "Low";
        else if (stat < 11) return "Medium";
        else return "High";
    }

    // STATUS CHECK
    public boolean isAlive() {
        return health > 0;
    }
}