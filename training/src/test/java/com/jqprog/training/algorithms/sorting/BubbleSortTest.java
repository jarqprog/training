package com.jqprog.training.algorithms.sorting;

import org.junit.Before;

public class BubbleSortTest extends SortTest {


    @Before
    public void initializeSort() {
        Sort bubbleSort = new BubbleSort();
        setSortingAlgorithm(bubbleSort);
    }

}