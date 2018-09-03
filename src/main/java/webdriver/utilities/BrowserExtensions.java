package webdriver.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrowserExtensions {
	public static String getText(WebDriver driver, By elem){
		return driver.findElement(elem).getText();
	}

}
