package Organization;


import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import GenericUtility.PropertyUtility;

import POM.HomePage1;
import POM.LoginPage;
import POM.OrganizationCreationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OrganizationTrail {

	public static void main(String[] args) throws Throwable {
		
		//System.setProperty("webdriver.edge.driver", "./src/main/resources/msedgedriver.exe");
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	    
		//1st approach to launch single browser 
			//WebDriver driver=new EdgeDriver();
		WebDriver driver=new ChromeDriver();
		//2nd approach to launch single browser 
		/*WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();*/
		//3rd approach to launch multiple through property file browser
		/*WebDriver driver;
		PropertyUtility plib=new PropertyUtility();
		String Browser = plib.getKeyValue("browser");
		if(Browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else 
		{
			driver=new ChromeDriver();
		}*/
		//fetching data from generic utility
		PropertyUtility plib=new PropertyUtility();
		String URL = plib.getKeyValue("url");
		String USERNAME = plib.getKeyValue("username");
		String PASSWORD = plib.getKeyValue("password");
		
			//fetching data from property file
			/*FileInputStream fis=new FileInputStream("./src/test/resources/PropertyFileData.Properties.txt");
			Properties pro=new Properties();
			pro.load(fis);
			String URL = pro.getProperty("url");
			String USERNAME = pro.getProperty("username");
			String PASSWORD = pro.getProperty("password");*/
			driver.get(URL);
			
			//fetching data from POM
			LoginPage LoginPage = new LoginPage(driver);
			LoginPage.loginToApp(USERNAME, PASSWORD);
			LoginPage.getSubmitBtn();
			
			/*driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();*/
			HomePage1 home=new HomePage1(driver);
			home.getOrganizationBtn();
			OrganizationCreationPage org=new OrganizationCreationPage(driver);
			org.organizationcreateimage();
			
			/*driver.findElement(By.linkText("Organizations")).click();
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			Random ran=new Random();
			int RanNum = ran.nextInt(2000);
			FileInputStream fes=new FileInputStream("./src/test/resources/Properties.xlsx.xlsx");
			Workbook book = WorkbookFactory.create(fes);
			Sheet Sheet = book.getSheet("Organization");
			Row row = Sheet.getRow(0);
			Cell cell = row.getCell(0);
			String organization = cell.getStringCellValue()+RanNum;
			driver.findElement(By.name("accountname")).sendKeys(organization);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		    String actorgdata = driver.findElement(By.cssSelector("span[class=dvHeaderText]")).getText();
			if(actorgdata.contains(organization))
			{
				System.out.println("Pass");
			}
			else
			{
				System.out.println("Fail");
			}
			driver.findElement(By.xpath("//image[@src='themes/softed/images/user.PNG']")).click();
			driver.findElement(By.linkText("Sign Out")).click();*/
	}

}
