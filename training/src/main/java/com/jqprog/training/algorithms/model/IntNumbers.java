package com.jqprog.training.algorithms.model;

import java.util.Arrays;
import java.util.Collection;

public class IntNumbers implements Numbers {

    private final int[] numbers;

    public IntNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    public IntNumbers(Collection<Integer> numbers) {
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

    private int[] transformToIntArray(Collection<Integer> numbers) {
        int len = numbers.size();
        int[] nums = new int[len];
        int index = 0;
        for (Number num : numbers) {
                nums[index] = (int) num;
                index++;
        }
        return nums;
    }
}
