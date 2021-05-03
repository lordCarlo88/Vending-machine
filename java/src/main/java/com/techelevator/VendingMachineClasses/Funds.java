package com.techelevator.VendingMachineClasses;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Funds {
    DecimalFormat df = new DecimalFormat(".00");

    private double balance;


    public Funds(double balance) {
        this.balance = balance;
    }

    public double getBalance() {

        return balance;
    }

    public void addMoney(double moneyAdded){
        this.balance = moneyAdded + balance;
        System.out.println("Your balance is: $"+ df.format(balance));
    }


    public void subtractMoney(double spend) {
        this.balance = balance - spend;
        System.out.println("Your Remaining Balance is: $" + df.format(balance));
    }

    public void zero(){

        this.balance = 0.0;
    }

    public String getChange() {

        double cents = this.balance * 100;
        int change = (int) cents;
        String coins = "";

        while (change > 0) {
            if (change >= 25) {
                int numQuarters = change / 25;
                change -= numQuarters * 25;
                coins = coins + (numQuarters + " Quarters ");
            } else if (change >= 10) {
                int numDimes = change / 10;
                change -= numDimes * 10;
                coins = coins +  (numDimes + " Dimes");
            } else if (change >= 5) {
                int numNicks = change / 5;
                change -= numNicks*5;
                coins = coins + (" and " + numNicks + " Nickle");
            }
        }
        return coins;
    }

}







