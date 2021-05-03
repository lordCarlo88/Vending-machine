package com.techelevator.VendingMachineClasses;

import org.junit.Assert;
import org.junit.Test;
import java.text.DecimalFormat;

import static org.junit.Assert.*;

public class FundsTest {
    DecimalFormat df = new DecimalFormat(".00");

//Figured out how to test void methods @ 10:34pm!!!!

    @Test
    public void addTest(){
        Funds funds = new Funds(30.00);
        funds.addMoney(20.00);
        String expected = df.format(50.00);
        String actual = df.format(funds.getBalance());
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void subtractTest() {
        Funds funds = new Funds(25.0);
        funds.subtractMoney(12.0);
        String expected = df.format(13.0);
        String actual = df.format(funds.getBalance());
        Assert.assertEquals(expected,actual);


    }
    @Test
    public void zero(){
        Funds funds = new Funds(238456.00);
        funds.zero();
        String expected = df.format(0.0);
        String actual = df.format(funds.getBalance());
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getBalance() {
        Funds funds = new Funds(0.0);

        String expected = df.format(0.00);
        String  actual = (String) df.format(funds.getBalance());

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void getChange() {
        Funds funds= new Funds(8.65);


        String actual = funds.getChange();
        String expected = "34 Quarters 1 Dimes and 1 Nickle";


        Assert.assertEquals(expected,actual);
    }
   //
}