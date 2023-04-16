package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import pages.AdminPage;
import pages.DashboardPage;
import pages.LoginPage;
import utils.ExcelUtils;

public class AdminTest extends BaseTest {
	
	private ExtentTest testAdmin;
	private AdminPage adminPage;
	private LoginPage loginPage;
	private DashboardPage dashboardPage;

	public void preCondition() throws Exception {
		testAdmin = report.createTest("My Tests: Admin", "This test reports creating Admin function!");
		adminPage = new AdminPage(driver, testAdmin);
		
		loginPage = new LoginPage(driver, testAdmin);
		dashboardPage = new DashboardPage(driver, testAdmin);
		
		keywords.openURL(baseURL);
		testAdmin.pass("Navigate to Base URL");
		loginPage.login();
		testAdmin.pass("Login Pass");
	}

	@Test(dataProvider = "admin")
	public void createAdmin(String userRole, String employeeName, String status, String username, String password,
			String confirmPassword) throws Exception {
		preCondition();
		dashboardPage.clickAdmin();
		adminPage.clickCreateAdmin();
		adminPage.fillForm(userRole, employeeName, status, username, password, confirmPassword);
		adminPage.clickSubmit();
		try {
			adminPage.checkResult(userRole, employeeName, status, username, password, confirmPassword);
			testAdmin.pass("Testcase Pass!");
		} catch (Exception e) {
			testAdmin.pass("Testcase Fail!");
			throw new Exception("Testcase Fail!");
		}

	}

	@DataProvider(name = "admin")
	public Object[][] dataAdmin() {
		String excelPath = "./src/test/resources/DataInput/DataOrange.xlsx";
		String sheetName = "Data_Admin";
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		int rowCount = excel.getRowCount() - 2;
		int colCount = excel.getColCount() - 1;
		Object[][] data = new Object[colCount][rowCount];
		for (int i = 0; i < colCount; i++) {
			for (int j = 0; j < rowCount; j++) {
				data[i][j] = excel.getCellData(j + 1, i + 1);
			}
		}
		return data;
	}
}
