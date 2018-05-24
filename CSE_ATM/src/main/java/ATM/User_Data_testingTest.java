package ATM;

import static org.junit.Assert.*;

import org.junit.Test;

public class User_Data_testingTest {

	
	@Test
	public void testCheckAccountPw() {
		User_Data test = new User_Data("940621", "4839",null,null,null);
		String account = "940621";
		String pw = "4839";
		boolean isCheck = test.checkAccountPw(account, pw);
		assertEquals(true, isCheck);
	}

	@Test
	public void testCheckBank() {
		User_Data test = new User_Data(null, null,"±¹¹Î",null,null);
		String bank = "±¹¹Î";
		boolean isCheck = test.checkBank(bank);
		assertEquals(true, isCheck);
	}

	

}
