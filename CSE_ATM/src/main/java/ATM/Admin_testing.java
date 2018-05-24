package ATM;

import static org.junit.Assert.*;

import org.junit.Test;

public class Admin_testing {

	@Test
	public void testAdmin_cash() {
		Admin test = new Admin();
		boolean cashCheck;
		if(test.getAdminCash() == 5000000)
		{
			cashCheck = true;
		}
		else
			cashCheck = false;
		assertEquals(true, cashCheck);
	}
	
	@Test
	public void testCheckAdminID() {
		Admin test = new Admin();
		boolean idCheck = test.CheckAdminID("sklee08");
		assertEquals(true, idCheck);
	}

	@Test
	public void testCheckAdminPW() {
		Admin test = new Admin();
		boolean pwCheck = test.CheckAdminPW(1234);
		assertEquals(true, pwCheck);
	}

	@Test
	public void testAdminCalculate() {
		Admin test = new Admin();
		test.AdminCalculate(200000);
		assertEquals(5200000, test.getAdminCash());
	}

	@Test
	public void testGetAdminCash() {
		Admin test = new Admin();
		int test_cash = test.getAdminCash();
		assertEquals(test_cash, 5000000);
	}

}
