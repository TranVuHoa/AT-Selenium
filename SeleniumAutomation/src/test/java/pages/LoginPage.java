package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import keywords.Keywords;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver, ExtentTest test) {
		super(driver);
		this.test = test;
		this.keywords = new Keywords(driver);
	}

	By usernameText = By.cssSelector("input[name='username']");
	By passwordText = By.cssSelector("input[name='password']");
	By loginButton = By.cssSelector("button[type='submit']");
	By userText = By.cssSelector(".orangehrm-login-form p:nth-child(1)");
	By passText = By.cssSelector(".orangehrm-login-form p:nth-child(2)");

	public String getUser() {
		return keywords.getTextElement(userText).substring(11);
	}

	public String getPass() {
		return keywords.getTextElement(passText).substring(11);
	}

	public void login() throws Exception {
		try {
			keywords.sendKeyElement(usernameText, getUser());
			test.pass("Entered text in Username Field!");
		} catch (Exception e) {
			test.fail("Time out! Not found Username Field!");
			throw new Exception("Time out! Not found Username Field!");
		}
		try {
			keywords.sendKeyElement(passwordText, getPass());
			test.pass("Entered text in Password Field");
		} catch (Exception e) {
			test.fail("Time out! Not found Password Field!");
			throw new Exception("Time out! Not found Username Field!");
		}
		try {
			keywords.clickElement(loginButton);
			test.pass("Clicked on Login Button");
		} catch (Exception e) {
			test.fail("Time out! Not found Login Button!");
			throw new Exception("Time out! Not found Username Field!");
		}
	}
}
