package testBase;



import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BAseTestClassPractice {
	
	public WebDriver  driver;
	public Logger logger;
	public Properties p ;
	
	@BeforeClass
	@Parameters({"brower"})
	public void setUp(String br) throws IOException {
		
		logger = LogManager.getLogger(this.getClass());
		
		
		  switch(br.toLowerCase()) {
		  
		  case "Chrome" : driver = new ChromeDriver(); break; 
		  case "Edge" : driver =   new EdgeDriver();    break; 
		  case "Firefox" : driver = new FirefoxDriver();   break;
		  default : System.out.println(" Error"); return ;
		  
		  }
		 
		
		FileReader file = new FileReader("C:\\Automation\\OpenCartProject\\src\\test\\resources\\config.properties");
		p = new Properties();
		p.load(file);
		
		//driver = new EdgeDriver();		
		driver.manage().deleteAllCookies();
		
		driver.get(p.getProperty("appUrl"));
		//driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
	
	
	public String randomStringFirstName() {
		String firstName = RandomStringUtils.randomAlphabetic(5);
		return (firstName);
	}
	
	public String randomStringlastName() {
		String lastName = RandomStringUtils.randomAlphabetic(5);
		return (lastName);
	}
		
	public String randomPassword() {
		String getalphanum = RandomStringUtils.randomAlphabetic(3);
		String getrandomnum = RandomStringUtils.randomNumeric(3);
		
		String alldata = getalphanum+"@"+getrandomnum;
		return alldata;
		
	}
	
	
}
