package com.techelevator.VendingMachineClasses;



public class Drink extends VendingMachineItems{

    public Drink(String slotNumber, double price, String name,int count) {

        super(name, slotNumber, price, count);
    }


    @Override
    public String getSound() {
        return "Glug Glug, Yum!";
    }
}
