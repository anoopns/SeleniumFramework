package framework.project;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;

public class TestBase {

	private WebDriver driver = null;


	public WebDriver getDriver(String browser, String url) {
		 driver = BrowserFactory.getBrowser(browser);
 		return driver;
	}

	@AfterClass(alwaysRun=true)
	public void AfterClass(){
		driver.quit();
	}

}
