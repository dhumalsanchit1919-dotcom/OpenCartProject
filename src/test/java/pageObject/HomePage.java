package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{
	
	//Constructor
	public HomePage (WebDriver driver){
		super(driver);
	}
	
	///Elements
	@FindBy(xpath = "//span[normalize-space()=\"My Account\"]")
	WebElement btn_my_acc;
	
	@FindBy(xpath = "//a[normalize-space()=\"Register\"]")
	WebElement btn_register;
	
	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement btn_login;
	
	//Action methods
	public void myAccountclick() {
		btn_my_acc.click();
	}
	
	public void registerclick() {
		btn_register.click();
	}
	
	public void loginClick() {
		btn_login.click();
	}
	

}
