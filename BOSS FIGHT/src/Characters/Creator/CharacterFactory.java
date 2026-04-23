package Characters.Creator;
import java.util.*;

import Characters.Entities.Character;
import Characters.Entities.Enemy;
import Characters.Entities.Player;
import Skills.Attacks.*;
import Skills.Buffs.*;
import Skills.Healing.*;

// THIS CLASS USES THE FACTORY PATTERN TO CREATE PLAYER OR ENEMIES CHARACTERS, THESE HAVE FIXED STATS AND CAN'T BE ADJUSTED BY THE PLAYER
// CALLED WHEN THE PLAYER CHOOSES THE PRE-BUILT CHARACTERS

public class CharacterFactory {
        // CREATES KNIGHT
        public static Character createKnight(List<Character> team) {
        return new Player("Knight", 70, 13, 13, 15, 7,
                Arrays.asList(
                        new SlashSkill(),
                        new HolyPierceSkill(),
                        new GuardSkill(),
                        new MarshallingShoutSkill()
                ));
        }

        // CREATES MAGE
        public static Character createMage(List<Character> team) {
        return new Player("Mage", 50, 10, 16, 7, 10,
                Arrays.asList(
                        new FireballSkill(),
                        new MagicMissileSkill(),
                        new ChargeSkill(),
                        new HolyBlessingSkill()
                ));
        }

        // CREATES ASSASSIN
        public static Character createAssassin(List<Character> team) {
        return new Player("Assassin", 60, 16, 10, 10, 7,
                Arrays.asList(
                        new SlashSkill(),
                        new PreciseCutSkill(),
                        new HideSkill(),
                        new FirstAidSkill()
                ));
        }

        // CREATES THE BOSS ENEMY TYPE CHARACTER, CALLED BY THE GAME IF THE PLAYER CHOOSES IT
        // DURING GAMESETUP
        // CREATES DRAGON
        public static Character createDragon() {
        return new Enemy("Dragon", 250, 15, 15, 9, 9,
                Arrays.asList(
                        new FireballSkill(),
                        new SlashSkill(),
                        new ChargeSkill(),
                        new FireBreathSkill(),
                        new TailSwipeSkill()
                ));
        }

        // CREATES GOLEM
        public static Character createGolem() {
        return new Enemy("Golem", 300, 18, 11, 12, 5,
                Arrays.asList(
                        new RockThrowSkill(),
                        new GuardSkill(),
                        new ChargeSkill(),
                        new SmashSkill(),
                        new LifeSapSkill()
                ));
        }

        public static Character createJoker() {
        return new Enemy("Joker", 230, 15, 11, 8, 8,
                Arrays.asList(
                        new SlashSkill(),
                        new HideSkill(),
                        new ChargeSkill(),
                        new KnifeThrowSkill(),
                        new ChaosSkill()
                ));
        }
}