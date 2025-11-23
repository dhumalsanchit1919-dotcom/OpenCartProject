package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.RegisterAccountPage;
import testBase.BaseTestClass;

public class TC_001_Verify_Acc_Status extends BaseTestClass {

	@Test
	public void verify_account_status() throws InterruptedException {
		
		try {
		logger.info("Execution Start");
		HomePage hp  = new HomePage(driver);
		hp.myAccountclick();
		hp.registerclick();
		logger.info("Execution Click");
		Thread.sleep(3000);
				
		RegisterAccountPage rp = new RegisterAccountPage(driver);
		rp.setuserName(randomStrings().toUpperCase());
		rp.setlastName(randomStrings().toUpperCase());
		rp.setemails(randomStrings()+"@gmail.com");
		rp.setPhonenum(randomnumbers());
				
		String password = alphanum();
		rp.setpass(password);
		rp.setConfirmPass(password);
		
		rp.setradiobtn();
		rp.setagree();
		rp.clickcontinue();
		
		logger.info("Execution complete only validation");
		
		 String msg = rp.getsuccessmsg();
		 Assert.assertEquals(msg, "Your Account Has Been Created!");	
		 
		 logger.info("Finish");
		}
		
		catch(Exception e) {
			logger.error("Fail");
			logger.debug("Fail!!!!!");
		}
	}
	
	
	
}
