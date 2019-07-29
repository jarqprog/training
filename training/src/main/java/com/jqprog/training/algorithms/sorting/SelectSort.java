package com.jqprog.training.algorithms.sorting;

public class SelectSort implements Sort {


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
        long startTime = System.nanoTime();

        lastExecutionTime = 0;
        performedOperations = 0;



        return numbers;
    }

}
