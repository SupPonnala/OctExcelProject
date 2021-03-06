package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class CustomerSummaryPage extends BasePage {

	WebDriver driver;
	
	public CustomerSummaryPage(WebDriver driver) {
		this.driver = driver;
	}
	@FindBy(how = How.XPATH, using = "//*[@id=\"application_ajaxrender\"]/table[1]/thead/tr/th") WebElement ACCOUNT_SUMMARY_TEXT_LOCATOR;
	
	public void validateCustomerSummaryPage() {	
		waitForElement(driver, 3, ACCOUNT_SUMMARY_TEXT_LOCATOR);
		Assert.assertEquals(ACCOUNT_SUMMARY_TEXT_LOCATOR.getText(), "Accounting Summary", "Summary Page does not exist");	
	}
	
	
	
	
	
	
}
