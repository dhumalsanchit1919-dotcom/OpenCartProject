package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import freemarker.template.SimpleDate;

import org.apache.logging.log4j.LogManager;   //log4j
import org.apache.logging.log4j.Logger;       //log4j


public class BaseTestClass {

	public static WebDriver driver;
	public Logger logger;
	public Properties  p;

	@Parameters({"browser" , "os"})
	@BeforeClass
	public void setup(String br , String op) throws IOException {
		
		logger = LogManager.getLogger(this.getClass());   //log4j2
		
		//loading values from config.properties files
		FileReader  myfile = new FileReader("C:\\Automation\\OpenCartProject\\src\\test\\resources\\config.properties");
		p = new Properties();
		p.load(myfile);
		
		/*
		 * //Selenium Grid if
		 * (p.getProperty("execution_env").equalsIgnoreCase("remote")) {
		 * 
		 * DesiredCapabilities cap = new DesiredCapabilities(); //os
		 * if(op.equalsIgnoreCase("Windows")) { cap.setPlatform(Platform.WIN11); } else
		 * if (op.equalsIgnoreCase("MAC")) { cap.setPlatform(Platform.MAC); } else {
		 * System.out.println(" Invalid Brower"); }
		 * 
		 * //browser switch(br.toLowerCase()) { case "chrome" :
		 * cap.setBrowserName("Chrome"); break; case "edge" :
		 * cap.setBrowserName("Edge"); break; default : System.out.println("Error");
		 * return; }
		 * 
		 * driver = new RemoteWebDriver(new URL("https://localhost:4444/") , cap); }
		 */
			
		if (p.getProperty("execution_env").equalsIgnoreCase("local")) {
		switch(br.toLowerCase()) {
		case "chrome" : driver = new ChromeDriver(); break;
		case "edge" : driver = new EdgeDriver(); break;
		default : System.out.println("Error"); return;
		}
		}
		
		///driver= new EdgeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		//driver.get("https://tutorialsninja.com/demo/");    ///normally		
		driver.get(p.getProperty("appUrl"));		
		driver.manage().window().maximize();
	
	}

	@AfterClass
	public void teardown() throws InterruptedException {
	Thread.sleep(3000);
	driver.quit();	
	}
	
	//random methods
		public String randomStrings() {
			
			String getrandomstring = RandomStringUtils.randomAlphabetic(5);
			return getrandomstring;
		}
		
	    public String randomnumbers() {
			
			String getrandomnum = RandomStringUtils.randomNumeric(10);
			return getrandomnum;
		}
		
	    public String alphanum() {
			
			String getalphanum = RandomStringUtils.randomAlphabetic(3);
			String getrandomnum = RandomStringUtils.randomNumeric(3);
			
			String alldata = getalphanum+"@"+getrandomnum;
			return alldata;
		}
	    
	    
	    
	    public String captureScreen(String repName) {
	    	
	    	//String timeStamp = new SimpleDateFormat("yyyy.mm.dd.MH.mm.ss").format(new Date());
	    	
	    	TakesScreenshot  tk =(TakesScreenshot) driver;
	    	
	    	File sourceFile = tk.getScreenshotAs(OutputType.FILE);
	    	
	    	String targetFilePath = System.getProperty("user.dir") + ".\\screenshots\\" +  repName + ".png";
	    	
	    	File targetFile = new File(targetFilePath) ;
	    	
	    	sourceFile.renameTo(targetFile);
	    		    	    	
	    	return targetFilePath;
	    }
	    
}
