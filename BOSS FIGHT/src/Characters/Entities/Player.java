package Characters.Entities;
import java.util.List;

import Skills.Skill;

// SUBCLASS OF CHARACTER THAT HELPS DIFFERENTIATE PLAYERS AND ENEMIES

public class Player extends Character {

    public Player(String name, int health, int attack, int magicAttack,
                  int defense, int magicDefense,
                  List<Skill> skills) {
        super(name, health, attack, magicAttack, defense, magicDefense, skills);
    }
}