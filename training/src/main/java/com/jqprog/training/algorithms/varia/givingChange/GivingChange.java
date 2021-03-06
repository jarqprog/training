package com.jqprog.training.algorithms.varia.givingChange;

import java.util.List;
import java.util.Set;

public interface GivingChange<T extends Comparable> {

    void setMonetaryDenominations(Set<T> monetaryDenominations);
    void setMoneyInShop(List<T> moneyInShop);
    List<T> giveChange(T price, List<T> paidMoney) throws NoMoney4GivingChange, NotEnoughMoneyPaid;
    List<T> getMoneyInShop();
}
