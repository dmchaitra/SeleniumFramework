package Products;

	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.util.Properties;
	import java.util.Random;

	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
@Test
	public class CreatAndDeletProduct extends BaseClass {

		public  void creatAndDeletProduct() throws Throwable {
			//System.setProperty("webdriver.edge.driver", "./src/main/resources/msedgedriver.exe");

		    //WebDriver driver=new ChromeDriver();
				//WebDriver driver=new EdgeDriver();
		
				FileInputStream fis=new FileInputStream("./src/test/resources/PropertyFileData.Properties.txt");
				Properties pro = new Properties();
				pro.load(fis);
				String URL=pro.getProperty("url");
				String USERNAME=pro.getProperty("username");
				String PASSWORD=pro.getProperty("password");
				driver.get(URL);
				
				/*driver.get("http://localhost:8888/");*/
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
			    
				driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/table/tbody/tr/td[12]/a")).click();
			    driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[2]/td[2]/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td[1]/a/img")).click();
			    
				
				Random ran=new Random();
				int RanNum = ran.nextInt(1000);
				FileInputStream fes=new FileInputStream("./src/test/resources/Properties.xlsx");
				Workbook book = WorkbookFactory.create(fes);
				Sheet sheet = book.getSheet("Products");
				Row row = sheet.getRow(0);
	            Cell cell = row.getCell(0);
	            String productname = cell.getStringCellValue()+RanNum;
	            
				
				driver.findElement(By.name("productname")).sendKeys(productname);
				driver.findElement(By.xpath("/html/body/table[4]/tbody/tr/td[2]/form/div/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[1]/td/div/input[1]")).click();
				driver.findElement(By.xpath("/html/body/table[3]/tbody/tr/td/table[2]/tbody/tr/td[2]/div/table[2]/tbody/tr[1]/td/table/tbody/tr/td[5]/input[3]")).click();
				driver.switchTo().alert().accept();
		        		
			    String actdata = driver.findElement(By.xpath("//*[@id=\"massdelete\"]/table/tbody/tr[1]/td/div/table/tbody/tr[1]/td[3]/a")).getText();
			     	
				if(actdata.contains(productname))
				{
					System.out.println("creation and deletion fail");
				}
				
				else
				
				{
					System.out.println("creation and deletion pass");
				}
				
				driver.findElement(By.xpath("/html/body/table[1]/tbody/tr/td[3]/table/tbody/tr/td[2]/img")).click();
				driver.findElement(By.linkText("Sign Out")).click();
				
		}
		
}