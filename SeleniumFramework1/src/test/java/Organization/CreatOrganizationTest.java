package Organization;

import java.io.FileInputStream;
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
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.ExcellUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyUtility;
import POM.HomePage;

import POM.LoginPage;
import POM.OrganizationCreationPage;
import POM.ValidationandVerificationPage;
import io.github.bonigarcia.wdm.WebDriverManager;
@Test(groups={"sanitytest","smoketest"})
public class CreatOrganizationTest extends BaseClass {

	public void creatorganization() throws Throwable {
		
		//System.setProperty("webdriver.edge.driver", "./src/main/resources/msedgedriver.exe");

	    //WebDriver driver=new ChromeDriver();
		//1st approach to launch single browser 
			//WebDriver driver=new EdgeDriver();
			
			//2nd approach to launch single browser 
			/*WebDriver driver;
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();*/
		
			
			//3rd approach to launch multiple through property file browser 
			/*WebDriver driver;
			PropertyUtility plib=new PropertyUtility();
			String Browser = plib.getKeyValue("browser");
			if(Browser.equalsIgnoreCase("edge"))
			{
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
			}
			else if(Browser.equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
			}
			else
			{
				driver=new EdgeDriver();
			}*/
			
			//fetching data from generic utility(propertyutility)
			/*PropertyUtility plib=new PropertyUtility();
			String URL = plib.getKeyValue("url");
			String USERNAME = plib.getKeyValue("username");
			String PASSWORD = plib.getKeyValue("password");
			//fteching data from property file
			/*FileInputStream fis=new FileInputStream("./src/test/resources/PropertyFileData.Properties.txt");
			Properties pro=new Properties();
			pro.load(fis);
			String URL=pro.getProperty("url");
			String USERNAME=pro.getProperty("username");
			String PASSWORD=pro.getProperty("password");*/
				
			//driver.get(URL);
			//use of POM class
			//LoginPage LoginPage = new LoginPage(driver);
			//LoginPage.loginToApp(USERNAME, PASSWORD);
			//LoginPage.getSubmitBtn();
			//
			/*driver.get("http://localhost:8888/");
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		    driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	     	driver.findElement(By.id("submitButton")).click();*/
			
			//hardcoing to enterdata
			/*driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/table/tbody/tr/td[6]/a")).click();
			driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[2]/td[2]/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td[1]/a/img")).click();
			driver.findElement(By.name("accountname")).sendKeys("ab123de");
			driver.findElement(By.xpath("/html/body/table[4]/tbody/tr/td[2]/div/form/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[1]/td/div/input[1]")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Sign Out")).click(); */
			//use of pom 
	     	HomePage home=new HomePage(driver);
	        home.clickOrganizationsLinkText();
		
		//	driver.findElement(By.linkText("Organizations")).click();
			
			OrganizationCreationPage org=new OrganizationCreationPage(driver);
			org.organizationcreateimage();
			
			//driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			
		    //Random ran=new Random();
			//int RanNum = ran.nextInt(1000);
			
			//use of Generic Utility
			
			JavaUtility jlib=new JavaUtility();
			int RanNum = jlib.getRandomNum();
			ExcellUtility elib=new ExcellUtility();
			String organization = elib.getExcellDataFormatter("Organization", 0, 0)+RanNum;
			
			
			
			
			/*FileInputStream fes=new FileInputStream("./src/test/resources/Properties.xlsx.xlsx");
			Workbook book = WorkbookFactory.create(fes);
			Sheet sheet = book.getSheet("Organization");
			Row row = sheet.getRow(0);
			Cell cell = row.getCell(0);
			String organization = cell.getStringCellValue()+RanNum;*/
			org.organizationnamestext(organization);
			//driver.findElement(By.name("accountname")).sendKeys(organization);
			
			org.savebutton();
			//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			//ValidationandVerificationPage valandver=new ValidationandVerificationPage(driver);
			//valandver.orgCreateValidation(organization);
			/*String actOrgdata = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td/table[2]/tbody/tr/td[2]/div/table[1]/tbody/tr/td/span[1]")).getText();
			if(actOrgdata.contains(organization))
			{
				System.out.println("Pass");
			}
			else
			{
				System.out.println("Fail");
			}*/
			
			
			//driver.findElement(By.xpath("/html/body/table[1]/tbody/tr/td[3]/table/tbody/tr/td[2]/img")).click();
			//driver.findElement(By.linkText("Sign Out")).click();
			
home.signoutBtn(driver);
	}

}
