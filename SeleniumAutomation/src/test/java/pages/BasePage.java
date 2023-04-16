package pages;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import keywords.Keywords;

public class BasePage {
	public ExtentTest test;
	
	public WebDriver driver;

	public Keywords keywords;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

}
