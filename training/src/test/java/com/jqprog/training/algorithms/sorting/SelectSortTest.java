package com.jqprog.training.algorithms.sorting;

import org.junit.Before;


public class SelectSortTest extends SortTest {


    @Before
    public void initializeSort() {
        Sort selectSort = new SelectSort();
        setSortingAlgorithm(selectSort);
    }

}