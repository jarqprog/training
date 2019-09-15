package com.jqprog.training.algorithms.varia.givingChange;

import org.apache.commons.collections4.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GivingChangeInInteger implements GivingChange<Integer> {

    private Set<Integer> monetaryDenominations;
    private List<Integer> moneyInShop;

    /**
     * Constructor with default values
     */
    public GivingChangeInInteger() {
        this.monetaryDenominations = Stream.of(1, 2, 5, 10, 20, 50)
                        .collect(Collectors.toCollection(HashSet::new));
        this.moneyInShop = Stream.of(1, 1, 1, 2, 2, 2, 2, 2, 2, 5, 5, 5, 5, 5, 5, 10, 20, 50, 50, 50, 20, 20, 10)
                        .collect(Collectors.toCollection(ArrayList::new));

    }

    public GivingChangeInInteger(Set<Integer> monetaryDenominations, List<Integer> moneyInShop) {
        validateMonetaryDenominations(monetaryDenominations);
        validateMoneyForShop(moneyInShop, monetaryDenominations);
        this.monetaryDenominations = monetaryDenominations;
        this.moneyInShop = moneyInShop;
    }

    @Override
    public void setMonetaryDenominations(Set<Integer> monetaryDenominations) {
        validateMonetaryDenominations(monetaryDenominations);
        this.monetaryDenominations = monetaryDenominations;
    }

    @Override
    public void setMoneyInShop(List<Integer> moneyInShop) {
        validateMoneyForShop(moneyInShop, monetaryDenominations);
        this.moneyInShop = moneyInShop;
    }

    @Override
    public List<Integer> giveChange(Integer price, List<Integer> paidMoney)
            throws NoMoney4GivingChange, NotEnoughMoneyPaid {

        int paidMoneySum =  paidMoney.stream().reduce(Integer::sum).orElseThrow();
        if (price > paidMoneySum) {
            throw new NotEnoughMoneyPaid();
        }
        if (price == paidMoneySum) {
            return Collections.emptyList();
        }
        int sumOfChangeToGive = paidMoneySum - price;
        return executeChangeGiving(sumOfChangeToGive, paidMoney);
    }

    @Override
    public List<Integer> getMoneyInShop() {
        return Collections.unmodifiableList(moneyInShop);
    }

    private List<Integer> executeChangeGiving(Integer sumOfChangeToGive, List<Integer> paidMoney)
            throws NoMoney4GivingChange {
        Integer[] allMoney = Stream.concat(paidMoney.stream(), moneyInShop.stream()).toArray(Integer[]::new);
        List<Integer> changeToGive = new LinkedList<>();
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
                if (alreadyCollected == sumOfChangeToGive) {
                    isDone = true;
                    break;
                }
                else if (allMoney[i] + alreadyCollected <= sumOfChangeToGive) {
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
        if (alreadyCollected == sumOfChangeToGive) {
            indexes.forEach(i -> changeToGive.add(allMoney[i]));
            indexes.forEach(i -> allMoney[i] = null);
            moneyInShop = Arrays.stream(allMoney)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        } else {
            throw new NoMoney4GivingChange();
        }
        return changeToGive;
    }

    private void validateMoneyForShop(List<Integer> moneyForShop, Set<Integer> monetaryDenominations) {
        if (CollectionUtils.isEmpty(moneyForShop)) {
            throw new IllegalArgumentException("Money in shop should contain values!");
        }
        if (CollectionUtils.isEmpty(monetaryDenominations) || !monetaryDenominations.containsAll(moneyForShop)) {
            throw new IllegalArgumentException("Money in shop contain invalid values (should match denominations)!");
        }
        if (moneyForShop.stream().anyMatch(m -> m<=0)) {
            throw new IllegalArgumentException("Money must have positive values!");
        }
    }

    private void validateMonetaryDenominations(Set<Integer> monetaryDenomination) {
        if (CollectionUtils.isEmpty(monetaryDenomination)) {
            throw new IllegalArgumentException("Monetary denominations should contain values!");
        }
        if (monetaryDenomination.stream().anyMatch(m -> m<=0)) {
            throw new IllegalArgumentException("Monetary denominations must have positive values!");
        }
    }
}
