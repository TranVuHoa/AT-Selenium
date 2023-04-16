package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import keywords.Keywords;

public class AdminPage extends BasePage {

	public AdminPage(WebDriver driver, ExtentTest test) {
		super(driver);
		this.test = test;
		this.keywords = new Keywords(driver);
	}

	By createAdmin = By.cssSelector(".orangehrm-header-container button");

	By userRoleSelect = By
			.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters'][1]//div[@class='oxd-select-wrapper']");
	By adminOption = By.xpath("//div[@role='listbox']//div[@role='option'][2]");
	By essOption = By.xpath("//div[@role='listbox']//div[@role='option'][3]");

	By employeeNameText = By.xpath("//input[@placeholder='Type for hints...']");
	By employeeOption = By.xpath("//div[@role='listbox']//div[@role='option']");

	By statusSelect = By
			.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters'][3]//div[@class='oxd-select-wrapper']");
	By enabledOption = By.xpath("//div[@role='listbox']//div[@role='option'][2]");
	By disabledOption = By.xpath("//div[@role='listbox']//div[@role='option'][3]");

	By usernameText = By.xpath("//div[@class='oxd-form-row']//input[@autocomplete='off']");
	By passwordText = By.xpath("(//input[@type='password'])[1]");
	By confirmPasswordText = By.xpath("(//input[@type='password'])[2]");
	By saveButton = By.xpath("//button[normalize-space()='Save']");

	By userRoleSelectError = By.xpath("//div[@class='oxd-form-row']//div//div[1]//div//span");
	By employeeNameError = By.xpath("//div[@class='oxd-form-row']//div//div[2]//div//span");
	By statusError = By.xpath("//div[@class='oxd-form-row']//div//div[3]//div//span");
	By usernameError = By.xpath("//div[@class='oxd-form-row']//div//div[4]//div//span");
	By passwordError = By.xpath("//div[@class='oxd-form-row user-password-row']//div//div[1]//div//span");
	By confirmPasswordError = By.xpath("//div[@class='oxd-form-row user-password-row']//div//div[2]//div//span");

	public void clickCreateAdmin() throws Exception {
		try {
			keywords.clickElement(createAdmin);
			test.pass("Clicked on Create Button!");
		} catch (Exception e) {
			test.fail("Time out! Not found Create Admin Button!");
			throw new Exception("Time out! Not found Create Admin Button!");
		}
	}

	public void fillForm(String userRole, String employeeName, String status, String username, String password,
			String confirmPassword) throws Exception {
		try {
			keywords.clickElement(userRoleSelect);
			test.pass("Clicked on User Role Select!");
			if (userRole.equals("Admin")) {
				try {
					keywords.clickElement(adminOption);
					test.pass("Clicked on Admin Option!");
				} catch (Exception e) {
					test.fail("Time out! Not found Admin Option!");
					throw new Exception("Time out! Not found Admin Option!");
				}
			} else if (userRole.equals("ESS")) {
				try {
					keywords.clickElement(essOption);
					test.pass("Clicked on ESS Option!");
				} catch (Exception e) {
					test.fail("Time out! Not found ESS Option!");
					throw new Exception("Time out! Not found ESS Option!");
				}
			}
		} catch (Exception e) {
			test.fail("Time out! Not found User Role Select!");
			throw new Exception("Time out! Not found User Role Select!");
		}

		try {
			keywords.sendKeyElement(employeeNameText, employeeName);
			test.pass("Entered text in Employee Name Field!");
			keywords.sleep(2000);
			if (employeeName != "") {
				try {
					keywords.clickElement(employeeOption);
					test.pass("Clicked on Employee Option!");
				} catch (Exception e) {
					test.fail("Time out! Not found Employee Option!");
					throw new Exception("Time out! Not found Employee Option!");
				}
			}
		} catch (Exception e) {
			test.fail("Time out! Not found Employee Name Field!");
			throw new Exception("Time out! Not found Employee Name Field!");
		}

		try {
			keywords.clickElement(statusSelect);
			test.pass("Clicked on Status Select!");
			if (status.equals("Enabled")) {
				try {
					keywords.clickElement(enabledOption);
					test.pass("Clicked on Enabled Option!");
				} catch (Exception e) {
					test.fail("Time out! Not found Enabled Option!");
					throw new Exception("Time out! Not found Enabled Option!");
				}
			} else if (status.equals("Disabled")) {
				try {
					keywords.clickElement(disabledOption);
					test.pass("Clicked on Disabled Option!");
				} catch (Exception e) {
					test.fail("Time out! Not found Disabled Option!");
					throw new Exception("Time out! Not found Disabled Option!");
				}
			}
		} catch (Exception e) {
			test.fail("Time out! Not found Status Select!");
			throw new Exception("Time out! Not found Status Select!");
		}

		try {
			keywords.sendKeyElement(usernameText, username);
			test.pass("Entered text in Username Field!");
		} catch (Exception e) {
			test.fail("Time out! Not found Username Field!");
			throw new Exception("Time out! Not found Username Field!");
		}

		try {
			keywords.sendKeyElement(passwordText, password);
			test.pass("Entered text in Password Field!");
		} catch (Exception e) {
			test.fail("Time out! Not found Password Field!");
			throw new Exception("Time out! Not found Password Field!");
		}

		try {
			keywords.sendKeyElement(confirmPasswordText, confirmPassword);
			test.pass("Entered text in Confirm Password Field!");
		} catch (Exception e) {
			test.fail("Time out! Not found Confirm Password Field!");
			throw new Exception("Time out! Not found Confirm Password Field!");
		}
		keywords.sleep(1000);
	}

