package com.revature.models;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.dao.AccountDao;
import com.revature.dao.AccountTypeDao;



public class Menu {

	AccountDao aDao = new AccountDao();
	AccountTypeDao atDao = new AccountTypeDao();
	Logger log = LogManager.getLogger(Menu.class); //Logger object so that we can implement Logging
	
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
			System.out.println("accounttypes -> show all types of accounts");
			System.out.println("accountbyid -> get account with a certain id");
			System.out.println("accountsbyname -> get accounts of certain person");
			System.out.println("accountsbytype -> get accounts of a certaintype");
			
			System.out.println("addaccount -> add a new account");
			System.out.println("deleteaccount -> delete an account");
			System.out.println("deposit -> make a deposit to a certain account");
			System.out.println("withdrawl -> withdrawl money from a certain account");
			System.out.println("updateinterest -> update the interest of an account type");
			System.out.println("exit -> exit application");
			
			//parse user input after they choose a menu option
			String input = scan.nextLine();
			
			//switch statement that takes input, and delivers appropriate response
			switch(input.toLowerCase()) {
			//used .toLowerCase() to help out the user on case for the switch statement
			case "hi":{
				System.out.println("Hello there~");
				break;
			}//end case
			
			case "accounts":{
				//get List of Accounts from the DAO layer
				List<Account> accounts = aDao.getAccounts();
				
				for (Account a : accounts) {
					System.out.println(a);
				}//end for
				
				log.info("USER RETRIVED LIST OF ALL ACCOUNTS");
				
				break;
			}//end case
			
			case "accounttypes":{
				List<AccountType> atypes = atDao.getAccountTypes();
				
				for (AccountType at : atypes) {
					System.out.println(at);
				}//end for
				
				break;
			}//end case
			
			case "accountbyid":{
				System.out.println("What account id would you like to search for?");
				
				int id = scan.nextInt(); //get's users input for id
				scan.nextLine();
				
				List<Account> accounts = aDao.getAccountsById(id);
				
				for (Account a : accounts) {
					System.out.println(a);
				}//end for
				
				
				break;
			}//end case
			
			case "accountsbyname":{
				System.out.println("Please Enter the Owner's Full Name you'd like to search for:");
				
				String fullName = scan.nextLine();
				String[] name = fullName.split("\\s+"); //Splits input delimited by spaces
				
				List<Account> accounts = aDao.getAccountsByName(name[0], name[1]);
				
				for(Account a : accounts) {
					System.out.println(a);
				}//end for
				
				log.info("USER RETRIEVED LIST OF ACCOUNTS OWNED BY " + name[0].toUpperCase() + " " + name[1].toUpperCase());
				
				break;
			}//end case
			
			case "accountsbytype":{
				System.out.println("Which type account do you wish to search for?");
				
				String type = scan.nextLine();
				
				List<Account> accounts = aDao.getAccountsByType(type);
				
				for(Account a : accounts) {
					System.out.println(a);
				}//end for
				
				break;
			}//end case
			
			case "addaccount":{
				
				System.out.println("Enter Owner's First name");
				String oFName = scan.nextLine();
				
				System.out.println("Enter Owner's Last name");
				String oLName = scan.nextLine();
				
				System.out.println("Enter Opening Deposit");
				int amount = scan.nextInt();
				scan.nextLine();
				
				System.out.println("Enter Account Type Id");
				System.out.println("Savings: 1 | Checkings: 2 | Brokerage: 3 | IRA: 4 | CD: 5");
				int accountTId = scan.nextInt();
				scan.nextLine();
				
				//create new Account based on inputs
				Account acc = new Account(oFName, oLName, "xxx", amount, accountTId);
				
				aDao.addAccount(acc);
				
				log.info("USER ADDED ACCOUNT");
				
				break;
			}
			
			case "deleteaccount":{
				
				System.out.println("Please Enter the ID of the Account to delete.");
				
				int id = scan.nextInt();
				scan.nextLine();
				
				aDao.removeAccount(id);
				
				log.warn("USER DELETED ACCOUNT No. " + id);
				
				break;
			}
			
			case "deposit":{
				
				System.out.println("Please Enter the Id of the Account to send a deposit");
				int id = scan.nextInt();
				scan.nextLine();
				
				System.out.println("Enter Amount to Deposit");
				int amount = scan.nextInt();
				scan.nextLine();
				
				aDao.makeDeposit(id, amount);
				
				log.info("USER DEPOSITED $" + amount + " INTO ACCOUNT No. " + id);
				
				break;
			}
			
			case "withdrawl":{
				
				System.out.println("Please Enter the Id of the Account to make a withdrawl");
				int id = scan.nextInt();
				scan.nextLine();
				
				System.out.println("Enter Amount to Withdrawl");
				int amount = scan.nextInt();
				scan.nextLine();
				
				aDao.makeWithdrawl(id, amount);
				
				log.warn("USER WITHDREW $" + amount + " FROM ACCOUNT No. " + id);
				
				break;
			}
			
			case "updateinterest":{
				System.out.println("Which type of account would you like to update the interest rate?");
				String type = scan.nextLine();
				
				System.out.println("Enter new percent interest rate");
				int r = scan.nextInt();
				scan.nextLine();
				
				atDao.updateInterestRate(type, r);
				
				break;
			}//end case
			
			case "exit":{
				displayMenu = false;
				System.out.println("Bye!");
				break;
			}//end case
			
			default:{
				System.out.println("Sorry, I do not understand command: " + input);
				break;
			}//end default case
			
			}//end switch
			
			
		}//end while
		
		System.out.println("Thank you for using the AMS");
		scan.close(); //closes the Scanner
		
	
	}//end displayMenu()
}
