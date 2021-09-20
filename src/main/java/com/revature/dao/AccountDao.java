package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.revature.models.Account;
import com.revature.utils.ConnectionUtil;

public class AccountDao implements AccountDaoInterface{
	
	public static List<Account> fillAccountList(ResultSet rs) throws SQLException {
		//static method created to have less repeated code to fill List
		//create an empty list to be filled with the data from the database
		List<Account> accountList = new ArrayList<>();
		
		while(rs.next()) { //while there are results in the Result Set
			//Create a new Account object from each returned row
			Account a = new Account(
					rs.getInt("account_id"),
					rs.getString("owner_f_name"),
					rs.getString("owner_l_name"),
					rs.getString("open_date"),
					rs.getInt("amount"),
					rs.getInt("account_type")
					);
			
			//and populate the ArrayList with each new Account object
			accountList.add(a);
		}//end while
		
		//when there are no more results in the ResultSet the while loop will break
		return accountList;
	}
	
	//Overriden Methods ------------------------------------------------------------

	@Override
	public List<Account> getAccounts() {
		//open Connection to our database
		try(Connection conn = ConnectionUtil.getConnection()){
			
			//initialize empty ResultSet object
			ResultSet rs = null;
			
			//write out our SQL query, and store it in a String
			String sql = "select * from accounts";
			
			//Put the SQL query into a Statement object
			Statement s = conn.createStatement();
			
			//execute the query, putting the results into our ResultSet object
			rs = s.executeQuery(sql);
			
			//ALL the code above makes a call to our database... Now we need to store the data in a List
			
			List<Account> accountList = fillAccountList(rs);
			//refactored code to call method instead of having while loop directly in this block
			
			return accountList;
			
		}catch(SQLException e) {
			System.out.println("Something went wrong with your database!"); //generic console message
			e.printStackTrace(); //stack trace so we actually know what went wrong
		}//end try-catch
		
		return null;
	}//end getAccounts()

	@Override
	public List<Account> getAccountsById(int id) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			ResultSet rs = null;
			
			String sql = "select * from accounts where account_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			List<Account> accountList = fillAccountList(rs);
			
			return accountList;
			
		}catch(SQLException e) {
			System.out.println("Something went wrong with your database!");
			e.printStackTrace();
		}//end try/catch
		
		return null;
	}//end method

	@Override
	public List<Account> getAccountsByName(String f_name, String l_name) {//using AND operator
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			ResultSet rs = null;
			
			String sql = "select * from accounts where owner_f_name = ? and owner_l_name = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, f_name);
			ps.setString(2, l_name);
			
			rs = ps.executeQuery();
			
			List<Account> accountList = fillAccountList(rs);
			
			return accountList;
			
		}catch(SQLException e) {
			System.out.println("Something went wrong with your database!");
			e.printStackTrace();
		}//end try/catch
		
		return null;
	}//end method
	
	@Override
	public List<Account> getAccountsByType(String type) {//uses a join
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			ResultSet rs = null;
			
			String sql = "select * from accounts inner join accounttypes "
						+ "on account_type = type_id where type_name = ?";
			//need to join accounts to accounttypes to access type names
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, type);
			
			rs = ps.executeQuery();
			
			List<Account> accountList = fillAccountList(rs);
			
			return accountList;
			
		}catch(SQLException e) {
			System.out.println("Something went wrong with your database!");
			e.printStackTrace();
		}//end try/catch
		
		return null;
	}//end method

	@Override
	public void addAccount(Account account) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date(); 
			String currentDate = dateFormat.format(date);
			
			String sql = "insert into accounts (owner_f_name, owner_l_name, open_date, amount, account_type)"
						+ " values (?, ?, ?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, account.getOwner_f_name());
			ps.setString(2, account.getOwner_l_name());
			ps.setDate(3, java.sql.Date.valueOf(currentDate));
			ps.setInt(4, account.getAmount());
			ps.setInt(5, account.getAccount_type());
			
			ps.executeUpdate(); //send new account to DB
			
			//If everything goes right, send message to the console
			System.out.println("Account Added Sucessfully!");
			
		}catch(SQLException e) {
			System.out.println("Account could not be added");
			e.printStackTrace();
		}//end try/catch
		
	}//end method

	@Override
	public void removeAccount(int id) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "delete * from accounts where account_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			ps.executeUpdate();
			
			//Should all go well
			System.out.println("Account No: " + id + " has been removed.");
			
			
		}catch(SQLException e) {
			System.out.println("Account could not be deleted");
			e.printStackTrace();
		}//end try/catch
		
	}//end method

	@Override
	public void makeDeposit(int id, int deposit) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "update accounts set amount = amount + ? where account_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, deposit);
			ps.setInt(2, id);
			
			ps.executeUpdate();
			
			System.out.println("$" + deposit + ".00 has been added to account No. " + id);
			
		}catch(SQLException e) {
			System.out.println("Cannot make that deposit");
			e.printStackTrace();
		}//end try/catch
		
	}//end method

	@Override
	public void makeWithdrawl(int id, int withdrawl) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "update accounts set amount = amount - ? where account_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, withdrawl);
			ps.setInt(2, id);
			
			ps.executeUpdate();
			
			System.out.println("$" + withdrawl + ".00 has been removed to account No. " + id);
			
		}catch(SQLException e) {
			System.out.println("Cannot make that withdrawl");
			e.printStackTrace();
		}//end try/catch
		
	}//end method

}
