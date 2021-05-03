package com.techelevator.VendingMachineClasses;





public class Chip extends VendingMachineItems {


    public Chip(String slotNumber, double price, String name,int count) {

        super(name, slotNumber, price,count);
    }

    @Override
    public String getSound() {
        return "Crunch Crunch, Yum!";
    }



}
