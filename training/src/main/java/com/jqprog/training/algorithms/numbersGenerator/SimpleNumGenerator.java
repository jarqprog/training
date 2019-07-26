package com.jqprog.training.algorithms.numbersGenerator;

import com.jqprog.training.algorithms.model.IntNumbers;
import com.jqprog.training.algorithms.model.Numbers;

import java.util.Random;

public class SimpleNumGenerator implements NumbersGenerator {

    @Override
    public int[] generate(int arrayLength, int bound, boolean includeNegatives) {
        Random random = new Random();
        int[] numbers = new int[arrayLength];

        for (int i=0; i<arrayLength; i++) {
            int num = random.nextInt(bound);
            if (includeNegatives && random.nextBoolean()) {
                num *=-1;
            }
            numbers[i] = num;
        }
        return numbers;
    }

    @Override
    public Numbers generateNumbers(int arrayLength, int bound, boolean includeNegatives) {
        return new IntNumbers(generate(arrayLength, bound, includeNegatives));
    }
}