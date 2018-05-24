package ATM;

import java.util.Scanner;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		int buttonIndex = 1;

		Admin admin = new Admin();

		while (buttonIndex != 0) {
			buttonIndex = ATM.getMenu();

			if (buttonIndex == 1) // 입금
			{
				ATM.deposit(admin);
			} else if (buttonIndex == 2) // 출금
			{
				ATM.withdraw(admin);
			} else if (buttonIndex == 3) // 계좌정보 확인
			{
				ATM.checkBalance();

			} else if (buttonIndex == 4) // 계좌 이체
			{
				ATM.transfer(admin);
			} else if (buttonIndex == 5) // 관리자 모드
			{
				ATM.changeAdmin(admin);
			} else if (buttonIndex == 6) // 도난 신고
			{
				ATM.robberyreport();

			} else // gui에서 exit버튼이 눌렸을 때
			{
				System.out.println("exit the ATM...");
				break;
			}

		}

		System.out.println("Finished!");
	}

}
