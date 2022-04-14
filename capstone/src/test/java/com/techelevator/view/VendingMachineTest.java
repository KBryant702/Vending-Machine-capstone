package com.techelevator.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class VendingMachineTest {
    VendingMachine vendingMachine;

    @Before
    public void getVendingMachineInstance() {
        this.vendingMachine = new VendingMachine("capstone/vendingmachine.csv");
    }

    @Test
    public void zero_balance_returns_zero_dollars() {
        Assert.assertEquals("$0.00", vendingMachine.getStrBalance());
    }

    @Test
    public void positive_balance_returns_positive_dollars() {
        vendingMachine.feedMoney(5);
        Assert.assertEquals("$5.00", vendingMachine.getStrBalance());
    }

    @Test
    public void positive_balance_returns_change() {
        vendingMachine.feedMoney(5);
        vendingMachine.vend("D1");
        Assert.assertEquals("Returned Change: 16 Quarter(s), 1 Dime(s) & 1 Nickel(s)!", vendingMachine.returnChange());
    }

    @Test
    public void zero_balance_returns_empty_string() {
        Assert.assertEquals("", vendingMachine.returnChange());
    }

  // @Test //Make sure available items are vended
    // @Test sold out
    // @Test not enough money
    //@Test Incorrect Slot


}
