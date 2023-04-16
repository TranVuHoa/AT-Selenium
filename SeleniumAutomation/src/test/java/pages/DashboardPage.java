package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import keywords.Keywords;

public class DashboardPage extends BasePage {

	public DashboardPage(WebDriver driver, ExtentTest test) {
		super(driver);
		this.test = test;
		this.keywords = new Keywords(driver);
	}

	By AdminButton = By.partialLinkText("Admin");

	public void clickAdmin() throws Exception {
		try {
			keywords.clickElement(AdminButton);
			test.pass("Clicked on Admin Button");
		} catch (Exception e) {
			test.fail("Time out! Not found Admin Button!");
			throw new Exception("Time out! Not found Admin Button!");
		}
	
	}
}
