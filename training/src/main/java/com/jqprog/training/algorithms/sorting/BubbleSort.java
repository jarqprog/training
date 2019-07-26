package com.jqprog.training.algorithms.sorting;

public class BubbleSort implements Sort {

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
        int length = numbers.length;
        if (length < 2) {
            return numbers;
        }

        for (int i = 0; i < length - 1; i++) {
            boolean hasChanged = false;
            for (int j = 0; j < length - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                    hasChanged = true;
                }
                performedOperations++;
            }
            if (!hasChanged) {
                break;
            }
        }
        lastExecutionTime = System.nanoTime() - startTime;
        return numbers;
    }
}