package com.chargepoint.factory;

import com.chargepoint.game.Game;
import com.chargepoint.game.GameOfLife;
import com.chargepoint.game.GameType;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static com.chargepoint.game.GameType.GAME_OF_LIFE;


public class GameFactory {

    private static final Map<GameType, Supplier<Game>> gameRegistry = new HashMap<>();

    static {
        gameRegistry.put(GAME_OF_LIFE, GameFactory::createGameOfLife);
    }

    public static Game createGame(GameType gameType) {
        if(gameType==null) {
            throw new IllegalArgumentException("GameType cannot be null or empty");
        }

        Supplier<Game> gameSupplier = gameRegistry.get(gameType);

        if (gameSupplier == null) {
            throw new IllegalArgumentException("You don't have this game yet.");
        }

        return gameSupplier.get();
    }

    private static Game createGameOfLife() {
        int cells = com.chargepoint.util.InputUtils.getValidIntegerInput("Enter number of cells: ");
        int generations = com.chargepoint.util.InputUtils.getValidIntegerInput("Enter number of generations: ");
        return new GameOfLife(cells, generations);
    }

}