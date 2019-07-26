package com.jqprog.training.algorithms.sorting;

public interface Sort {

    int[] sort(int[] numbers);
    long getPerformedOperations();
    long getLastExecutionTimeInNanos();
}
