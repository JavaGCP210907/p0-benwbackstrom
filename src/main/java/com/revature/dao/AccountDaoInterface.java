package com.revature.dao;

import java.util.List;

import com.revature.models.Account;

public interface AccountDaoInterface {

	public List<Account> getAccounts();
	
	public List<Account> getAccountsById(int id);
	
	public List<Account> getAccountsByName(String f_name, String l_name);
	
	public List<Account> getAccountsByType(String type);
	
	public void addAccount(Account account);
	
	public void removeAccount(int id);
	
	public void makeDeposit(int id, int deposit);
	
	public void makeWithdrawl(int id, int withdrawl);
	
}
