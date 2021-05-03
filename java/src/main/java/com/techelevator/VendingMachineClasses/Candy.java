package com.techelevator.VendingMachineClasses;

import java.math.BigDecimal;

public class Candy extends VendingMachineItems {


    public Candy(String slotNumber, double price, String name,int count) {
        super( name, slotNumber, price, count);
    }

    @Override
    public String getSound() {
        return "Munch Munch, Yum!";
    }


}