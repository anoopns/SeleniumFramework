package webdriver.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
	
	public static Boolean ForElementToBeVisible(WebDriver driver, By locator, int timeOut){
		driver.getCurrentUrl();
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator)).isDisplayed();
	}

	public static WebElement ForElementToBeClickable(WebDriver driver, By locator, int timeOut){
		driver.getCurrentUrl();
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
}
