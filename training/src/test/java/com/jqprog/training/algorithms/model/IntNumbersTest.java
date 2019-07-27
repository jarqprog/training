package com.jqprog.training.algorithms.model;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

public class IntNumbersTest {

    @Test
    public void testConstructorWithIntArrayParameterAndGetNumbersMethod() {

        int[] array = {1, 2, 3};
        int[] expected = {1, 2, 3};

        Numbers numbers = new IntNumbers(array);
        int[] ints = numbers.getNumbers();

        assertArrayEquals(expected, ints);
    }

    @Test
    public void testConstructorWithIntegerCollectionParameterGetNumbersMethod() {

        Collection<Integer> collection = Arrays.asList(5, 6, 7);
        int[] expected = {5, 6, 7};

        Numbers numbers = new IntNumbers(collection);
        int[] ints = numbers.getNumbers();

        assertArrayEquals(expected, ints);
    }

    @Test
    public void getLength_ShouldReturnZero() {

        int[] array = {};
        Numbers numbers = new IntNumbers(array);

        int result = numbers.getLength();

        assertEquals(0, result);
    }

    @Test
    public void getLength_ShouldReturnFive() {

        int[] array = {5, 4, 3, 2, 1};
        Numbers numbers = new IntNumbers(array);

        int result = numbers.getLength();

        assertEquals(5, result);
    }

    @Test
    public void getLength_ShouldReturnFive_UseCollectionParameter() {

        Collection<Integer> collection = Arrays.asList(5, 6, 7, 8, 9);
        Numbers numbers = new IntNumbers(collection);

        int result = numbers.getLength();

        assertEquals(5, result);
    }

    @Test
    public void getNumbers_ShouldReturnEmptyArray() {

        int[] array = {};
        int[] expected = {};
        Numbers numbers = new IntNumbers(array);

        int[] result = numbers.getNumbers();

        assertArrayEquals(expected, result);
    }
}