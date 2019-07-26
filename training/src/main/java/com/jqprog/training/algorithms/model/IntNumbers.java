package com.jqprog.training.algorithms.model;

import java.util.Arrays;
import java.util.Collection;

public class IntNumbers implements Numbers {

    private final int[] numbers;
    private final String illegalArgExceptionMessage = "Numbers type is incorrect!";

    public IntNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    public IntNumbers(Number[] numbers) {
        this.numbers = transformToIntArray(numbers);
    }

    public IntNumbers(Collection<Number> numbers) {
        this.numbers = transformToIntArray(numbers);
    }

    @Override
    public int[] getNumbers() {
        return this.numbers;
    }

    @Override
    public int getLength() {
        return numbers.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.numbers);
    }

    private int[] transformToIntArray(Collection<Number> numbers) throws IllegalArgumentException {
        int len = numbers.size();
        int[] nums = new int[len];
        int index = 0;
        for (Number num : numbers) {
            try {
                nums[index] = (int) num;
                index++;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(illegalArgExceptionMessage);
            }
        }
        return nums;
    }

    private int[] transformToIntArray(Number[] numbers) throws IllegalArgumentException {
        int len = numbers.length;
        int[] nums = new int[len];
        for (int i=0; i<len; i++) {
            try {
                nums[i] = (int) numbers[i];
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(illegalArgExceptionMessage);
            }
        }
        return nums;
    }
}
