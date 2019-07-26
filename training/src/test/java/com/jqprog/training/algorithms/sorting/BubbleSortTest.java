package com.jqprog.training.algorithms.sorting;

import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleSortTest {

    @Test
    public void getPerformedOperationsShouldReturnZeroForNewInstance() {
        Sort bubble = new BubbleSort();

        assertEquals(0, bubble.getPerformedOperations());
    }

    @Test
    public void getPerformedOperations() {
        Sort bubble = new BubbleSort();
        int[] ints = {3, 2, 1, 1, 1, 1, 1, 1, 2, 3, 4};

        bubble.sort(ints);

        assertTrue(bubble.getPerformedOperations() > 0);
    }

    @Test
    public void getLastExecutionTimeInNanosShouldReturnZeroForNewInstance() {
        Sort bubble = new BubbleSort();

        assertEquals(0, bubble.getLastExecutionTimeInNanos());
    }

    @Test
    public void getLastExecutionTimeInNanos() {
        Sort bubble = new BubbleSort();
        int[] ints = {3, 2, 1, 1, 1, 1, 1, 1, 2, 3, 4};

        bubble.sort(ints);

        assertTrue(bubble.getLastExecutionTimeInNanos() > 0);
    }

    @Test
    public void sortSimpleArray() {
        Sort bubble = new BubbleSort();
        int[] ints = {3, 2, 1, 9, 7};
        int[] expected = {1, 2, 3, 7, 9};

        int[] result = bubble.sort(ints);

        assertArrayEquals(expected, result);
    }

    @Test
    public void sortSimpleArrayWithNegativeNumbers() {
        Sort bubble = new BubbleSort();
        int[] ints = {3, -2, 1, -9, 7};
        int[] expected = {-9, -2, 1, 3, 7};

        int[] result = bubble.sort(ints);

        assertArrayEquals(expected, result);
    }

    @Test
    public void sortArrayWithRepeatingNumbers() {
        Sort bubble = new BubbleSort();
        int[] ints = {97981772, 1245, -1876276, 12, 0, 0, 0, 1265, 1, 1, 1, 1, 99, 2, -88, 3};
        int[] expected = {-1876276, -88, 0, 0, 0, 1, 1, 1, 1, 2, 3, 12, 99, 1245, 1265, 97981772};

        int[] result = bubble.sort(ints);

        assertArrayEquals(expected, result);
    }


}