package framework.project;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;

import Pages.PaySlip;
import Pages.Payroll;

public class PayslipTests extends TestBase{
	Payroll payRollPage;
	PaySlip paySlipPage;
	
	@BeforeClass
	@Parameters({"browser", "url"})
	public void runBeforeClass(String browser, String url){
		WebDriver driver = this.getDriver(browser, url);
		driver.manage().window().maximize();
		driver.navigate().to(url);
		this.payRollPage = new Payroll(driver);
		this.paySlipPage = new PaySlip(driver);
	}
	
	
	@Test(dataProvider = "ShouldStorePayslip", dataProviderClass = DataProviders.PayslipTests.class)
	public void ShouldStorePayslip(HashMap<String, String> data){
		payRollPage.deleteAllPayslips();//To clean all existing payslips before test
		payRollPage.enterNewEmployeeDetails(data.get("firstName"), data.get("lastName"),
				data.get("annualIncome"), data.get("superRate"));
		paySlipPage.pay();
		Assert.assertTrue(payRollPage.isPayslipExists(data.get("firstName"), data.get("lastName")));
	}

}
