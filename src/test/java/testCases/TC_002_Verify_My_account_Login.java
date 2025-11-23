package testCases;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;   //log4j2
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.VarifyMyaccountPage;
import testBase.BaseTestClass;

public class TC_002_Verify_My_account_Login extends BaseTestClass {

		  
	@Test
	public void varifyMyAccountLogin() {
		
		try {
		logger.info("------------------Execution Started------------------");
		
		HomePage hp = new HomePage(driver);		
		logger.info("------Execution Started for 1st POM class-------");
		hp.myAccountclick();
		hp.loginClick();
		
		LoginPage lp = new LoginPage(driver);		
		logger.info("------Execution Started for 2nd POM class-------");
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("pass"));
		lp.clickLogin();
		
		VarifyMyaccountPage ma = new VarifyMyaccountPage(driver);		
		logger.info("------Execution Started for 3rd POM class-------");
		boolean  status = ma.checklogo();
		System.out.println(status);
		Assert.assertTrue(status);
		}
		catch(Exception e) {			
			logger.error("------Execution fail-------");
			Assert.fail();
		}
		
	}
	
}
