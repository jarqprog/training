package com.jqprog.training.algorithms.sorting;

import org.junit.Before;


public class InsertionSortTest extends SortTest {

    @Before
    public void initializeSort() {
        Sort insertionSort = new InsertionSort();
        setSortingAlgorithm(insertionSort);
    }
}