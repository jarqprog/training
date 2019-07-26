package com.jqprog.training.algorithms.sorting;

public class InsertionSort implements Sort {

    private long performedOperations;
    private long lastExecutionTime;

    @Override
    public long getPerformedOperations() {
        return performedOperations;
    }

    @Override
    public long getLastExecutionTimeInNanos() {
        return lastExecutionTime;
    }

    @Override
    public int[] sort(int[] numbers) {
        lastExecutionTime = 0;
        performedOperations = 0;
        return new int[0];
    }


}
