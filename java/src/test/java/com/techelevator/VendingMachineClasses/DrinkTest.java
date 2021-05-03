package com.techelevator.VendingMachineClasses;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DrinkTest {
    @Test
    public void drinkSound(){
        Drink drink = new Drink("C1",1.25,"Cola",5);
        Assert.assertEquals("Glug Glug, Yum!",drink.getSound());
    }

}