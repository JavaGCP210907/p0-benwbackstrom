package com.revature.models;

//import java.util.List;
import java.util.Scanner;

public class Menu {

	
	public void displayMenu() {
		boolean displayMenu = true; //we're going to use this to toggle whether the menu continues after user input
		Scanner scan = new Scanner(System.in); //Scanner object to parse user input
		
		//pretty greeting
		System.out.println("*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*");
		System.out.println("Welcome to the Account Management System!");
		System.out.println("*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*");
		
		//display the menu as long as the displayMenu boolean is true
		while(displayMenu) {
			
			System.out.println("-----------------");
			System.out.println("Choose an option:");
			System.out.println("-----------------");
			
			//menu options
			System.out.println("hi -> get greeted");
			System.out.println("accounts -> show all accounts");
			System.out.println("accountbyid -> get account with a certain id");
			System.out.println("accountbyname -> get accounts of certain person");
			System.out.println("addaccount -> add a new account");
			System.out.println("deleteaccount -> delete an account");
			System.out.println("deposit -> make a deposit to a certain account");
			System.out.println("withdrawl -> withdrawl money from a certain account");
			System.out.println("updateinterest -> update the interest of an account type");
			System.out.println("exit -> exit application");
			
			//parse user input after they choose a menu option
			String input = scan.nextLine();
			
			//switch statement that takes input, and delivers appropriate response
			switch(input) {
			
			case "hi":{
				System.out.println("Hello there~");
				break;
			}
			
			case "exit":{
				displayMenu = false;
				System.out.println("Bye!");
				break;
			}
			
			default:{
				System.out.println("Sorry, I do not understand command: " + input);
				break;
			}
			
			}
			
			
		}//end while
		
		System.out.println("Thank you for using the AMS");
		scan.close(); //closes the Scanner
		
	
	}
}
