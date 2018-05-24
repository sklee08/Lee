package ATM;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class ATMtesting {

	@Test
	public void testGetMenu_1() {
		ATM test = new ATM();
		int t = 1;
		int tes = test.getMenu();
		assertEquals(tes,t);
	}

	@Test
	public void testGetAccount() {
		ATM test = new ATM();
		String account = "940621";
		String test_acc = test.getAccount();
		assertEquals(account, test_acc);
	}

	@Test
	public void testGetTransferAccount() {
		ATM test = new ATM();
		String account = "940621";
		String test_acc = test.getTransferAccount();
		assertEquals(account, test_acc);
	}

	@Test
	public void testGetAmount() {
		ATM test = new ATM();
		int amount = 20000;
		int test_amount = test.getAmount();
		assertEquals(amount, test_amount);
	}

	@Test
	public void testCheckAmountError() {	// 20000원을 넣었을 때 오류가 안뜨는지 확인
		ATM test = new ATM();
		boolean isRight;
		int amount = 20000;
		isRight = test.checkAmountError(amount);
		assertEquals(isRight, true);
	}

	@Test
	public void testGetPw() {
		ATM test = new ATM();
		String pw = "4839";
		String test_pw = test.getPw();
		assertEquals(pw, test_pw);
	}

	@Test
	public void testGetAdminAccount() {
		ATM test = new ATM();
		String id = "sklee08";
		String test_id = test.getAdminAccount();
		assertEquals(id, test_id);
	}

	@Test
	public void testGetAdminPw() {
		ATM test = new ATM();
		int pw = 1234;
		int test_pw = test.getAdminPw();
		assertEquals(pw, test_pw);
	}

	@Test
	public void testGetAdminMenu() {
		ATM test = new ATM();
		int menu = 1;
		int test_menu = test.getAdminMenu();
		assertEquals(menu, test_menu);
	}

	@Test
	public void testGetCashAmount() {
		ATM test = new ATM();
		int camount = 20000;
		int test_camount = test.getCashAmount();
		assertEquals(camount, test_camount);
	}

	@Test
	public void testGetRobberyAccount() {
		ATM test = new ATM();
		String raccount = "940621";
		String test_raccount = test.getRobberyAccount();
		assertEquals(raccount, test_raccount);
	}

	@Test
	public void testGetRobberyPw() {
		ATM test = new ATM();
		String rpw = "4839";
		String test_rpw = test.getRobberyPw();
		assertEquals(rpw, test_rpw);
	}

	@Test
	public void testCalculate() throws IOException {
		ATM test = new ATM();
		String account = "940621";
		int amount = 20000;
		User_Data d = test.find(account);
		boolean isCal = test.calculate(d, amount);
		assertEquals(isCal, true);
	}

	@Test
	public void testFind() throws IOException {
		ATM test = new ATM();
		String account = "940621";
		User_Data d = test.find(account);
		assertEquals(account,d.getAccountNum());
	}

}
