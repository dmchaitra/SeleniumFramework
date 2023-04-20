package Sample;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
@Test(dataProvider = "dataProvider")
public class DataProviderTest {
 public void bookTickets(String src,String des)
 {
	 System.out.println("Book tickets from"+src+ "to" +des);
 }
 

 @DataProvider
 public Object[][] dataProvider()
 {
	 Object[][] objarr=new Object[3][2];
	 objarr[0][0]="Bang";
	 objarr[0][1]="Mys";
	 
	 objarr[1][0]="Bang";
	 objarr[1][1]="Hyd";
	 
	 objarr[2][0]="Bang";
	 objarr[2][1]="Dvg";
	 
	 return objarr;
 }
}
