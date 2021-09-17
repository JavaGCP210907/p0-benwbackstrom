package com.revature.models;

public class AccountType {

	//fields for AccountType class - must match database
	private int type_id;
	private String type_name;
	private int interest_rate;
	
	
	//boilerplate code ----------------------------------------
	//Constructors
	public AccountType() {
		super();
	}


	public AccountType(int type_id, String type_name, int interest_rate) {
		super();
		this.type_id = type_id;
		this.type_name = type_name;
		this.interest_rate = interest_rate;
	}


	public AccountType(String type_name, int interest_rate) {
		super();
		this.type_name = type_name;
		this.interest_rate = interest_rate;
	}

	//toString()
	@Override
	public String toString() {
		return "AccountType [type_id=" + type_id + ", type_name=" + type_name + ", interest_rate=" + interest_rate
				+ "]";
	}

	//Getters and Setters
	public int getType_id() {
		return type_id;
	}


	public void setType_id(int type_id) {
		this.type_id = type_id;
	}


	public String getType_name() {
		return type_name;
	}


	public void setType_name(String type_name) {
		this.type_name = type_name;
	}


	public int getInterest_rate() {
		return interest_rate;
	}


	public void setInterest_rate(int interest_rate) {
		this.interest_rate = interest_rate;
	}

	//hashcode and equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + interest_rate;
		result = prime * result + type_id;
		result = prime * result + ((type_name == null) ? 0 : type_name.hashCode());
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
		AccountType other = (AccountType) obj;
		if (interest_rate != other.interest_rate)
			return false;
		if (type_id != other.type_id)
			return false;
		if (type_name == null) {
			if (other.type_name != null)
				return false;
		} else if (!type_name.equals(other.type_name))
			return false;
		return true;
	}
	
	
	
	
	
	
	
}
