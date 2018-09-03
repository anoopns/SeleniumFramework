package test.dataproviders;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.testng.annotations.DataProvider;

public class FlightSearchTests {
	HashMap<String, String> data;
	private static final DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	Date date = new Date();
	Calendar cl = Calendar.getInstance();
	
	@DataProvider
	public Object[][] ShouldSearchFlight(){
		cl.setTime(date);
		cl.add(cl.DATE, 1);		
		String startDate = df.format(cl.getTime());
		cl.setTime(date);
		cl.add(cl.DATE, 7);
		String returnDate = df.format(cl.getTime());
		
		data = new HashMap<>();
		data.put("flyingFromShortName", "Sydney");
		data.put("fylingFromLongName", "Sydney, NSW, Australia (SYD-Kingsford Smith Intl.)");
		data.put("flyingToShortName", "Kochi");
		data.put("fylingToLongName", "Kochi, India (COK-Cochin Intl.)");
		data.put("startDate", startDate);
		data.put("returnDate", returnDate);
		data.put("searchTitleToVerify", "Select your departure to Kochi");
		return new Object[][]{{data}};
	}
}
