package com.jqprog.training;

import com.jqprog.training.algorithms.model.Numbers;
import com.jqprog.training.algorithms.numbersGenerator.NumbersGenerator;
import com.jqprog.training.algorithms.numbersGenerator.SimpleNumGenerator;
import com.jqprog.training.algorithms.sorting.BubbleSort;
import com.jqprog.training.algorithms.sorting.InsertionSort;
import com.jqprog.training.algorithms.sorting.Sort;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        NumbersGenerator gen = new SimpleNumGenerator();
        Numbers numbers = gen.generateNumbers(30, 1000, true);
        Sort bubble = new BubbleSort();
        performSort(numbers, bubble);

        numbers = gen.generateNumbers(30, 1000, true);
        Sort insertion = new InsertionSort();
        performSort(numbers, insertion);



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

}
