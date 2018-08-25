package Pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.project.TestBase;

public class Payroll extends TestBase
{
	WebDriver driver;
	By employeeForm = By.name("employeeForm");
	By firstNameInput = By.name("firstName");
	By lastNameInput = By.name("lastName");
	By annualSalaryInput = By.name("annualSalary");
	By superRateInput = By.name("superRate");
	By generatePayslipButton = By.cssSelector("button.btn-primary");
	By viewButton = By.cssSelector("input[value = 'View']");
	By deleteButton = By.cssSelector("input[value = 'Delete']");
	
	public void enterNewEmployeeDetails(String firstName, String lastName, String annualIncome, String superRate){
		WebDriverWait wait = new WebDriverWait(this.driver, 1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(employeeForm));
		this.driver.findElement(firstNameInput).sendKeys(firstName);
		this.driver.findElement(lastNameInput).sendKeys(lastName);
		this.driver.findElement(annualSalaryInput).sendKeys(annualIncome);
		this.driver.findElement(superRateInput).sendKeys(superRate);
		this.driver.findElement(generatePayslipButton).click();
	}

	public WebElement findNameWebElement(String firstName, String lastName) {
		/*
		 * to find webelement of a employee name in payment history for a
		 * matching emplyee name.
		 */
		List<WebElement> elems = driver.findElements(By
				.cssSelector(".payment-list > div .col-md-3"));
		String name = firstName + " " + lastName; //tried "$firstName $lastName" to make it look nicer but didn't work
		WebElement item = null;
		for(WebElement elem : elems){
			item = (elem.getText().equals(name))? elem : null;
			break;
		}
		return item.findElement(By.xpath(".."));
		/* I wanted to remove above for loop using stream and lambda feature in JAVA(equivalent of LINQ & 
		 * lambda in c#) however it is not working.  
		 * 
		 * WebElement elem = elems.stream().filter(x -> x.getText() ==
		 * "$firstName $lastName").FindAny();
		 * 
		 * return elem.findElement(By.xpath(".."));
		 */
	}
	
	public void viewEmployeePayslip(String firstName, String lastName){
		this.findNameWebElement(firstName, lastName).findElement(this.viewButton).click();
	}
	
	public void deleteEmployeePayslip(String firstName, String lastName){
		this.findNameWebElement(firstName, lastName).findElement(this.deleteButton).click();
	}
	
	public Boolean isPayslipExists(String firstName, String lastName){
		return this.findNameWebElement(firstName, lastName).isDisplayed();
	}
	
	public int getNoOfPayslipsForEmployee(String firstName, String lastName){
		List<WebElement> elems = driver.findElements(By
				.cssSelector(".payment-list > div .col-md-3"));
		List<WebElement> items = null;
		String name = firstName + " " + lastName; //tried "$firstName $lastName" to make it look nicer but didn't work		
		//The following code can also be replaced with stream and lambda
		for(WebElement elem : elems){
			if(elem.getText().equals(name))
				items.add(elem);
		}
		return items.size();
		
	}
	
	public void deleteAllPayslips(){
		List<WebElement> elems = driver.findElements(this.deleteButton);
		if(elems.size() >= 1){
			for(WebElement elem: elems){
				elem.click();
			}
		}
	}

	public Payroll(WebDriver driver) {
		this.driver = driver;
	}

}
