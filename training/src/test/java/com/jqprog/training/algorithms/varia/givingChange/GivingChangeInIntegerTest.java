package com.jqprog.training.algorithms.varia.givingChange;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;


public class GivingChangeInIntegerTest {

    private GivingChange<Integer> givingChange;

    @BeforeEach
    public void initializeShop() {
        Set<Integer> monetaryDenominations = new HashSet<>(Arrays.asList(1, 2, 5, 10, 20));
        List<Integer> moneyInShop = Arrays.asList(1, 1, 1, 2, 2, 5, 10, 20, 1, 1, 1);
        givingChange = new GivingChangeInInteger(monetaryDenominations, moneyInShop);
    }

    @Test
    public void initializeUsingInvalidValues_nullOrEmpty() {
        Set<Integer> monetaryDenominations = new HashSet<>(Arrays.asList(1, 2, 5, 10));
        List<Integer> moneyInShop = Arrays.asList(1, 1, 1, 2, 2, 5, 10);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new GivingChangeInInteger(monetaryDenominations, null));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new GivingChangeInInteger(monetaryDenominations, new ArrayList<>()));


        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new GivingChangeInInteger(null, moneyInShop));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new GivingChangeInInteger(new HashSet<>(), moneyInShop));
    }

    @Test
    public void initializeUsingInvalidArgument_moneyInShopContainsDifferentValuesThanMonetaryDenominations() {
        Set<Integer> monetaryDenominations = new HashSet<>(Arrays.asList(1, 2, 5, 10));
        List<Integer> moneyForShop = Arrays.asList(3, 1, 5);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new GivingChangeInInteger(monetaryDenominations, moneyForShop));
    }

    @Test
    public void initializeUsingInvalidArgument_negativeValues() {
        Set<Integer> monetaryDenominations = new HashSet<>(Arrays.asList(1, 2, -5, 10));
        List<Integer> moneyForShop = Arrays.asList(3, 1, -5);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new GivingChangeInInteger(monetaryDenominations, moneyForShop));
    }


    @Test
    public void givingChangeReturnCorrectValues() throws NoMoney4GivingChange, NotEnoughMoneyPaid {

        int price = 56;
        List<Integer> moneyPaid = Arrays.asList(20, 20, 20);
        List<Integer> expectedResult = Arrays.asList(2, 2);

        List<Integer> result = givingChange.giveChange(price, moneyPaid);

        Assertions.assertArrayEquals(expectedResult.toArray(), result.toArray());
    }

    @Test
    public void afterTransactionShopHasCorrectValues() throws NoMoney4GivingChange, NotEnoughMoneyPaid {

        int price = 110;
        List<Integer> initialMoneyInShop = Arrays.asList(1, 10);
        List<Integer> moneyPaid = Arrays.asList(20, 20, 20, 20, 20, 20);
        List<Integer> expectedResult = Arrays.asList(20, 20, 20, 20, 20, 20, 1);

        givingChange.setMoneyInShop(initialMoneyInShop);
        givingChange.giveChange(price, moneyPaid);

        List<Integer> result = givingChange.getMoneyInShop();

        Assertions.assertArrayEquals(expectedResult.toArray(), result.toArray());
    }






}