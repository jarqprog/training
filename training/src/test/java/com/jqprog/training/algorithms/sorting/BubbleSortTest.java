package com.jqprog.training.algorithms.sorting;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleSortTest extends SortTest {


    @Before
    public void initializeSort() {
        Sort bubbleSort = new BubbleSort();
        setSortingAlgorithm(bubbleSort);
    }

}