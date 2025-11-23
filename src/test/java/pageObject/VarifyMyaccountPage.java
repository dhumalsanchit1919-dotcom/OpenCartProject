package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VarifyMyaccountPage extends BasePage{

	//Constructor
	public VarifyMyaccountPage(WebDriver driver){
		 super(driver);
	 }
	
	//Element
    @FindBy(xpath = "//h2[text() ='My Account']")
    WebElement my_account;
    
	//action methods
    public boolean  checklogo() {
    	try {    		
         return(my_account.isDisplayed());
        } 
    	
    	catch(Exception e) {
    		return false;		
    	 }
    }
	
}
