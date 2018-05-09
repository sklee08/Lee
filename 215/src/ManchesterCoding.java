import java.util.Scanner;

public class ManchesterCoding {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("비트를  입력하시오 : ");
		String getLine = scan.nextLine();	// 비트를 받아온다.
		
		Man(getLine);
		DiffMan(getLine);
	}

	
	public static void Man(String input)
	{
		String zeroCase = "─_";
		String oneCase = "_─";
		
		
		System.out.print("Manchester coding is ");
		for(int i =0; i<input.length(); i++)
		{
			if(input.charAt(i) == '0')
			{
				System.out.print(zeroCase);
			}
			else if(input.charAt(i) == '1')
			{
				System.out.print(oneCase);
			}
			else	System.out.println("Wrong Bit!");
		}
		System.out.println();
		
	}
	
	public static void DiffMan(String input)
	{
		String prev = "─_";
		
		System.out.print("Differential Manchester coding is ");
		for(int i = 0; i < input.length(); i++)
		{
			if(input.charAt(i) == '0')
			{
					System.out.print(prev);
			}
			else if(input.charAt(i) == '1')
			{
				if(prev.equals("─_")) {
					prev = "_─";
					System.out.print(prev);
				}else {
					prev = "─_";
					System.out.print(prev);
				}
			}
			else System.out.println("Wrong Bit!");
		}
		System.out.println();
	}
}
