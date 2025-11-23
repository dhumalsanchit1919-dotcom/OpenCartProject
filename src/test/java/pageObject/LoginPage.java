package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	//Constructor
		public LoginPage (WebDriver driver){
			super(driver);
		}
		
    //Elements
		
		@FindBy(xpath="//input[@id='input-email']")
		WebElement txt_email;
		
		@FindBy(xpath = "//input[@id='input-password']")
		WebElement txt_pass;
		
		@FindBy(xpath = "//input[@value='Login']")
		WebElement btn_login;
		
		
		@FindBy(xpath = "//input[@id='input-telephone']")
		WebElement changeNumber ;
		
		@FindBy(xpath = "//input[@value='Continue']")
		WebElement btncontinew ;
		
		
		
        //Action Method
		
		public void setEmail(String email) {
			txt_email.sendKeys(email);
		}
		
		
		public void setPassword(String pass) {
			txt_pass.sendKeys(pass);
		}
		
		public void clickLogin() {
			btn_login.click();
		}
		
		public void changeNumber(String number) {
			changeNumber.clear();
			changeNumber.sendKeys(number);
			
		}
		
		public void clickContinew() {
			btncontinew.click();
		}
		
}
