package test.pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;





import webdriver.utilities.Wait;
import framework.utilities.TestBase;

public class Home extends TestBase
{
	//WebDriver driver;
	WebElement elem;
	By homePageHeader = By.id("header-logo");
	By flightSelectButton = By.id("tab-flight-tab-hp");
	By oneWaySelection = By.id("flight-type-one-way-label-hp-flight");
	By flyingFrom = By.id("flight-origin-hp-flight");
	By flyingOptions = By.id("typeaheadDataPlain");
	By flyingOptionList = By.cssSelector(".display-group-results > li");
	By flyingTo = By.id("flight-destination-hp-flight");
	By startDate = By.id("flight-departing-hp-flight");
	By returnDate = By.id("flight-returning-hp-flight");
	By singleDate = By.id("flight-departing-single-hp-flight");
	By searchSubmitButton = By.cssSelector("button.gcw-submit");
	
	public Boolean isHomePageLoaded(){
		return Wait.ForElementToBeVisible(super.driver, this.homePageHeader, 10);
	}
	
	public void clickFlightSelectButton(){
		super.driver.findElement(this.flightSelectButton).click();
	}
	
	public void clickOneWayOption(){
		super.driver.findElement(this.oneWaySelection).click();
	}
	
	public void enterFlyingFromDetails(String flyingFromShortName, String flyingFromLongName){
		super.driver.findElement(this.flyingFrom).clear();
		super.driver.findElement(this.flyingFrom).sendKeys(flyingFromShortName);
		Wait.ForElementToBeVisible(super.driver, flyingOptions, 10);
		selectFromList(flyingFromLongName);
	}
	
	public void enterFlyingToDetails(String flyingToShortName, String flyingToLongName){
		super.driver.findElement(this.flyingTo).clear();
		super.driver.findElement(this.flyingTo).sendKeys(flyingToShortName);
		Wait.ForElementToBeVisible(driver, flyingOptions, 10);
		selectFromList(flyingToLongName);
	}
	
	public void selectFromList(String option){
		List<WebElement> elems = super.driver.findElement(flyingOptionList).findElements(By.tagName("a"));
		for(WebElement elem : elems){
			if(elem.getAttribute("data-value").equals(option))
				elem.click();
			break;
		}
	}
	
	public void enterSingleDate(String date){
		elem = Wait.ForElementToBeClickable(super.driver, this.singleDate, 10);
		elem.clear();
		elem.sendKeys(date);
		//To go out of auto-selected date picker options
		List<WebElement> elems = super.driver.findElements(By.cssSelector(".gcw-traveller-field > span.label"));
		for(WebElement elem: elems){
			if(elem.getText().contains("Adults"))
				elem.click();
		}
	}
	
	public void enterDates(String startDate, String returnDate){
		elem = Wait.ForElementToBeClickable(super.driver, this.startDate, 10);
		elem.clear();
		elem.sendKeys(startDate);
		elem = Wait.ForElementToBeClickable(super.driver, this.returnDate, 10);
		elem.clear();
		elem.sendKeys(returnDate);
	}

	public SearchPage clickSearchSubmitButton(){
		List<WebElement> elems = super.driver.findElements(this.searchSubmitButton);
		for(WebElement elem : elems){
			if(elem.getText().equals("Search")){
				elem.click();
				break;
			}
		} /* Can re write for loop using => WebElement elem = elems.stream().filter(x -> x.getText().equals("Search").FindAny();*/
		return new SearchPage();
	}

}
