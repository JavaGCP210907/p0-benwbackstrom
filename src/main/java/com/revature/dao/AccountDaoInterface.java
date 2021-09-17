package com.revature.dao;

import java.util.List;

import com.revature.models.Account;

public interface AccountDaoInterface {

	public List<Account> getAccounts();
	
	public List<Account> getAccountsById(int id);
	
	public List<Account> getAccountsByName(String f_name, String l_name);
	
	public void addAccount(Account account);
	
	public void removeAccount(int id);
	
	public void makeDeposit(int deposit);
	
	public void makeWitdrawl(int withdrawl);
	
}
