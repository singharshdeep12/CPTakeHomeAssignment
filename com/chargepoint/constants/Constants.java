package com.chargepoint.constants;

public final class Constants {
    private Constants() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    public static final int[][] GLIDER_ENTRIES = {
            {-1, 0}, {0, 1}, {1, -1}, {1, 0}, {1, 1}
    };

    public static final int[][] GLIDER_NEIGHBOURS = {
            {-1, -1}, {-1, 0}, {-1, 1},
            { 0, -1}, { 0, 1},
            { 1, -1}, { 1, 0}, { 1, 1}
    };

    public static final int SLEEP_DELAY = 100;

    public static final String[] SYMBOLS_DEAD_ALIVE = {"⬛", "⬜"};

}
