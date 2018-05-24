package ATM;

import java.util.Scanner;

public class User_Data {

	private String accountNum;
	private String pw;
	private String bank;
	private String name;
	private String balance;
	
	
	User_Data(String account, String pw, String bank, String name, String balance)
	{
		this.accountNum = account;
		this.pw = pw;
		this.bank = bank;
		this.name = name;
		this.balance = balance;
	}


	public boolean checkAccountPw(String account, String pw)
	{
		if(account.equals(this.accountNum) && pw.equals(this.pw))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean checkBank(String bank)
	{
		if(bank.equals(this.bank))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public String getAccountNum() {
		return accountNum;
	}


	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getBank() {
		return bank;
	}


	public void setBank(String bank) {
		this.bank = bank;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBalance() {
		return balance;
	}


	public void setBalance(String balance) {
		this.balance = balance;
	}

}
