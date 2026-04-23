package Manager.MainLoop;

// SINGLETON BASED MANAGER, ONLY ONE INSTANCE CAN EXIST
// STARTING POINT FOR THE ENTIRE GAME CALLED BY MAIN

public class GameManager {

    // HOLDS THE SINGULAR INSTANCE, STARTS OFF NULL
    private static GameManager instance;

    // PRIVATE STOPS CREATION OF NEW GAMEMANAGERS
    private GameManager() {}

    // ONLY GLOBAL ACCESS TO CREATING AN INSTANCE
    public static GameManager getInstance() {
        if (instance == null) instance = new GameManager();
        return instance;
    }

    // STARTS THE GAME
    public void startGame() {
        // MAKES A GAMESETUP OBJECT
        GameSetup setup = new GameSetup();
        // MAKES A GAMELOOP OBJECT
        GameLoop loop = new GameLoop();
        // INITIALIZES GAME STATE TO RECORD WHOSE TURN IT IS
        GameState state = setup.initializeGame();
        // STARTS THE LOOP
        loop.run(state);
    }
}