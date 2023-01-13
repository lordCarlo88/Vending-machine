package com.techelevator;

import com.techelevator.VendingMachineClasses.*;
import com.techelevator.view.Menu;


import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE,EXIT};
	private static final String[] PURCHASE_MENU_OPTIONS = {"Feed Money", "Select Product", "Finish Transaction",};
	private static final String[] MONEY_OPTIONS = {"$1.00", "$2.00", "$5.00", "$10.00", "Back"};

	private Menu menu;
	private Funds funds = new Funds(0.00);

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	List<VendingMachineItems> items = new ArrayList<>();
	DecimalFormat df = new DecimalFormat("#0.00");

	public void run()  {

		if(items.isEmpty()){
			items = VendingMachineItems.fileReader();
		}

		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			System.out.println("The Choice Selected From The First Level Is: " + choice);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				VendingMachineItems.PrintOut(items);

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				handlePurchaseOptions(items);
			}
			else if(choice.equals(EXIT)){
				recordTransaction(String.format("%-42s %24s %27s ","-------Balance: $" + df.format(funds.getBalance()),"GIVE CHANGE: $"+df.format(funds.getBalance()), "Final Balance: $0.00"));
				System.exit(0);
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}

	public void handlePurchaseOptions(List<VendingMachineItems> items) {
		boolean stay = true;
		while (stay) {

			String choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

			if (choice.equals("Feed Money")) {
				System.out.println("Feeding Money");
				handleFeedMoney();

			} else if (choice.equals("Select Product")) {
				VendingMachineItems.PrintOut(items);
				System.out.println("Your balance is: $" + df.format(funds.getBalance()));
				Scanner userInput = new Scanner(System.in);
				String input = userInput.nextLine().toUpperCase();

				for(int i = 0;i<items.size();i+=1) {
					if (items.get(i).getSlotNumber().equals(input)) {
						int tempcount = items.get(i).getCount();
						if(tempcount ==0) {
							System.out.println("SOLD OUT!");
							return ;
						}
						items.get(i).setCount(tempcount);

						System.out.println(items.get(i).getName() +" ----- $"+ items.get(i).getPrice());
						if(items.get(i).getPrice()<=funds.getBalance()){
							double tempBalance = funds.getBalance();
							funds.subtractMoney(items.get(i).getPrice());
							System.out.println(items.get(i).getSound());
							recordTransaction(String.format("%-31s %-10s %22s %27s","Purchasing: " + items.get(i).getName(),"Slot: "+items.get(i).getSlotNumber(),"Starting Balance: $"+df.format(tempBalance),"Remaining Balance: $"+df.format(funds.getBalance())));

						}else{
							System.out.println("You do not have enough money");
							System.out.println("Your balance is: "+ df.format(funds.getBalance()));
						}
					}
				}

			} else if (choice.equals("Finish Transaction")) {
				System.out.println("Here is your Change");
				System.out.println(funds.getChange());
				stay = false;
				if (funds.getBalance() > 0) {
					recordTransaction(String.format("%-41s %25s","---GIVE CHANGE: $" + df.format(funds.getBalance()),"Balance: $0.00"));
				}
				funds.zero();
			}
		}
	}

	public void handleFeedMoney() {

		boolean stay = true;
		while (stay) {
			String choice = (String) menu.getChoiceFromOptions(MONEY_OPTIONS);

			if (choice.equals("$1.00")) {
				funds.addMoney(1.00);
			} else if (choice.equals("$2.00")) {
				funds.addMoney(2.00);
			} else if (choice.equals("$5.00")) {
				funds.addMoney(5.00);
			} else if (choice.equals("$10.00")) {
				funds.addMoney(10.00);
			} else if (choice.equals("Back")) {
				stay = false;
			}
			if(stay){
				recordTransaction(String.format("%-42s %-22s ","----FEED MONEY: "+ choice , "BALANCE: $"+df.format(funds.getBalance())));
			}
		}
	}

	public static void recordTransaction(String choice){
		try{
			FileWriter myWriter = new FileWriter("C:\\Users\\Three Brothers Sound\\workspace\\repos\\Vending-machine\\java\\src\\main\\resources\\log.txt",true);
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			myWriter.write(">" + dtf.format(now)+" "+choice+"\r\n");
			myWriter.close();

		}catch (IOException e){
			System.out.println("Could not Write.");
			e.printStackTrace();
		}
	}

}


