package com.techelevator.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class VendingMachineTest {
    VendingMachine vendingMachine;
@Before
public void getVendingMachineInstance(){
    this.vendingMachine = new VendingMachine("capstone/vendingmachine.csv");
}
@Test
    public void zero_balance_returns_zero_dollars() {
    Assert.assertEquals("$0.00", vendingMachine.getStrBalance());
}

@Test
    public void positive_balance_returns_positive_dollars(){
    vendingMachine.feedMoney(5);
    Assert.assertEquals("$5.00", vendingMachine.getStrBalance());
}

@Test
public void positive_balance_returns_change(){
    Assert.assertEquals("Returned Change: 20 Quarter(s), 0 Dime(s) & 0 Nickel(s)!", vendingMachine.returnChange());
}

@Test
    public void zero_balance_returns_empty_string() {
    Assert.assertEquals("", vendingMachine.returnChange());
}

//@Test
//    public void calculate_change(){}
//@Test
//     public void feed_money() {}
//@Test
//public void vend() {}
//@Test
//public void populate_inventory() {}

}
