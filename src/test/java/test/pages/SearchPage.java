package test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import webdriver.utilities.BrowserExtensions;
import webdriver.utilities.Wait;
import framework.utilities.TestBase;

public class SearchPage extends TestBase{
	WebDriver driver;
	By title = By.className("title-city-text");
	
	public Boolean isSearchPageLoaded(){
		return Wait.ForElementToBeVisible(super.driver, title, 10);
	}
	
	public String getDepartureTitleText(){
		return BrowserExtensions.getText(super.driver, title);
	}
}
