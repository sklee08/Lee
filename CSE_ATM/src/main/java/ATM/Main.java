package ATM;

import java.util.Scanner;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		int buttonIndex = 1;

		Admin admin = new Admin();

		while (buttonIndex != 0) {
			buttonIndex = ATM.getMenu();

			if (buttonIndex == 1) // �Ա�
			{
				ATM.deposit(admin);
			} else if (buttonIndex == 2) // ���
			{
				ATM.withdraw(admin);
			} else if (buttonIndex == 3) // �������� Ȯ��
			{
				ATM.checkBalance();

			} else if (buttonIndex == 4) // ���� ��ü
			{
				ATM.transfer(admin);
			} else if (buttonIndex == 5) // ������ ���
			{
				ATM.changeAdmin(admin);
			} else if (buttonIndex == 6) // ���� �Ű�
			{
				ATM.robberyreport();

			} else // gui���� exit��ư�� ������ ��
			{
				System.out.println("exit the ATM...");
				break;
			}

		}

		System.out.println("Finished!");
	}

}
