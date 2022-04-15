package com.techelevator.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class VendingMachineTest {
    VendingMachine vendingMachine;

    @Before
    public void getVendingMachineInstance() {
        this.vendingMachine = new VendingMachine("vendingmachine.csv");
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

    @Test //Make sure available items are vended
    public void available_item_is_vended() {
        vendingMachine.feedMoney(5);
        vendingMachine.vend("D2");
        Assert.assertEquals(Integer.valueOf(4), vendingMachine.getItems().get("D2").getStock());
        Assert.assertEquals("$4.05", vendingMachine.getStrBalance());
    }

    @Test
    public void sold_out_item_is_not_vended() {
        vendingMachine.feedMoney(5);
        vendingMachine.getItems().get("B1").decreaseStock();
        vendingMachine.getItems().get("B1").decreaseStock();
        vendingMachine.getItems().get("B1").decreaseStock();
        vendingMachine.getItems().get("B1").decreaseStock();
        vendingMachine.getItems().get("B1").decreaseStock();
        vendingMachine.vend("B1");
        Assert.assertEquals("$5.00", vendingMachine.getStrBalance());
    }

    @Test
    public void not_enough_money_does_not_vend_item() {
        vendingMachine.vend("D2");
        Assert.assertEquals(Integer.valueOf(5), vendingMachine.getItems().get("D2").getStock());
        Assert.assertEquals("$0.00", vendingMachine.getStrBalance());
    }

    @Test
    public void incorrect_slot_does_not_vend() {
        vendingMachine.feedMoney(5);
        vendingMachine.vend("J2");
        Assert.assertEquals("$5.00", vendingMachine.getStrBalance());
    }
}