	public void clickSubmit() throws Exception {
		try {
			keywords.clickElement(saveButton);
			test.pass("Clicked on Save Button!");
		} catch (Exception e) {
			test.fail("Time out! Not found Save Admin Button!");
			throw new Exception("Time out! Not found Save Admin Button!");
		}
	}

	public void checkResult(String userRole, String employeeName, String status, String username, String password,
			String confirmPassword) {
		Keywords keywordError = new Keywords(driver, 1);
		String userRoleMessageError = null;
		String employeeNameMessageError = null;
		String statusMessageError = null;
		String usernameMessageError = null;
		String passwordMessageError = null;
		String confirmPasswordMessageError = null;
		String buttonText = null;

		try {
			userRoleMessageError = keywordError.getTextElement(userRoleSelectError);
		} catch (TimeoutException e1) {
			try {
				employeeNameMessageError = keywordError.getTextElement(employeeNameError);
			} catch (TimeoutException e2) {
				try {
					statusMessageError = keywordError.getTextElement(statusError);
				} catch (TimeoutException e3) {
					try {
						usernameMessageError = keywordError.getTextElement(usernameError);
					} catch (TimeoutException e4) {
						try {
							passwordMessageError = keywordError.getTextElement(passwordError);
						} catch (TimeoutException e5) {
							try {
								confirmPasswordMessageError = keywordError.getTextElement(confirmPasswordError);
							} catch (TimeoutException e6) {
								try {
									buttonText = keywordError.getTextElement(createAdmin);
								} catch (TimeoutException e7) {
								}
							}
						}
					}
				}
			}
		}

		if (userRoleMessageError != null && userRole == "") {
			Assert.assertEquals(userRoleMessageError, "Required");
		} else if (employeeNameMessageError != null && employeeName == "") {
			Assert.assertEquals(employeeNameMessageError, "Required");
		} else if (employeeNameMessageError != null && employeeName != "") {
			Assert.assertEquals(employeeNameMessageError, "Invalid");
		} else if (statusMessageError != null && status == "") {
			Assert.assertEquals(statusMessageError, "Required");
		} else if (usernameMessageError != null && username == "") {
			Assert.assertEquals(usernameMessageError, "Required");
		} else if (usernameMessageError != null && username != "") {
			if (username.length() < 5) {
				Assert.assertEquals(usernameMessageError, "Should be at least 5 characters");
			} else {
				Assert.assertEquals(usernameMessageError, "Already exists");
			}
		} else if (passwordMessageError != null && password == "") {
			Assert.assertEquals(passwordMessageError, "Required");
		} else if (passwordMessageError != null && password.length() < 8) {
			Assert.assertEquals(passwordMessageError, "Should have at least 8 characters");
		} else if (passwordMessageError != null
				&& !password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\\\d)(?=.*[@$!%*?&])[A-Za-z\\\\d@$!%*?&]{8,}$")) {
			Assert.assertEquals(passwordMessageError,
					"Your password must contain a lower-case letter, an upper-case letter, a digit and a special character. Try a different password");
		} else if (confirmPasswordMessageError != null && confirmPassword == "") {
			Assert.assertEquals(confirmPasswordMessageError, "Required");
		} else if (confirmPasswordMessageError != null && confirmPassword != password) {
			Assert.assertEquals(confirmPasswordMessageError, "Passwords do not match");
		} else {
			Assert.assertEquals(buttonText, "Add");
		}
	}

}
