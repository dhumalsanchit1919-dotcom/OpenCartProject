package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.HomePagePractice;
import pageObject.RegisterAccountPagePracticePage;
import testBase.BAseTestClassPractice;

public class TC_001_Verify_Register_login_Practice extends BAseTestClassPractice {

	
	@Test
	public void verifyAccountStatus() throws InterruptedException {
		
		try {
	
		logger.info("Execution is started");
		//1 page
		HomePagePractice  hp = new HomePagePractice(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		logger.info("Execution is 111");
		//2 page
		RegisterAccountPagePracticePage  rp = new RegisterAccountPagePracticePage(driver);
		Thread.sleep(3000);
		rp.setuserName(randomStringFirstName());
		rp.setlastName(randomStringlastName());
		rp.setemails(randomStringFirstName() + "@gmail.com");
		rp.setPhonenum("1234567899");
		
	    logger.info("Execution is 2222");
		String pass = randomPassword();
		rp.setpass(pass);
		rp.setConfirmPass(pass);
				
		rp.setagree();
		rp.clickcontinue();
		logger.info("Execution is 3333");
		String status = rp.verifyStatusMsg();
		if(status.equalsIgnoreCase("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
			logger.info("Execution is Completed");
			
		}
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
}
