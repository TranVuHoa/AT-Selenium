package keywords;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Keywords {

	private WebDriver driver;
	private WebDriverWait wait;
	int timeout = 20;

	public Keywords(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	}

	public Keywords(WebDriver driver, int time) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(time));
	}
	public void openURL(String url) throws Exception {
		if (!(url.startsWith("http://") || url.startsWith("https://"))) {
			throw new Exception("Invalid URL format!");
		}
		driver.get(url);
	}

	public void clickElement(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}

	public String getTextElement(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
	}

	public void sendKeyElement(By locator, String text) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.clear();
		element.sendKeys(text);
	}

	public void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
