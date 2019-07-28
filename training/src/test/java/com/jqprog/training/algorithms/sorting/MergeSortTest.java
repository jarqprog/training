package com.jqprog.training.algorithms.sorting;

import org.junit.Before;


public class MergeSortTest extends SortTest {

    @Before
    public void initializeSort() {
        Sort mergeSort = new MergeSort();
        setSortingAlgorithm(mergeSort);
    }

}