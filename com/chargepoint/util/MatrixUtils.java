package com.chargepoint.util;

import java.util.Arrays;

public final class MatrixUtils {
    private MatrixUtils() {}
    public static int[][] deep2DArrayCopy(int[][] existing) {
        int[][] copy = new int[existing.length][];
        for (int i = 0; i < existing.length; i++) {
            copy[i] = Arrays.copyOf(existing[i], existing[i].length);
        }
        return copy;
    }

}
