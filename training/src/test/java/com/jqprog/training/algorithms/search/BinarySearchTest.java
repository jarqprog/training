package com.jqprog.training.algorithms.search;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    private Search binarySearch;

    @Before
    public void initialize() {
        binarySearch = new BinarySearch();
    }

    @Test
    public void search_inEmptyArray() {
        assertFalse(binarySearch.search(9, new int[0]));
    }

    @Test
    public void search_numberNotInArray() {

        int[] sorted = {1, 2, 3, 4, 7, 8, 9, 11, 15, 17};
        int numberToFind = 20;

        boolean result = binarySearch.search(numberToFind, sorted);

        assertFalse(result);
    }

    @Test
    public void search_numberInSmallArray_shouldReturnTrue() {

        int[] sorted = {1, 2, 3, 4};
        int numberToFind = 3;

        boolean result = binarySearch.search(numberToFind, sorted);

        assertTrue(result);
    }

    @Test
    public void search_numberInBigArray_shouldReturnTrue() {

        int[] sorted = {-90, -21, -10, -8, -7, -2, 0, 1, 2, 3, 4, 7, 8, 10, 12, 15, 19, 21, 30, 56, 99, 102};
        int numberToFind = 3;

        boolean result = binarySearch.search(numberToFind, sorted);

        assertTrue(result);
    }
}