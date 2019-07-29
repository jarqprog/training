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

        int len = numbers.length;

        for (int i=0; i<len; i++ ) {
            for (int j=i; j<len; j++) {
                performedOperations++;
                if (numbers[j] < numbers[i]) {
                    swap(numbers, j, i);
                }
            }
        }

        lastExecutionTime = System.nanoTime() - startTime;
        return numbers;
    }

    private void swap(int[] numbers, int firstIndex, int secondIndex) {
        if (firstIndex == secondIndex) {
            return;
        }
        int temp = numbers[firstIndex];
        numbers[firstIndex] = numbers[secondIndex];
        numbers[secondIndex] = temp;
    }
}
