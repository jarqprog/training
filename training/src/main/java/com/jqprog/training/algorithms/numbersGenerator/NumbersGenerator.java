package com.jqprog.training.algorithms.numbersGenerator;

import com.jqprog.training.algorithms.model.Numbers;

public interface NumbersGenerator {

    int[] generate(int arrayLength, int bound, boolean includeNegatives);
    Numbers generateNumbers(int arrayLength, int bound, boolean includeNegatives);

}
