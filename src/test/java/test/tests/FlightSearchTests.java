package test.tests;

import org.testng.annotations.Test;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;




import test.pages.Home;
import test.pages.SearchPage;
import framework.utilities.TestBase;

public class FlightSearchTests extends TestBase{
	Home homePage = new Home();
	SearchPage searchPage;
	
	
	@Test(dataProvider = "ShouldSearchFlight", dataProviderClass = test.dataproviders.FlightSearchTests.class)
	public void shouldSearchFlight(HashMap<String, String> data){
		Assert.assertTrue(homePage.isHomePageLoaded());
		homePage.clickFlightSelectButton();
		homePage.clickOneWayOption();
		homePage.enterFlyingFromDetails(data.get("flyingFromShortName"), data.get("fylingFromLongName"));
		homePage.enterFlyingToDetails(data.get("flyingToShortName"), data.get("fylingToLongName"));
		homePage.enterSingleDate(data.get("startDate"));
		searchPage = homePage.clickSearchSubmitButton();
		Assert.assertTrue(searchPage.isSearchPageLoaded());
		Assert.assertEquals(data.get("searchTitleToVerify"), searchPage.getDepartureTitleText());
	}
	
	@AfterMethod
	@Parameters({"url", "screenShotLocation"})
	public void afterTest(String url, String screenShotLocation, ITestResult result){
		if(result.getStatus() == ITestResult.FAILURE)
			super.takeScreenShotOnFailure(result, screenShotLocation);
		super.goToHomePage(url);
	}

}
