package com.jqprog.training.algorithms.varia.givingChange;

public class NoMoney4GivingChange extends Exception {

    public NoMoney4GivingChange() {
        super("Not enough money for giving change");
    }
}
