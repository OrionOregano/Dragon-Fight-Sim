package Manager.MainLoop;

import java.util.List;
import Characters.Entities.Character;

// A GAMESTATE OBJECT STORES THE LIST OF PARTY MEMBERS AND BOSS CHARACTER FOR EASY ACCESS BY OTHER CLASSES

public class GameState {

    public List<Character> team;
    public Character boss;

    // CONSTRUCTOR
    public GameState(List<Character> team, Character boss) {
        this.team = team;
        this.boss = boss;
    }
}