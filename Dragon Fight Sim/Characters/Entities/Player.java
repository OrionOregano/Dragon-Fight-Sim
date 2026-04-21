package Characters.Entities;
import java.util.List;

import Skills.Skill;

public class Player extends Character {

    public Player(String name, int health, int attack, int magicAttack,
                  int defense, int magicDefense, int speed,
                  List<Skill> skills) {

        super(name, health, attack, magicAttack, defense, magicDefense, skills);
    }
}