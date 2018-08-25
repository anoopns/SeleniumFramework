package DataProviders;

import java.util.HashMap;

import org.testng.annotations.DataProvider;

public class PayslipTests {
	HashMap<String, String> data;

	@DataProvider
	public Object[][] ShouldStorePayslip(){
		data = new HashMap<>();
		data.put("firstName", "Test");
		data.put("lastName", "Emp1");
		data.put("annualIncome", "81900");
		data.put("superRate", "9");
		return new Object[][]{{data}};
	}
	
	@DataProvider
	public Object[][] ShouldDeletePayslip(){
		data = new HashMap<>();
		data.put("firstName", "Test");
		data.put("lastName", "Emp2");
		data.put("annualIncome", "81900");
		data.put("superRate", "9");
		return new Object[][]{{data}};
	}
}
