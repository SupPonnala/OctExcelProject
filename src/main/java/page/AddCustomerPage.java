package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class AddCustomerPage extends BasePage{
	WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}
	// Element Library
	@FindBy(how = How.XPATH, using = "//input[@id='account']")
	WebElement FULLNAME_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//select[@id='cid']")
	WebElement COMPANY_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//input[@id='email']")
	WebElement EMAIL_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//input[@id='phone']")
	WebElement PHONE_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//input[@id='address']")
	WebElement ADDRESS_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"city\"]")
	WebElement CITY_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"state\"]")
	WebElement STATE_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"zip\"]")
	WebElement ZIP_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"country\"]")
	WebElement COUNTRY_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"submit\"]")
	WebElement SAVE_BUTTON_LOCATOR;

	// interactive Methods
	String enteredName;
	public void insertFullName(String fullName) {
		int generatedNumber = randomGenerator(999);
		String enteredName = fullName + generatedNumber;
		FULLNAME_FIELD_LOCATOR.sendKeys(enteredName);
	}
	public void chooseCompanyOption(String company) {
		selectDropDown(COMPANY_FIELD_LOCATOR, company);
	}

	public void insertEmailAddress(String email) {
		int generatedNumber = randomGenerator(999);
		EMAIL_FIELD_LOCATOR.sendKeys(generatedNumber + email);
	}

	public void insertPhoneNumber(String phone ) {
		int generatedNumber = randomGenerator(999);
		PHONE_FIELD_LOCATOR.sendKeys(generatedNumber + phone);
	}
	public void insertAddress(String address ) {
		ADDRESS_FIELD_LOCATOR.sendKeys(address);
	}
	public void insertCity(String city) {
		CITY_FIELD_LOCATOR.sendKeys(city);
	}
	public void insertState(String state) {
		STATE_FIELD_LOCATOR.sendKeys(state);
	}
	public void insertZip(String zip) {
		ZIP_FIELD_LOCATOR.sendKeys(zip);
	}
	public void chooseCountryOption(String country) {
		selectDropDown(COUNTRY_FIELD_LOCATOR, country);
	}
	
	public void clickSaveButton() {
		SAVE_BUTTON_LOCATOR.click();
	}
	
	public void verifyEnteredName() {
		String before_xpath = "//tbody/tr[";
		String after_xpath = "]/td[3]";
		
		for(int i = 1; i<=10; i++) {
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println(name);
			Assert.assertEquals(name, enteredName, "Entered name does not exist");
		}
		
		
	}
	
	
	
}
