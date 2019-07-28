package com.jqprog.training.algorithms.search;

public class BinarySearch implements Search {

    private int[] numbers;
    private boolean isFound;

    @Override
    public boolean search(int number, int[] sortedNumbers) {
        if (sortedNumbers.length == 0) {
            return false;
        }

        numbers = sortedNumbers;
        isFound = false;

        int left = 0;
        int right = sortedNumbers.length - 1;

        return searchRecursive(number, left, right);
    }

    private boolean searchRecursive(int number, int left, int right) {

        if (left <= right && !isFound) {
            int middleIndex = getMiddleIndex(left, right);
            int middle = numbers[middleIndex];

            if (middle == number) {
                isFound = true;
            } else if (left == right) {
                isFound = numbers[left] == number;
            } else if (middle > number) {
                searchRecursive(number, left, middleIndex);
            } else {
                searchRecursive(number, middleIndex+1, right);
            }
        }
        return isFound;
    }

    private int getMiddleIndex(int left, int right) {
        return left + (right - left) / 2;
    }
}
