package com.jqprog.training.algorithms.sorting;


public class MergeSort implements Sort {

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
        return array;
    }


    private void sortRecursive(int left, int right) {

        if (left < right) {
            int mid = getMidIndex(left, right);
            sortRecursive(left, mid);
            sortRecursive(mid+1, right);
            merge(left, mid, right);
        }
    }

    private void merge(int left, int mid, int right) {

        int firstIndex = left;
        int secondIndex = mid+1;

        int[] temporary = new int[right - left + 1];
        int tempIndex = 0;

        while(firstIndex <= mid && secondIndex <= right) {
            performedOperations++;
            if (array[firstIndex] < array[secondIndex]) {
                temporary[tempIndex++] = array[firstIndex++];

            } else {
                temporary[tempIndex++] = array[secondIndex++];

            }
        }

        while(firstIndex <= mid) {
            performedOperations++;
            temporary[tempIndex++] = array[firstIndex++];
        }

        while(secondIndex <= right) {
            performedOperations++;
            temporary[tempIndex++] = array[secondIndex++];
        }

        tempIndex = 0;
        for (int i=left; i<=right; i++) {
            performedOperations++;
            array[i] = temporary[tempIndex++];
        }
    }

    private int getMidIndex(int left, int right) {
        return (left + right) / 2;
    }
}
