package Characters.Entities;
import java.util.List;

import Skills.Skill;

public abstract class Character {

    public String name;
    public int health;
    public int maxHealth;

    public int attack;
    public int magicAttack;
    public int defense;
    public int magicDefense;

    public List<Skill> skills;

    // =====================================================
    // STATUS FLAGS
    // =====================================================
    public boolean isGuarding = false;
    public boolean isUntouchable = false;
    public boolean nextCrit = false;
    public boolean nextTripleDamage = false;

    public boolean defenseRevealed = false;
    public boolean magicDefenseRevealed = false;

    // =====================================================
    // CONSTRUCTOR
    // =====================================================
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

    // =====================================================
    // SKILLS
    // =====================================================
    public void showSkills() {
        for (int i = 0; i < skills.size(); i++) {
            System.out.println(i + ": " + skills.get(i).getName());
        }
    }

    public void useSkill(int index, List<Character> allies, List<Character> enemies) {
        skills.get(index).use(this, allies, enemies);
    }
    
    public void addSkill(Skill skill) {
        skills.add(skill);
    }

    // =====================================================
    // DAMAGE SYSTEM
    // =====================================================
    public void takeDamage(int dmg) {

        if (isUntouchable) {
            System.out.println(name + " is untouchable!");
            isUntouchable = false;
            isGuarding = false;
            return;
        }

        if (isGuarding) {
            dmg /= 2;
            System.out.println(name + " is guarding! Damage reduced!");
            isGuarding = false;
        }

        health = Math.max(0, health - dmg);

        System.out.println(name + " takes " + dmg + " damage!");
        System.out.println("HP: " + health + " / " + maxHealth);
        
        if (health == 0) {
            System.out.println(">>> " + name + " has fallen! <<<");
        }
    }

    // =====================================================
    // HEALING
    // =====================================================
    public void heal(int amount) {
        health = Math.min(maxHealth, health + amount);

        System.out.println(name + " heals " + amount + " HP!");
        System.out.println("HP: " + health + " / " + maxHealth);
    }

    // =====================================================
    // DISPLAY
    // =====================================================
    public void displayStats() {

        System.out.println("\n=== " + name + " ===");
        System.out.println("HP: " + health + " / " + maxHealth);

        System.out.println("Defense: " +
                (defenseRevealed ? getLevel(defense) : "???"));

        System.out.println("Magic Defense: " +
                (magicDefenseRevealed ? getLevel(magicDefense) : "???"));
    }

    private String getLevel(int stat) {
        if (stat < 7) return "Low";
        else if (stat < 15) return "Medium";
        else return "High";
    }

    // =====================================================
    // STATUS
    // =====================================================
    public boolean isAlive() {
        return health > 0;
    }
}