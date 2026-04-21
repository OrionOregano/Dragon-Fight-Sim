package Characters.Creator;

import java.util.List;

import Characters.Entities.Character;
import Skills.Skill;

public class CustomCharacter extends Character {

    public CustomCharacter(String name, int health, int attack, int magicAttack,
                           int defense, int magicDefense,
                           List<Skill> skills) {

        super(name, health, attack, magicAttack, defense, magicDefense, skills);
    }
}