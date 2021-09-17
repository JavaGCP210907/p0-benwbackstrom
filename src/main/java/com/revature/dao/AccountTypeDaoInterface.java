package com.revature.dao;

import java.util.List;

import com.revature.models.AccountType;

public interface AccountTypeDaoInterface {

	public void updateInterestRate(String type, int r);
	
	public List<AccountType> getAccountTypes();
	
}
