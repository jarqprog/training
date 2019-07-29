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
        long startTime = System.nanoTime();
        lastExecutionTime = 0;
        performedOperations = 0;
        int length = numbers.length;
        if (length < 2) {
            return numbers;
        }

        for (int i=0; i<length-1; i++) {
            boolean hasChanged = false;
            for (int j=0; j<length-1; j++) {
                performedOperations++;
                if (numbers[j] > numbers[j+1]) {
                    swap(numbers, j, j+1);
                    hasChanged = true;
                }
            }
            if (!hasChanged) {
                break;
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