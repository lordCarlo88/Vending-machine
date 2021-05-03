package com.techelevator.VendingMachineClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class VendingMachineItems {
private String name;
private String slotNumber;
private double price;
private int count ;
private String sound;


    public VendingMachineItems(String name, String slotNumber, double price,int count) {
        this.name = name;
        this.slotNumber = slotNumber;
        this.price = price;
        this.count = count;
    }

    public static List<VendingMachineItems> fileReader() {
    String path = "C:\\Users\\Student\\workspace\\mod1-wk4-pairs-blue-t4\\java\\vendingmachine.csv";
    File inputFile = new File(path);
        List<VendingMachineItems> items = new ArrayList<>();
    try (Scanner fileScanner = new Scanner(inputFile)) {

        while (fileScanner.hasNextLine()) {

            String line = fileScanner.nextLine();
            String[] str = line.split("\\|");
            String slotNumber = str[0];
            String name = str[1];
            double price = Double.parseDouble(str[2]);
            String kind = str[3];
            int count = 5;

            if(kind.equals("Chip")){
              Chip chips = new Chip(slotNumber,price,name,count);
              items.add(chips);
            }else if(kind.equals("Candy")){
                Candy candy = new Candy(slotNumber,price,name,count);
                items.add(candy);
            }else if(kind.equals("Drink")){
                Drink drink = new Drink(slotNumber,price,name,count);
                items.add(drink);
            }else if(kind.equals("Gum")){
                Gum gum = new Gum(slotNumber,price,name,count);
                items.add(gum);
            }
        }

    } catch (FileNotFoundException e) {
        System.out.println("File not Found");
    }

    return items;
}
    public static void PrintOut(List<VendingMachineItems>items){

        for (int i=0; i<items.size();i+=1)

        System.out.printf("%-5s %-10s %-5d %20s %n",items.get(i).getSlotNumber() , items.get(i).getPrice() , items.get(i).getCount() , items.get(i).getName());

    }

    public String getName() {
        return name;
    }

    public abstract String getSound();


    public String getSlotNumber() {
        return slotNumber;
    }

    public double getPrice() {
        return price;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count - 1;
    }


}
