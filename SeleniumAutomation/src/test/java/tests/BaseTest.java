package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import keywords.Keywords;

public class BaseTest {

	public static ExtentReports report;

	public WebDriver driver;

	public Keywords keywords;

	public String baseURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

	@BeforeSuite
	public void start() {
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(
				"./src/test/resources/DataOutput/Reports/reports.html");
		sparkReport.config().setDocumentTitle("TVH's Reports");

		report = new ExtentReports();
		report.attachReporter(sparkReport);
	}
	
	@BeforeMethod
	public void setup() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

		this.keywords = new Keywords(driver);

	}

	public WebDriver getDriver() {
		return driver;
	}

	@AfterMethod
	public void teardown() throws InterruptedException {
		driver.close();
		driver.quit();
	}
	
	@AfterSuite
	public void end() {
		report.flush();
	}
}
