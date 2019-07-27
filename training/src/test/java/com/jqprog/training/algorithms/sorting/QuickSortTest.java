package com.jqprog.training.algorithms.sorting;

import org.junit.Before;


public class QuickSortTest extends SortTest {

    @Before
    public void initializeSort() {
        Sort quickSort = new QuickSort();
        setSortingAlgorithm(quickSort);
    }
}