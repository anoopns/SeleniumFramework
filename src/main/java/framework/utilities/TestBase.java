package framework.utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.apache.commons.io.FileUtils;

public class TestBase {

	public static WebDriver driver = null;

	@BeforeClass
	@Parameters({"browser", "url"})
	public void runBeforeClass(String browser, String url){
		setDriver(browser);
		this.driver.manage().window().maximize();
		this.driver.navigate().to(url);
	}
	


	private WebDriver setDriver(String browser) {
		this.driver = BrowserFactory.getBrowser(browser);
 		return this.driver;
	}

	@AfterClass()
	public void AfterClass(){
		this.driver.close();
	}
	
	public void goToHomePage(String url){
		this.driver.navigate().to(url);
	}
	
	public void takeScreenShotOnFailure(ITestResult result, String screenShotLocation){
		TakesScreenshot screenShot = (TakesScreenshot)this.driver;
		File src = screenShot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File(screenShotLocation + result.getName() + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
