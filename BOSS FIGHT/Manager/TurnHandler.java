package Manager;

import java.util.List;

import Characters.Entities.Character;

// HANDLES THE PLAYER AND BOSS TURNS DURING GAMEPLAY

public class TurnHandler {

    // CALLED FROM THE LOOP USING A TURNHANDLER OBJECT, LOOPS THROUGH THE PARTY AND MAKES YOU PICK SKILLS TO USE
    public void playerTurn(GameState state) {

        for (Character p : state.team) {
            // CHECKS IF CHARACTER IS ALIVE
            if (!p.isAlive()) continue;

            // INDICATES TURN
            GamePrinter.println("\n" + p.name + "'s turn");

            // PRINTS OUT THEIR SKILL LIST
            p.showSkills();
            int choice = InputUtil.readSkillChoice(p);

            // USES THE SKILL ON THE BOSS/PARTY
            GamePrinter.println("");
            p.useSkill(choice, state.team, List.of(state.boss));
            // IF BOSS DIES, SKIP THE OTHER CHARACTER'S TURN
            if (!state.boss.isAlive()) break;
        }
    }
    // CALLED FROM THE LOOP USING A TURNHANDLER OBJECT, 
    // CREATES A BOSSAI OBJECT TO USE EXECUTE AND HAVE THE BOSS MAKE A MOVE
    public void bossTurn(GameState state) {
        new BossAI().execute(state.boss, state.team);
    }
}