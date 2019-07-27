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
        long startTime = System.nanoTime();

        int len = numbers.length;

        for (int i=1; i<len; i++) {

            if (numbers[i] < numbers[i-1]) {

                boolean wasChanged = false;
                for (int j = i; j>0; j--) {
                    performedOperations++;
                    if (numbers[j] < numbers[j-1]) {
                        int temp = numbers[j-1];
                        numbers[j-1] = numbers[j];
                        numbers[j] = temp;
                        wasChanged = true;
                    }
                    if (!wasChanged) {
                        break;
                    }
                }
            }
        }
        lastExecutionTime = System.nanoTime() - startTime;
        return numbers;
    }
}
