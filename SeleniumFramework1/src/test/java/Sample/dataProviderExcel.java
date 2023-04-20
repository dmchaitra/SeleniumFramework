package Sample;

import org.testng.annotations.Test;

public class dataProviderExcel {
	@Test(dataProvider="getData")
 public void readData(String from, String to) {
	 System.out.println(from+"......"+to);
 }
 @DataProvider
 
}
