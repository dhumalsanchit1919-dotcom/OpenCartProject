package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePagePractice extends BasePage {


	public HomePagePractice(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath = "//a[@class='dropdown-toggle']//span[1]")
	WebElement myAccount;
	
	
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//li[1]")
	WebElement register;
	
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//li[2]")
	WebElement login;
	
	
	
	
	public void clickMyAccount() {
		myAccount.click();
	}
	
	public void clickRegister() {
		register.click();
	}
	
	public void clickLogin() {
		login.click();
	}


}
