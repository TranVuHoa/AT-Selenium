package tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import pages.LoginPage;

public class LoginTest extends BaseTest {

	private ExtentTest testLogin;

	@Test
	public void login() throws Exception {
		testLogin = report.createTest("First Test: Login", "This test reports on Login Page!");
		LoginPage loginPage = new LoginPage(driver, testLogin);

		testLogin.info("Starting Login Test");
		keywords.openURL(baseURL);
		testLogin.pass("Navigate to Base URL");
		loginPage.login();
		testLogin.pass("Login Pass");
	}

}
