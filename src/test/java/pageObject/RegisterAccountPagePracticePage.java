package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterAccountPagePracticePage extends BasePage {
		 
	   public RegisterAccountPagePracticePage(WebDriver driver) {
			super(driver);
	   }
	  
	   // Elements
	 	@FindBy(xpath = "//input[@id='input-firstname']")
		WebElement txt_username;
		
		@FindBy(xpath = "//input[@id='input-lastname']")
		WebElement txt_lastname;
		
		@FindBy(xpath = "//input[@id='input-email']")
		WebElement txt_email;
		
		@FindBy(xpath = "//input[@id='input-telephone']")
		WebElement txt_telephone;
		
		@FindBy(xpath = "//input[@id='input-password']")
		WebElement txt_password;
		
		@FindBy(xpath = "//input[@id='input-confirm']")
		WebElement txt_confirmpass;
		
		@FindBy(xpath = "//input[@value='0']")
		WebElement btn_checked;
		
		@FindBy(xpath = "//input[@name='agree']")
		WebElement btn_agree;
		
		@FindBy(xpath = "//input[@class='btn btn-primary']")
		WebElement btn_continue;
		
		@FindBy(xpath = "//div[@id='content']//h1")
		WebElement msg_succes;
		
		@FindBy(xpath ="//div[@class='list-group']//a[13]")
		WebElement logout;
		
		@FindBy(xpath ="//div[@class='list-group']//a[2]")
		WebElement editDetails;
		
		//action methods
		
		public void setuserName(String username) {
			txt_username.sendKeys(username);
		}
		
		public void setlastName(String lastname) {
			txt_lastname.sendKeys(lastname);
		}
		
		public void setemails(String email) {
			txt_email.sendKeys(email);
		}
		
		public void setPhonenum(String phonenum) {
			txt_telephone.sendKeys(phonenum);
		}
		
		public void setpass(String pass) {
			txt_password.sendKeys(pass);
		}
		
		public void setConfirmPass(String confpass) {
			txt_confirmpass.sendKeys(confpass);
		}
		
		public void setradiobtn() {
			btn_checked.click();
		}
		
		public void setagree() {
			btn_agree.click();
		}
		
		public void clickcontinue() {
			btn_continue.click();
		}
		
		public String verifyStatusMsg() {			
			return (msg_succes.getText());
			//Your Account Has Been Created!
		}
		
		public void clickLogout() {
			logout.click();
		}
		
		public void clickEditDetails() {
			editDetails.click();
		}
}
