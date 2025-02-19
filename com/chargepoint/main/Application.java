package com.chargepoint.main;

import com.chargepoint.factory.GameFactory;
import com.chargepoint.factory.GameRunnerFactory;
import com.chargepoint.game.Game;
import com.chargepoint.game.GameType;
import com.chargepoint.gamerunner.GameRunner;


public class Application {

    public static void main(String... args) {
        Game game = GameFactory.createGame(GameType.GAME_OF_LIFE);
        GameRunner gameRunner = GameRunnerFactory.createRunner(game);
        gameRunner.runGame();
    }

}
