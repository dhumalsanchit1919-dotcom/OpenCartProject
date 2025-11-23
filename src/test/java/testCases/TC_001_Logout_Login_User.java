package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePagePractice;
import pageObject.LoginPage;
import pageObject.RegisterAccountPagePracticePage;
import testBase.BAseTestClassPractice;
import utilities.DataProviders;

public class TC_001_Logout_Login_User extends BAseTestClassPractice{
	
	
	
	@Test(dataProvider = "LoginData")
	public void verifyLogoutLogin(String Email , String Password) throws InterruptedException{
		
		try {
			
			/*
			 * TC_001_Verify_Register_login_Practice lp1 = new
			 * TC_001_Verify_Register_login_Practice(); lp1.verifyAccountStatus();
			 */
	    	
			/*
			 * HomePagePractice hp = new HomePagePractice(driver); hp.clickMyAccount();
			 * hp.clickRegister(); //logger.info("Execution is 111"); //2 page
			 * RegisterAccountPagePracticePage rp = new
			 * RegisterAccountPagePracticePage(driver); Thread.sleep(3000);
			 * rp.setuserName(randomStringFirstName());
			 * rp.setlastName(randomStringlastName());
			 * 
			 * String email = randomStringFirstName() + "@gmail.com"; rp.setemails(email);
			 * rp.setPhonenum("1234567899");
			 * 
			 * //zlogger.info("Execution is 2222"); String pass = randomPassword();
			 * rp.setpass(pass); rp.setConfirmPass(pass);
			 * 
			 * rp.setagree(); rp.clickcontinue(); //logger.info("Execution is 3333"); String
			 * status = rp.verifyStatusMsg();
			 * if(status.equalsIgnoreCase("Your Account Has Been Created!")) {
			 * Assert.assertTrue(true); //logger.info("Execution is Completed");
			 * 
			 * }
			 */
		
		//2 register page
		
		  RegisterAccountPagePracticePage rp = new RegisterAccountPagePracticePage(driver); 
			/*
			 * Thread.sleep(3000); rp.clickLogout();
			 */
		 
		//1 home page
		
		  HomePagePractice hp = new HomePagePractice(driver); 
		  hp.clickMyAccount();
		  hp.clickLogin();
		  
		  //3 login page 
		  LoginPage lp = new LoginPage(driver); 
		  Thread.sleep(3000);
		  lp.setEmail(Email); 
		  lp.setPassword(Password); 
		  lp.clickLogin();
		  
		  
		  //again 2 page 
		  rp.clickEditDetails(); 
		  Thread.sleep(3000);
		  lp.changeNumber("999999999");
		  lp.clickContinew();
		  
		  rp.clickLogout();
		 
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

	
	

}
