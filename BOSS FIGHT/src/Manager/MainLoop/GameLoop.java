package Manager.MainLoop;

import java.util.List;

import Characters.Entities.Character;
import Manager.GamePrinter;
import Manager.StatusDisplay;
import Manager.TurnLogic.TurnHandler;

// THE LOOP WHERE THE BULK OF THE GAME RUNS

public class GameLoop {
    // STATUS DISPLAY OBJECT, FOR CALLING THE METHOD TO SHOW THE PARTY'S STATUS
    private StatusDisplay display = new StatusDisplay();

    // RUNS THE GAME, TAKES A GAMESTATE(TEAM LIST, BOSS) AS INPUT
    public void run(GameState state) {
        
        // MAIN LOOP, LOOPS TIL THE BOSS OR YOUR PARTY DIES
        while (state.boss.isAlive() && teamAlive(state.team)) {

            display.showTeamStatus(state.team);
            state.boss.displayStats();

            // CREATES A TURNHANDLER TO CARRY OUT THE PLAYER TURN
            new TurnHandler().playerTurn(state);
            if (!state.boss.isAlive()) break;

            // RESETS THE BOSS'S BUFF FLAG USED DURING IT'S PREVIOUS TURN
            resetBossStatus(state);
            // CREATES A TURNHANDLER TO CARRY OUT THE BOSS TURN
            new TurnHandler().bossTurn(state);
            resetPlayerStatus(state);
        }

        // GAME END MESSAGE
        GamePrinter.println("");
        GamePrinter.println(
            state.boss.isAlive() ? "[[ You Party was wiped out... ]]" : "||        YOU WIN!        ||"
        );
        GamePrinter.println("");
    }

    // METHOD TO CHECK IF TEAM IS ALIVE
    private boolean teamAlive(List<Character> team) {
        for (Character c : team) {
            if (c.isAlive()) return true;
        }
        return false;
    }
    // RESETS THE PLAYER'S DEFENSIVE EFFECTS, USED AT THE END OF THE BOSS'S TURN
    private void resetPlayerStatus(GameState state) {
        for (Character c : state.team) {
            c.isGuarding = false;
            c.isUntouchable = false;
        }
    }
    // RESETS THE BOSS'S DEFENSIVE EFFECTS, USED AT THE END OF THE PLAYER'S TURN
    private void resetBossStatus(GameState state) {
        state.boss.isGuarding = false;
        state.boss.isUntouchable = false;
    }
}