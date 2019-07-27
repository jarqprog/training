package com.jqprog.training.algorithms.sorting;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertArrayEquals;

public abstract class SortTest {

    private Sort sortingAlgorithm;

    public void setSortingAlgorithm(Sort sort) {
        this.sortingAlgorithm = sort;
    }

    @Test
    public void getPerformedOperationsShouldReturnZeroForNewInstance() {

        assertEquals(0, sortingAlgorithm.getPerformedOperations());
    }

    @Test
    public void getPerformedOperations() {
        int[] ints = {3, 2, 1, 1, 1, 1, 1, 1, 2, 3, 4};

        sortingAlgorithm.sort(ints);

        assertTrue(sortingAlgorithm.getPerformedOperations() > 0);
    }

    @Test
    public void getLastExecutionTimeInNanosShouldReturnZeroForNewInstance() {

        assertEquals(0, sortingAlgorithm.getLastExecutionTimeInNanos());
    }

    @Test
    public void getLastExecutionTimeInNanos() {

        int[] ints = {3, 2, 1, 1, 1, 1, 1, 1, 2, 3, 4};

        sortingAlgorithm.sort(ints);

        assertTrue(sortingAlgorithm.getLastExecutionTimeInNanos() > 0);
    }

    @Test
    public void sortSimpleArray() {

        int[] ints = {3, 2, 1, 9, 7};
        int[] expected = {1, 2, 3, 7, 9};

        int[] result = sortingAlgorithm.sort(ints);

        assertArrayEquals(expected, result);
    }

    @Test
    public void sortSimpleArrayWithNegativeNumbers() {

        int[] ints = {3, -2, 1, -9, 7};
        int[] expected = {-9, -2, 1, 3, 7};

        int[] result = sortingAlgorithm.sort(ints);

        assertArrayEquals(expected, result);
    }

    @Test
    public void sortArrayWithRepeatingNumbers() {

        int[] ints = {97981772, 1245, -1876276, 12, 0, 0, 0, 1265, 1, 1, 1, 1, 99, 2, -88, 3};
        int[] expected = {-1876276, -88, 0, 0, 0, 1, 1, 1, 1, 2, 3, 12, 99, 1245, 1265, 97981772};

        int[] result = sortingAlgorithm.sort(ints);

        assertArrayEquals(expected, result);
    }


}
