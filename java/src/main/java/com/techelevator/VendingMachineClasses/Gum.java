package com.techelevator.VendingMachineClasses;



public class Gum extends VendingMachineItems{


    public Gum(String slotNumber, double price, String name,int count) {

        super( name,slotNumber, price, count);
    }


    @Override
    public String getSound() {
        return "Chew Chew, Yum!";
    }
}
