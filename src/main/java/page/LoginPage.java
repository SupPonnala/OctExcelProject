package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage{
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver; //this keyword is used to make sure the driver is same
	}
	
	//Element library - cannot use find by web element or by class
	@FindBy(how=How.XPATH, using="//input[@id='username']")WebElement USERNAME_FIELD;
	@FindBy(how=How.XPATH, using="//input[@id='password']")WebElement PASSWORD_FIELD;
	@FindBy(how=How.XPATH, using="//button[@name='login']")WebElement SIGNIN_BUTTON;

	
	//Interactive Methods - 2 methods available
	//1st method - create method using parameterization so the user can put in the data.
	public void insertUserName(String userName) {
		 USERNAME_FIELD.sendKeys(userName);	 
	}
	public void insertPassword(String password) {
		 PASSWORD_FIELD.sendKeys(password);	 
	}
	public void clickSigninButton() {
		SIGNIN_BUTTON.click(); 
	}
	//2nd method 
	public void SigninOperation(String userName, String password) {
		USERNAME_FIELD.sendKeys(userName);
		PASSWORD_FIELD.sendKeys(password);
		SIGNIN_BUTTON.click();
		
	}
	
}


