package com.techelevator.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProductTest {

    private Product product;

    @Before
    public void getProductInstance() {
        this.product = new Product(new String[]{"A1", "Potato Crisps", "3.05", "Chip"});
    }

    @Test
    public void stock_decreases() {
        Assert.assertEquals(Integer.valueOf(5), product.getStock());
        product.decreaseStock();
        Assert.assertEquals(Integer.valueOf(4), product.getStock());
    }

    @Test
    public void price_properly_formatted() {
        Assert.assertEquals("$3.05", product.getStrPrice());
    }
}
