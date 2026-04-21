package Skills;

import java.util.List;
import Characters.Entities.Character;

public interface Skill {

    void use(Character user, List<Character> allies, List<Character> enemies);

    String getName();
}