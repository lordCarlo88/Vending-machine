package com.techelevator.VendingMachineClasses;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CandyTest {
    @Test
    public void candySound(){
        Candy candy = new Candy("B1",1.80,"Moonpie",5);
        Assert.assertEquals("Munch Munch, Yum!",candy.getSound());
    }

}