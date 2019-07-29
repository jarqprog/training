package com.jqprog.training;

import com.jqprog.training.algorithms.model.Numbers;
import com.jqprog.training.algorithms.numbersGenerator.NumbersGenerator;
import com.jqprog.training.algorithms.numbersGenerator.SimpleNumGenerator;
import com.jqprog.training.algorithms.search.BinarySearch;
import com.jqprog.training.algorithms.search.Search;
import com.jqprog.training.algorithms.sorting.*;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main( String[] args ) {

        performSearchDemo();

        performSortingDemo();

    }

    
    private static void performSortingDemo() {
        List<Sort> sortingAlgorithms = Arrays.asList(
                new BubbleSort(),
                new InsertionSort(),
                new QuickSort(),
                new MergeSort(),
                new SelectSort());

        NumbersGenerator gen = new SimpleNumGenerator();

        int arrayLength = 30;
        int maximumValue = 50;
        boolean shouldIncludeNegativeNumbers = true;

        for (Sort sortingAlgorithm : sortingAlgorithms) {
            performSort(generateNumbers(gen, arrayLength, maximumValue, shouldIncludeNegativeNumbers),
                    sortingAlgorithm);
        }
    }

    private static void performSearchDemo() {

        Search search = new BinarySearch();

        int numberToSearch = 3;

        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(search.search(numberToSearch, numbers));

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
