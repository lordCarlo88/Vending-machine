package com.techelevator.VendingMachineClasses;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GumTest {
    @Test
    public void gumSound(){
        Gum gum = new Gum("D4",.75,"Triplemint",5);
        Assert.assertEquals("Chew Chew, Yum!",gum.getSound());
    }

}