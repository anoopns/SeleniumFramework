package framework.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	
	public static WebDriver getBrowser(String sBrowserName)
	{
		WebDriver driver = null;
		switch (sBrowserName.toLowerCase()) {
		case "chrome":
			//System.setProperty("webdriver.chrome.driver", "Drivers//chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			//System.setProperty("webdriver.gecko.driver", "Drivers//geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();;
			break;

		default:
			break;
		}
		return driver;
	}

}
