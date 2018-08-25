package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaySlip {
	private WebDriver driver;
	
	By payslipForm = By.name("payslipForm");
	By employeeName = By.cssSelector("form h4");
	By anualIncome = By.xpath("//td[contains(text(), 'Annual Income')]/following-sibling::td");
	By grossIncome = By.xpath("//td[contains(text(), 'Gross Income')]/following-sibling::td");
	By incomeTax = By.xpath("//td[contains(text(), 'Income Tax')]/following-sibling::td");
	By netIncome = By.xpath("//td[contains(text(), 'Net Income')]/following-sibling::td");
	By pay = By.xpath("//td[contains(text(), 'Pay')]/following-sibling::td");
	By superRate = By.xpath("//td[contains(text(), 'Super')]/following-sibling::td");
	By payButton = By.xpath("//button[contains(text(),'Pay')]");


	public PaySlip(WebDriver driver) {
		this.driver = driver;
	}


	public void pay(){
		WebDriverWait wait = new WebDriverWait(this.driver, 10000);
		wait.until(ExpectedConditions.presenceOfElementLocated(payslipForm));
		this.driver.findElement(payButton).click();
	}

}
