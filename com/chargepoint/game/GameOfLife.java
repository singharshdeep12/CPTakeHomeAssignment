package com.chargepoint.game;

import com.chargepoint.util.GameOfLifeUtils;
import com.chargepoint.util.MatrixUtils;

import static com.chargepoint.constants.Constants.SLEEP_DELAY;
import static com.chargepoint.util.GameOfLifeUtils.findNextGenerations;
import static com.chargepoint.util.GameOfLifeUtils.printGeneration;

public class GameOfLife implements Game {
    private final int cells;
    private final int generations;

    public GameOfLife(int cells, int generations) {
        this.cells = cells;
        this.generations = generations;
    }

    @Override
    public void start() {
        System.out.println("Game of Life has started.");
    }

    @Override
    public void run() {

        int[][] matrix = GameOfLifeUtils.generateGlider(cells);
        int currentGeneration = 0;

        printGeneration(matrix,currentGeneration++);
        try {
            Thread.sleep(SLEEP_DELAY*5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        int[][] nextGeneration = MatrixUtils.deep2DArrayCopy(matrix);

        while(currentGeneration<=generations){
            nextGeneration = findNextGenerations(nextGeneration,new int[cells][cells]);
            printGeneration(nextGeneration,currentGeneration++);
            try {
                Thread.sleep(SLEEP_DELAY);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public void stop() {
        System.out.println("Game of Life has stopped.");
    }


}
