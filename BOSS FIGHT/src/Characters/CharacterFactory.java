package Characters;
import java.util.*;

import Skills.Attacks.*;
import Skills.Buffs.*;
import Skills.Healing.*;

// THIS CLASS USES THE FACTORY PATTERN TO CREATE CHARACTERS, THESE HAVE FIXED STATS AND CAN'T BE ADJUSTED BY THE PLAYER
// CALLED WHEN THE PLAYER CHOOSES THE PRE-BUILT CHARACTERS AND WHEN CHOOSING BOSSES

public class CharacterFactory {
        // CREATES KNIGHT
        public static Character createKnight(List<Character> team) {
        return new Character("Knight", 70, 13, 13, 15, 7,
                Arrays.asList(
                        new SlashSkill(),
                        new HolyPierceSkill(),
                        new GuardSkill(),
                        new MarshallingShoutSkill()
                ));
        }

        // CREATES MAGE
        public static Character createMage(List<Character> team) {
        return new Character("Mage", 50, 10, 16, 7, 10,
                Arrays.asList(
                        new FireballSkill(),
                        new MagicMissileSkill(),
                        new ChargeSkill(),
                        new HolyBlessingSkill()
                ));
        }

        // CREATES ASSASSIN
        public static Character createAssassin(List<Character> team) {
        return new Character("Assassin", 60, 16, 10, 10, 7,
                Arrays.asList(
                        new PreciseCutSkill(),
                        new CrossSlashSkill(),
                        new HideSkill(),
                        new FirstAidSkill()
                ));
        }

        // CREATES THE BOSS CHARACTERS, CALLED BY THE GAME IF THE PLAYER CHOOSES IT
        // DURING GAMESETUP
        // CREATES DRAGON
        public static Character createDragon() {
        return new Character("Dragon", 250, 15, 15, 9, 9,
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
        return new Character("Golem", 300, 18, 11, 12, 5,
                Arrays.asList(
                        new RockThrowSkill(),
                        new GuardSkill(),
                        new ChargeSkill(),
                        new SmashSkill(),
                        new LifeSapSkill()
                ));
        }

        public static Character createJoker() {
        return new Character("Joker", 230, 15, 11, 8, 8,
                Arrays.asList(
                        new SlashSkill(),
                        new HideSkill(),
                        new ChargeSkill(),
                        new KnifeThrowSkill(),
                        new ChaosSkill()
                ));
        }
}