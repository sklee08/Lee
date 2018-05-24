package ATM;

import java.util.Scanner;

public class Admin {

	private int admin_cash;
	private String admin_id;
	private int admin_pw;
	
	
	public Admin()
	{
		this.admin_cash = 5000000;
		this.admin_id = "sklee08";
		this.admin_pw = 1234;
	}
	
	
	public boolean CheckAdminID(String id)
	{
		if(id.equals("sklee08"))
		{
			return true;
		}
		else
			return false;
	}
	
	public boolean CheckAdminPW(int pw)
	{
		if(pw == 1234)
		{
			return true;
		}
		else
			return false;
	}
	
	public void AdminCalculate(int amount) 
	{
		this.admin_cash += amount;
	}
	
	public int getAdminCash()
	{
		return this.admin_cash;
	}
}
