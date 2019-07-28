package com.jqprog.training;

import com.jqprog.training.algorithms.model.Numbers;
import com.jqprog.training.algorithms.numbersGenerator.NumbersGenerator;
import com.jqprog.training.algorithms.numbersGenerator.SimpleNumGenerator;
import com.jqprog.training.algorithms.sorting.*;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main( String[] args ) {

        List<Sort> sortingAlgorithms = Arrays.asList(
                new BubbleSort(),
                new InsertionSort(),
                new QuickSort(),
                new MergeSort());

        NumbersGenerator gen = new SimpleNumGenerator();

        int arrayLength = 30;
        int maximumValue = 50;
        boolean shouldIncludeNegativeNumbers = true;

        for (Sort sortingAlgorithm : sortingAlgorithms) {
            performSort(generateNumbers(gen, arrayLength, maximumValue, shouldIncludeNegativeNumbers),
                    sortingAlgorithm);
        }
    }

    private static void performSort(Numbers numbers, Sort sortAlgorithm) {
        System.out.println("Array before sort: " + numbers);
        System.out.println("Sorting using " + sortAlgorithm.getClass().getSimpleName());
        sortAlgorithm.sort(numbers.getNumbers());
        System.out.println("Done!");
        System.out.println("Time consumed: " + sortAlgorithm.getLastExecutionTimeInNanos());
        System.out.println("Operations performed: " + sortAlgorithm.getPerformedOperations());
        System.out.println("Array after sort: " + numbers);
    }

    private static Numbers generateNumbers(NumbersGenerator numbersGenerator, int arrayLen,
                                           int maximum, boolean includeNegative) {
        return numbersGenerator.generateNumbers(arrayLen, maximum, includeNegative);
    }
}
