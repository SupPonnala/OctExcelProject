package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {
	WebDriver driver;
	ExcelReader exlRead = new ExcelReader("src\\main\\java\\data\\TF_TestData.xlsx");
	String userName = exlRead.getCellData("Logininfo", "UserName", 2);
	String password = exlRead.getCellData("Logininfo", "Password", 2);
	
	@Test
	public void validUserShouldBeAbleToLogin() {
		driver = BrowserFactory.init();
		//cannot create object and instead we use PageFactory
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class );
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickSigninButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage();
		
		BrowserFactory.tearDown();
	}
	
	
	
}
