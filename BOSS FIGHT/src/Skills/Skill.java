package Skills;

import java.util.List;

import Characters.Character;

// CRUX OF THE STRATEGY PATTERN, USED AS A BASE FOR EVERY SKILL IN THE GAME

public interface Skill {

    // USE METHOD, A BASE FOR SKILLS TO BE BUILT ON
    void use(Character user, List<Character> allies, List<Character> enemies);

    // STRUCTURE FOR WHEN THE SKILL NEEDS TO BE SHOWN TO THE PLAYER VIA STRING
    String getName();
}