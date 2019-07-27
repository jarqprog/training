package com.jqprog.training.algorithms.sorting;

public class QuickSort implements Sort {

    private long performedOperations;
    private long lastExecutionTime;
    private int[] array;


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
        array = numbers;

        int left = 0;
        int right = numbers.length - 1;

        sortRecursive(left, right);

        lastExecutionTime = System.nanoTime() - startTime;
        return numbers;
    }


    private void sortRecursive(int left, int right) {
        if (left < right) {
            int partitionIndex = partition(left, right);
            sortRecursive(left, partitionIndex-1);
            sortRecursive(partitionIndex+1, right);
        }
    }

    private int partition(int left, int right) {

        int pivot = array[right];
        int borderIndex = left;
        for (int i=left; i<right; i++) {
            performedOperations++;

            if (array[i] < pivot) {
                swap(i, borderIndex);
                borderIndex++;
            }
        }
        swap(right, borderIndex);
        return borderIndex;
    }

    private void swap(int firstIndex, int secondIndex) {
        if (firstIndex == secondIndex) {
            return;
        }
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
}
