package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.CustomerSummaryPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomerTest {
	
	WebDriver driver;
	
	ExcelReader exlRead = new ExcelReader("src\\main\\java\\data\\TF_TestData.xlsx");
	String userName = exlRead.getCellData("Logininfo", "UserName", 2);
	String password = exlRead.getCellData("Logininfo", "Password", 2);
	
	String fullName = exlRead.getCellData("Addcontactinfo", "FullName", 2);
	String company = exlRead.getCellData("Addcontactinfo", "CompanyName", 2);
	String email = exlRead.getCellData("Addcontactinfo", "Email", 2);
	String phone = exlRead.getCellData("Addcontactinfo", "Phone", 2);
	String address = exlRead.getCellData("Addcontactinfo", "Address", 2);
	String city = exlRead.getCellData("Addcontactinfo", "City", 2);
	String state = exlRead.getCellData("Addcontactinfo", "State", 2);
	String zip = exlRead.getCellData("Addcontactinfo", "Zip", 2);
	String country = exlRead.getCellData("Addcontactinfo", "Country", 2);
	
	
	@Test
	public void validUserShouldBeAbleToAddCustomer() {
		driver = BrowserFactory.init();
		//cannot create object and instead use PageFactory
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class );
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickSigninButton();
		
		// to validate if it landed on dashboard page
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage();
		dashboardPage.clickCustomerButtom();
		dashboardPage.clickAddCustomerButtom();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.insertFullName(fullName);
		addCustomerPage.chooseCompanyOption(company);
		addCustomerPage.insertEmailAddress(email);
		addCustomerPage.insertPhoneNumber(phone);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertState(state);
		addCustomerPage.insertZip(zip);
		addCustomerPage.chooseCountryOption(country);
		addCustomerPage.clickSaveButton();
		
		CustomerSummaryPage customerSummaryPage  = PageFactory.initElements(driver, CustomerSummaryPage.class);
		customerSummaryPage.validateCustomerSummaryPage();
		
		dashboardPage.clickListCustomerButtom();
		addCustomerPage.verifyEnteredName();
		
		//BrowserFactory.tearDown();
		
		
	}
		
	}


