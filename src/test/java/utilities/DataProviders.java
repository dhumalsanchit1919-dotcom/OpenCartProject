package utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	
	
	@DataProvider(name="LoginData")
	public Object [][] data() {
		
		
		Object[][] myData = {
				
			
				{"dhumalsanchit193@gmail.com","Krishna@1231"},
				{"dhumalsanchit192@gmail.com","Krishna@1232"},
				{"dhumalsanchit191@gmail.com","Krishna@1233"},
				{"dhumalsanchit19@gmail.com" ,"Krishna@123"}
				
				
		};
		
		return myData;
		
	}

}
