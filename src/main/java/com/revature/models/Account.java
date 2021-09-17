package com.revature.models;

public class Account {

	//fields from accounts table - Account Class
	private int account_id;
	private String owner_f_name;
	private String owner_l_name;
	private String open_date;
	private int amount;
	private int account_type;
	
	
	//boilerplate code -----------------------------------
	//Constructors
	public Account() {
		super();
	}


	public Account(int account_id, String owner_f_name, String owner_l_name, String open_date, int amount,
			int account_type) {
		super();
		this.account_id = account_id;
		this.owner_f_name = owner_f_name;
		this.owner_l_name = owner_l_name;
		this.open_date = open_date;
		this.amount = amount;
		this.account_type = account_type;
	}


	public Account(String owner_f_name, String owner_l_name, String open_date, int amount, int account_type) {
		super();
		this.owner_f_name = owner_f_name;
		this.owner_l_name = owner_l_name;
		this.open_date = open_date;
		this.amount = amount;
		this.account_type = account_type;
	}

	//toString()
	@Override
	public String toString() {
		return "Account [account_id=" + account_id + ", owner_f_name=" + owner_f_name + ", owner_l_name=" + owner_l_name
				+ ", open_date=" + open_date + ", amount=" + amount + ", account_type=" + account_type + "]";
	}

	//Getters and Setters
	public int getAccount_id() {
		return account_id;
	}


	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}


	public String getOwner_f_name() {
		return owner_f_name;
	}


	public void setOwner_f_name(String owner_f_name) {
		this.owner_f_name = owner_f_name;
	}


	public String getOwner_l_name() {
		return owner_l_name;
	}


	public void setOwner_l_name(String owner_l_name) {
		this.owner_l_name = owner_l_name;
	}


	public String getOpen_date() {
		return open_date;
	}


	public void setOpen_date(String open_date) {
		this.open_date = open_date;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public int getAccount_type() {
		return account_type;
	}


	public void setAccount_type(int account_type) {
		this.account_type = account_type;
	}

	//hashcode() and equals()
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + account_id;
		result = prime * result + account_type;
		result = prime * result + amount;
		result = prime * result + ((open_date == null) ? 0 : open_date.hashCode());
		result = prime * result + ((owner_f_name == null) ? 0 : owner_f_name.hashCode());
		result = prime * result + ((owner_l_name == null) ? 0 : owner_l_name.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (account_id != other.account_id)
			return false;
		if (account_type != other.account_type)
			return false;
		if (amount != other.amount)
			return false;
		if (open_date == null) {
			if (other.open_date != null)
				return false;
		} else if (!open_date.equals(other.open_date))
			return false;
		if (owner_f_name == null) {
			if (other.owner_f_name != null)
				return false;
		} else if (!owner_f_name.equals(other.owner_f_name))
			return false;
		if (owner_l_name == null) {
			if (other.owner_l_name != null)
				return false;
		} else if (!owner_l_name.equals(other.owner_l_name))
			return false;
		return true;
	}
	
}
