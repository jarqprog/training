package com.jqprog.training;

import java.util.Arrays;

public class Utils {


    public static String getSubArrayAsString(int[] array, int start, int end) {

        Integer[] copy = new Integer[end - start + 1];

        int copyIndex = 0;
        for (int i=start; i<=end; i++) {
            copy[copyIndex++] = array[i];
        }

        return Arrays.toString(copy);
    }

}
