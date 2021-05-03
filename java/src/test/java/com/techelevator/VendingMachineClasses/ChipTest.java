package com.techelevator.VendingMachineClasses;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ChipTest {
    @Test
    public void chipSound(){
        Chip chip = new Chip("A1",3.05,"Potato Crisps",5);
        Assert.assertEquals("Crunch Crunch, Yum!",chip.getSound());
    }

    @Test
    public void slotTest() {
        VendingMachineItems vmi = new Chip("A1", 3.05, "Potato Crisps", 5);
        List<VendingMachineItems> items = new ArrayList<>();
        items = VendingMachineItems.fileReader();

        String expected = "A1"+"Potato Crisps";
        String actual = items.get(0).getSlotNumber()+items.get(0).getName();

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void priceTest() {
        VendingMachineItems vmi = new Chip("A1", 3.05, "Potato Crisps", 5);
        List<VendingMachineItems> items = new ArrayList<>();
        items = VendingMachineItems.fileReader();

        double expected = 3.05;
        double actual = items.get(0).getPrice();

        Assert.assertEquals(expected, actual,0);
    }
    @Test
    public void countTest() {
        VendingMachineItems vmi = new Chip("A1", 3.05, "Potato Crisps", 5);
        List<VendingMachineItems> items = new ArrayList<>();
        items = VendingMachineItems.fileReader();

        int expected = 5;
        int actual = items.get(0).getCount();

        Assert.assertEquals(expected, actual,0);
    }
    @Test
    public void setterTest() {
        VendingMachineItems vmi = new Chip("A1", 3.05, "Potato Crisps", 5);
        List<VendingMachineItems> items = new ArrayList<>();
        items = VendingMachineItems.fileReader();

        int expected = 4;
        items.get(0).setCount(5);

        Assert.assertEquals(expected, items.get(0).getCount(),0);
    }
    @Test
    public void printTest() {
        VendingMachineItems vmi = new Chip("A1", 3.05, "Potato Crisps", 5);
        List<VendingMachineItems> items = new ArrayList<>();
        items = VendingMachineItems.fileReader();
        VendingMachineItems.PrintOut(items);

        items.get(0).setCount(5);
        int expected = 4;


        Assert.assertEquals(expected, items.get(0).getCount(),0);
    }


}