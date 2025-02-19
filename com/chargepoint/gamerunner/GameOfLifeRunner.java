package com.chargepoint.gamerunner;

import com.chargepoint.game.Game;
import com.chargepoint.game.GameOfLife;

public class GameOfLifeRunner implements GameRunner {
    private final Game game;

    public GameOfLifeRunner(Game game) {
        if (!(game instanceof GameOfLife)) {
            throw new IllegalArgumentException("GameRunner only supports GameOfLife.");
        }
        this.game = game;
    }

    @Override
    public void runGame() {
        game.start();
        game.run();
        game.stop();
    }
}
