package com.techelevator.VendingMachineClasses;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;

public class VendingMachineItemsTest {

    @Test
    public void fileReader() {



        File testFile = new File("C:\\Users\\Student\\workspace\\mod1-wk4-pairs-blue-t4\\java\\vendingmachine.csv");

        List<VendingMachineItems> items = new ArrayList<>();

        String expectedNameIs = "Potato Crisps";


        try (Scanner fileScanner = new Scanner(testFile)) {
            while (fileScanner.hasNextLine()) {

                String line = fileScanner.nextLine();
                String[] str = line.split("\\|");
                String slotNumber = str[0];
                String name = str[1];
                double price = Double.parseDouble(str[2]);
                String kind = str[3];
                int count = 5;

                if (kind.equals("Chip")) {
                    Chip chips = new Chip(slotNumber, price, name, count);
                    items.add(chips);
                } else if (kind.equals("Candy")) {
                    Candy candy = new Candy(slotNumber, price, name, count);
                    items.add(candy);
                } else if (kind.equals("Drink")) {
                    Drink drink = new Drink(slotNumber, price, name, count);
                    items.add(drink);
                } else if (kind.equals("Gum")) {
                    Gum gum = new Gum(slotNumber, price, name, count);
                    items.add(gum);
                }


            }

        } catch (FileNotFoundException e) {
            System.out.println("File not Found");

        }

        String actualNameIs = items.get(0).getName();
        Assert.assertEquals(expectedNameIs, actualNameIs);
    }
}

