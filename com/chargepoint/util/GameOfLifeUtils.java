package com.chargepoint.util;

import static com.chargepoint.constants.Constants.*;

public final class GameOfLifeUtils {

    private GameOfLifeUtils() {}

    public static int[][] generateGlider(int cells) {
        int[][] matrix = new int[cells][cells];
        int middleIndex = cells/2;

        for (int[] cell : GLIDER_ENTRIES) {
            matrix[middleIndex + cell[0]][middleIndex + cell[1]] = 1;
        }

        return matrix;
    }

    public static int calculateLiveNeighbours(int[][] matrix, int row, int col) {
        int liveNeighbours = 0;
        int size = matrix.length;

        for(int[] currentNeighbour : GLIDER_NEIGHBOURS) {
            int currentRow = (row + currentNeighbour[0] + size)%size;
            int currentCol = (col + currentNeighbour[1] + size)%size;

            if(matrix[currentRow][currentCol]==1) {
                liveNeighbours++;
            }
        }

        return liveNeighbours;
    }

    public static void printGeneration(int[][] matrix, int generation) {
        System.out.println("-".repeat(matrix.length*3));
        System.out.println("Generation " + ((generation == 0) ? "Seed" : generation));
        for (int[] currentRow : matrix) {
            for (int currentCell : currentRow) {
                System.out.print(SYMBOLS_DEAD_ALIVE[currentCell]);
            }
            System.out.println();
        }
    }

    public static int[][] findNextGenerations(int[][] matrix, int[][] newGeneration) {

        for(int rowCount=0; rowCount<matrix.length; rowCount++) {
            for(int colCount=0; colCount<matrix.length; colCount++) {
                int liveNeighbours = GameOfLifeUtils.calculateLiveNeighbours(matrix, rowCount, colCount);

                if(matrix[rowCount][colCount]==1) {
                    if(liveNeighbours == 2 || liveNeighbours == 3) {
                        newGeneration[rowCount][colCount] = 1;
                    }
                } else {
                    if(liveNeighbours==3) newGeneration[rowCount][colCount] = 1;
                }

            }
        }

        return newGeneration;
    }

}
