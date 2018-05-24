package ATM;

import java.util.Scanner;
import java.io.*;


public class ATM {	
	
	static String location = "./src/database.txt";
	
	public static int getMenu()
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("메뉴를 입력하시오 : (0:종료/1:입금 /2:출금 /3:조회/4:이체/5:관리자/6:도난신고)");
		int buttonIndex = scan.nextInt();
		return buttonIndex;
	}
	
	public static String getAccount()
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("계좌번호를 입력하시오 : ");
		String account = scan.next();
		return account;	
	}
	
	public static String getTransferAccount()
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("이체할 계좌번호 입력하시오 : ");
		String to_account = scan.next();
		return to_account;
		
	}
	
	public static int getAmount()
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("금액을 입력하시오 : ");
		int amount = scan.nextInt();
		return amount;
	}
	
	public static boolean checkAmountError(int amount)
	{
		if(amount > 1000000)
			return false;
		else
			return true;
	}
	
	public static String getPw()
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Password : ");
		String pw = scan.next();
		return pw;
	}
	
	public static String getAdminAccount()
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("관리자 아이디를 입력하시오: ");
		String id = scan.next();
		return id;
	}
	
	public static int getAdminPw()
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("관리자 비밀번호 : ");
		int pw = scan.nextInt();
		return pw;
	}
	
	public static int getAdminMenu()
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("which function would you like to choose? (1:check cash / 2:add cash)");
		int index = scan.nextInt();
		return index;
	}
	
	public static int getCashAmount()
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("추가 금액을 입력하시오 : ");
		int amount = scan.nextInt();
		return amount;
	}
	
	public static String getRobberyAccount()
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("도난신고할 계좌 입력 : ");
		String account = scan.next();
		return account;
	}
	
	public static String getRobberyPw()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Password : ");
		String pw = scan.next();
		return pw;
	}
	
	public static BufferedReader loadData(String location) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(location));
		return br;
	}
	
	public static BufferedWriter saveData(String location) throws IOException
	{
		BufferedWriter wr = new BufferedWriter(new FileWriter(location));
		return wr;
	}
	
	
	
	public static void deposit(Admin admin) throws IOException
	{
		String account = getAccount();	
		User_Data d = find(account);
		
		if(d == null)
		{
			System.out.println("cannot find the account");
			
		}	
		else
		{			
				int amount = getAmount();
				if(!(checkAmountError(amount)))
				{
					System.out.println("금액초과!");
				}
				else
				{
					// 정상적인 경우
					if(calculate(d, amount))
					{
						//계산 끝 and gui 보여주기 (확인)
						saveInfo(d);
						admin.AdminCalculate(amount); // ATM 현금 추가
						System.out.println("잔액은 "+d.getBalance());
						System.out.println("성공!");
					
					}
					else
					{
						System.out.println("Error!(calculate error)");
					}
				
				
			}
			
		}
	}
	
	public static void withdraw(Admin admin) throws IOException
	{
		String account = getAccount();
		User_Data d = find(account);
		
		if(d == null)
		{
			System.out.println("cannot find the account");
			
		}	
		else
		{
			String pw = getPw();
			if(d.checkAccountPw(account, pw))
			{
				int amount = getAmount();
				if(!(checkAmountError(amount)))
				{
					System.out.println("금액초과!");
				}
				else
				{
					// 정상적인 경우
					if(calculate(d, -amount))
					{
						//계산 끝 and gui 보여주기 (확인)
						saveInfo(d);
						admin.AdminCalculate(-amount); // ATM 현금 추가
						System.out.println("잔액은 "+d.getBalance());
						System.out.println("성공!");
					
					}
					else
					{
						System.out.println("Error!(calculate error)");
					}
				
				}
			}
			else
			{
				System.out.println("wrong pw!");
			}
		}				
	}

	
	public static void transfer(Admin admin) throws IOException
	{
		String account = getAccount();
		User_Data from = find(account);
		if(from == null)
		{
			System.out.println("cannot find the account!");
		}
		else
		{
			String pw = getPw();
			if(from.checkAccountPw(account, pw))
			{
				String to_account = getTransferAccount();				
				User_Data to = find(to_account);
				if(to == null)
				{
					System.out.println("Wrong Account!");
				}
				else
				{
					int amount = getAmount();
					if(Integer.parseInt(from.getBalance()) < amount)
					{
						System.out.println("not enough money");
					}
					else
					{
						if(calculate(from, -amount))
						{
							calculate(to, amount);
							admin.AdminCalculate(amount);
							saveInfo(from);
							saveInfo(to);
							System.out.println("해당 계좌의 잔액 : "+from.getBalance());
							System.out.println("이체 계좌의 잔액 : "+to.getBalance());
							System.out.println("성공!");
						}
						else
						{
							System.out.println("Error (calculate error)");
						}
					}
				}
				
			}
			else
			{
				System.out.println("Wrong Password!");
			}
		}
		
	}
	
	public static void checkBalance() throws IOException
	{
		String account = getAccount();
		User_Data d = find(account);
		if(d == null)
			System.out.println("cannot find the account");
		else
		{
			String pw = getPw();
			if(d.checkAccountPw(account, pw))
			{
				System.out.println("잔액 : "+d.getBalance());
				System.out.println("이름 : "+d.getName());
				System.out.println("은행 : "+d.getBank());
			}
			else
			{
				System.out.println("Wrong PW!");
			}
		}
	}
	
	
	
	public static void changeAdmin(Admin admin)
	{
		String id = getAdminAccount();
		if(admin.CheckAdminID(id))
		{
			int pw = getAdminPw();
			if(admin.CheckAdminPW(pw))
			{
				int index = getAdminMenu();
				if(index == 1)
				{
					System.out.println("ATM의 현금 잔액 : "+admin.getAdminCash());
				}
				else if(index == 2)
				{
					int amount = getCashAmount();
					admin.AdminCalculate(amount);
					System.out.println("추가 후 현금 잔액 : "+admin.getAdminCash());
				}
				else
				{
					System.out.println("Wrong approach!");
					return;
				}
			}
			else
			{
				System.out.println("Wrong Pw!");
			}
				
		}
		else
		{
			System.out.println("Wrong ID!");
		}
		
	}
	
	public static void robberyreport() throws IOException
	{
		String account = getRobberyAccount();
		User_Data d = find(account);
		if(d==null)
			System.out.println("cannot find the account!");
		else
		{
			String pw = getRobberyPw();
			if(d.checkAccountPw(account, pw))
			{
				
				System.out.println("Stolen! deletion completed! "+d.getAccountNum());
				deleteInfo(d);
			}
			else
			{
				System.out.println("Wrong Password!");
			}
		}
	}
	
	public static void deleteInfo(User_Data d) throws IOException
	{
		BufferedReader br = loadData(location);
		String line;
		String account;
		String l[] = new String[30];
		int i =0;
		
		account = d.getAccountNum();
		while((line = br.readLine()) != null)
		{
			l[i] = line;
			i++;
		}
		int len = i; 
		
		for(i =0; i< len; i++)
		{
			
			if((l[i].substring(0, 6)).equals(account))
			{
				l[i] = "                                               ";
				
			}
		}
		line = "";
		for(i = 0; i < len; i++)
		{
			if(i == len-1)
			{
				line += l[i];
			}
			else
			{
				line += l[i];
				line += "\r\n";
			}
		}
		BufferedWriter wr = saveData(location);
		wr.write(line);
		
		wr.close();
		br.close();
	}
	
	public static void saveInfo(User_Data d) throws IOException
	{
		BufferedReader br = loadData(location);
		String line;
		String account;
		String l[] = new String[30];
		int i =0;
		
		account = d.getAccountNum();
		while((line = br.readLine()) != null)
		{
			l[i] = line;
			i++;
		}
		int len = i; 
		
		for(i =0; i< len; i++)
		{
			
			if((l[i].substring(0, 6)).equals(account))
			{
				l[i] = d.getAccountNum() +" " + d.getPw()+" " + d.getBank()+" " + d.getName()+" " + d.getBalance();
				
			}
		}
		line = "";
		for(i = 0; i < len; i++)
		{
			if(i == len-1)
			{
				line += l[i];
			}
			else
			{
				line += l[i];
				line += "\r\n";
			}
		}
		BufferedWriter wr = saveData(location);
		wr.write(line);
		
		wr.close();
		br.close();
	}
	
	public static boolean calculate(User_Data d, int money)
	{
		int balance = Integer.parseInt(d.getBalance());
		
		if((balance += money) < 0)
		{
			return false;
		}
		else
		{
			d.setBalance(Integer.toString(balance));
			return true;
		}
		
	}	
	
	
	
	public static User_Data find(String account) throws IOException
	{
		BufferedReader br = loadData(location);
		String line;
		String l[] = new String[30];
		int i =0;
		User_Data d = new User_Data(null,null,null,null,null);
		
		while((line = br.readLine()) != null)
		{
			l[i] = line;
			i++;
		}
		int len = i;
		for(i =0; i< len; i++)
		{
			if(l[i].substring(0, 6).equals(account))
			{
				// 노드에 추가
				d.setAccountNum(account);
				d.setBalance(l[i].substring(19));
				d.setBank(l[i].substring(12,14));
				d.setName(l[i].substring(15,18));
				d.setPw(l[i].substring(7,11));
				return d;
			}
			
		}
		br.close();
		return  null;
	}
	

}
