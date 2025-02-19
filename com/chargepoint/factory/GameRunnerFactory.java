package com.chargepoint.factory;

import com.chargepoint.game.Game;
import com.chargepoint.game.GameOfLife;
import com.chargepoint.gamerunner.GameOfLifeRunner;
import com.chargepoint.gamerunner.GameRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class GameRunnerFactory {
    private static final Map<Class<? extends Game>, Function<Game, GameRunner>> runnerRegistry = new HashMap<>();

    static {
        runnerRegistry.put(GameOfLife.class, GameOfLifeRunner::new);
    }

    public static GameRunner createRunner(Game game) {
        if (game == null) {
            throw new IllegalArgumentException("Game cannot be null");
        }

        Function<Game, GameRunner> runnerSupplier = runnerRegistry.get(game.getClass());

        if (runnerSupplier == null) {
            throw new IllegalArgumentException("No runner available for game: " + game.getClass().getSimpleName());
        }

        return runnerSupplier.apply(game);
    }
}
