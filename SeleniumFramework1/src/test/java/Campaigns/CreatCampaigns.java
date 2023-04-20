package Campaigns;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import GenericUtility.ExcellUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyUtility;

public class CreatCampaigns {

	public  void creatCampaigns() throws Throwable {
	 System.setProperty("webdriver.edge.driver", "./src/main/resources/msedgedriver.exe");
	 WebDriver driver=new EdgeDriver();
	    PropertyUtility plib=new PropertyUtility();
		String URL = plib.getKeyValue("url");
		String USERNAME = plib.getKeyValue("username");
		String PASSWORD = plib.getKeyValue("password");
	/* FileInputStream fis=new FileInputStream("./src/test/resources/PropertyFileData.Properties.txt");
	 Properties pro=new Properties();
	 pro.load(fis);
	 String URL = pro.getProperty("url");
	 String USERNAME = pro.getProperty("username");
	 String Password = pro.getProperty("password");*/
	 driver.get(URL);
	 driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	 driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	 driver.findElement(By.id("submitButton")).click();
	 
	 driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/table/tbody/tr/td[22]/a")).click();
	 driver.findElement(By.name("Campaigns")).click();
	 driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[2]/td[2]/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td[1]/a/img")).click();
	 
	/*Random ran=new Random();
	 int RanNum =ran.nextInt(1000);*/
	 JavaUtility jlib=new JavaUtility();
	 int RanNum = jlib.getRandomNum();
	 ExcellUtility elib=new ExcellUtility();
	 String campaingnname = elib.getExcellData("Campaigns", 0,0)+RanNum;
	 
	/* FileInputStream fss=new FileInputStream("./src/test/resources/Properties.xlsx.xlsx");
	 Workbook book = WorkbookFactory.create(fss);
	 Sheet sheet = book.getSheet("Campaigns");
	 Row row = sheet.getRow(0);
	 Cell cell = row.getCell(0);
	 String campaingnname = cell.getStringCellValue()+RanNum;*/
	 
	 driver.findElement(By.xpath("/html/body/table[4]/tbody/tr/td[2]/div/form/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/input")).sendKeys(campaingnname);
	 driver.findElement(By.xpath("/html/body/table[4]/tbody/tr/td[2]/div/form/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[1]/td/div/input[1]")).click();
		String actCamdata = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td/table[2]/tbody/tr/td[2]/div/table[1]/tbody/tr/td/span[1]")).getText();
		
		if(actCamdata.contains(campaingnname))
		{
			System.out.println("validation pass");
		}
		else
		{
			System.out.println("validation fail");
		}
		driver.findElement(By.xpath("/html/body/table[1]/tbody/tr/td[3]/table/tbody/tr/td[2]/img")).click();
		driver.findElement(By.linkText("Sign Out")).click();
	
	 
	}

}
