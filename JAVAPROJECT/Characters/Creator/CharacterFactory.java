package Characters.Creator;
import java.util.*;

import Characters.Entities.Character;
import Characters.Entities.Enemy;
import Characters.Entities.Player;
import Skills.Attacks.*;
import Skills.Defensives.*;
import Skills.Buffs.*;

public class CharacterFactory {

    public static Character createKnight(List<Character> team) {
        return new Player("Knight", 60, 12, 4, 15, 8, 5,
                Arrays.asList(
                        new SlashSkill(),
                        new DefendSkill(),
                        new MarshallingShoutSkill()
                ));
    }

    public static Character createMage(List<Character> team) {
        return new Player("Mage", 40, 5, 18, 5, 12, 6,
                Arrays.asList(
                        new FireballSkill(),
                        new ChargeSkill(),
                        new HolyBlessingSkill()
                ));
    }

    public static Character createAssassin(List<Character> team) {
        return new Player("Assassin", 50, 15, 5, 8, 6, 12,
                Arrays.asList(
                        new SlashSkill(),
                        new HideSkill(),
                        new FirstAidSkill(),
                        new PreciseCutSkill()
                ));
    }

    public static Character createBoss() {
        return new Enemy("Dragon", 150, 15, 15, 8, 10, 7,
                Arrays.asList(
                        new FireballSkill(),
                        new SlashSkill(),
                        new ExplosionSkill(),
                        new TailSwipeSkill()
                ));
    }
}