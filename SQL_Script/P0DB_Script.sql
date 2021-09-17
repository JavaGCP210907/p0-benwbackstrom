--I'm making a SQL database for a banking application

--First table is the types of accounts (checkings, savings, etc)
CREATE TABLE accounttypes (
	type_id serial PRIMARY KEY,
	type_name TEXT UNIQUE,
	interest_rate int
);

--Second table is the list of personal accounts
CREATE TABLE accounts (
	account_id serial PRIMARY KEY,
	owner_f_name TEXT,
	owner_l_name TEXT,
	open_date date, --date account was opened
	amount int,
	account_type int REFERENCES accounttypes (type_id)
);


--Fill in some data
INSERT INTO accounttypes (type_name, interest_rate)
VALUES ('Savings', 5),
	   ('Checkings', 3),
	   ('Brokerage', 8),
	   ('IRA', 9),
	   ('CD', 7);
	  
SELECT * FROM accounttypes;
	  
INSERT INTO accounts (owner_f_name, owner_l_name, open_date, amount, account_type)
VALUES ('Timothy', 'Black', '1999-02-03', 21000, 1),
	   ('Gertrude', 'Oldman', '1977-08-24', 34500, 4),
	   ('Oliver', 'Twist', '2005-04-30', 1000, 2),
	   ('Oliver', 'Twist', '2005-04-30', 5500, 1),
	   ('James', 'Green', '2007-05-08', 30000, 5),
	   ('James', 'Green', '2017-05-08', 1400, 2),
	   ('Scarlett', 'Jones', '2010-10-31', 7200, 3),
	   ('Peter', 'Quill', '2014-08-01', 200000, 1);

SELECT * FROM accounts;
