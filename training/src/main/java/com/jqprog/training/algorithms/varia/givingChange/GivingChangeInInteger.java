package com.jqprog.training.algorithms.varia;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GivingChangeInInteger implements GivingChange<Integer> {

    private Set<Integer> monetaryDenomination;
    private List<Integer> moneyInShop;

    /**
     * Constructor with default values
     */
    public GivingChangeInInteger() {
        this.monetaryDenomination = Stream.of(1, 2, 5, 10, 20, 50)
                        .collect(Collectors.toCollection(HashSet::new));
        this.moneyInShop = Stream.of(1, 1, 1, 2, 2, 2, 2, 2, 2, 5, 5, 5, 5, 5, 5, 10, 20, 50, 50, 50, 20, 20, 10)
                        .collect(Collectors.toCollection(ArrayList::new));

    }

    public GivingChangeInInteger(Set<Integer> monetaryDenomination, List<Integer> moneyInShop) {
        this.monetaryDenomination = monetaryDenomination;
        this.moneyInShop = moneyInShop;
    }

    @Override
    public void setMonetaryDenominations(Set<Integer> monetaryDenominations) {
        this.monetaryDenomination = monetaryDenomination;
    }

    @Override
    public void setMoneyInShop(List<Integer> moneyInShop) {
        this.moneyInShop = moneyInShop;
    }

    @Override
    public List<Integer> giveChange(Integer price, List<Integer> paidMoney) {
        return null;
    }

    private List<Integer> executeChangeGiving(Integer givingChangeSum, List<Integer> paidMoney) {
        List<Integer> changeToGive = new LinkedList<>();
        Integer[] allMoney = Stream.concat(paidMoney.stream(), moneyInShop.stream()).toArray(Integer[]::new);
        Arrays.sort(allMoney, Collections.reverseOrder());

        int len = allMoney.length;
        boolean isDone = false;
        int alreadyCollected = 0;
        Set<Integer> indexes = new HashSet<>();

        for (int border=0; border<len; border++) {
            if (isDone) {
                break;
            }
            for (int i=border; i<len; i++) {
                if (alreadyCollected == givingChangeSum) {
                    isDone = true;
                    break;
                }
                else if (allMoney[i] + alreadyCollected <= givingChangeSum) {
                    indexes.add(i);
                    alreadyCollected += allMoney[i];
                } else {
                    if (indexes.contains(i)) {
                        alreadyCollected -= allMoney[i];
                        indexes.remove(i);
                    }
                    while (i<len-1 && !(allMoney[i] < allMoney[i+1]) ) {
                        i++;
                    }
                }
            }
        }
        if (alreadyCollected == givingChangeSum) {
            indexes.forEach(i -> changeToGive.add(allMoney[i]));
        } else {
            throw new RuntimeException("Do not have money to do it...");
        }
        return changeToGive;
    }

}
