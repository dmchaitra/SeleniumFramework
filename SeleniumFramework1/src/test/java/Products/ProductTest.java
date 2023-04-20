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
import POM.ProductCreationPage;
import io.github.bonigarcia.wdm.WebDriverManager;
@Test(groups={"smoketest","regressiontest"})
public class ProductTest extends BaseClass {

	public void product() throws Throwable {
		//System.setProperty("webdriver.edge.driver", "./src/main/resources/msedgedriver.exe");
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	    WebDriver driver=new ChromeDriver();
			//WebDriver driver=new EdgeDriver();
	    /* WebDriver driver;
		WebDriverManager.edgedriver().setup();
		driver= new EdgeDriver();

		PropertyUtility plib=new PropertyUtility();
		String Browser = plib.getKeyValue("browser");
		WebDriver driver;
		if (Browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
		}
		else if(Browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}*/
     
			PropertyUtility plib=new PropertyUtility();
			String URL = plib.getKeyValue("url");
			String USERNAME = plib.getKeyValue("username");
			String PASSWORD = plib.getKeyValue("password");
			
			/*FileInputStream fis=new FileInputStream("./src/test/resources/PropertyFileData.Properties.txt");
			Properties pro = new Properties();
			pro.load(fis);
			String URL=pro.getProperty("url");
			String USERNAME=pro.getProperty("username");
			String PASSWORD=pro.getProperty("password");*/
			driver.get(URL);
			
			/*driver.get("http://localhost:8888/");
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();*/
			LoginPage loginpage=new LoginPage(driver);
			loginpage.loginToApp(USERNAME, PASSWORD);
		    loginpage.getSubmitBtn().click();
		    
		   // HomePage homepage=new HomePage(driver);
		  //  homepage.getProductslink(); 
		    
			driver.findElement(By.xpath("//a[text()='Products'")).click();
			ProductCreationPage pro=new ProductCreationPage(driver);
			pro.getProductcreationimage();
			
			// driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[2]/td[2]/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td[1]/a/img")).click();
		    
			
			/*Random ran=new Random();
			int RanNum = ran.nextInt(1000);*/
		   JavaUtility jlib=new JavaUtility();
		    int RanNum = jlib.getRandomNum();
		    
		    ExcellUtility elib=new ExcellUtility();
		    String productname = elib.getExcellData("Products", 0,0)+RanNum;
		    
			/*FileInputStream fes=new FileInputStream("./src/test/resources/Properties.xlsx.xlsx");
			Workbook book = WorkbookFactory.create(fes);
			Sheet sheet = book.getSheet("Products");
			Row row = sheet.getRow(0);
            Cell cell = row.getCell(0);
            String productname = cell.getStringCellValue()+RanNum;*/
            
			pro.productnametext(productname);
			
			//driver.findElement(By.name("productname")).sendKeys(productname);
		    pro.savebutton();
			//driver.findElement(By.xpath("/html/body/table[4]/tbody/tr/td[2]/form/div/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[1]/td/div/input[1]")).click();
			/*String actProdata = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr/td/table[2]/tbody/tr/td[2]/div/table[1]/tbody/tr/td/span[1]")).getText();
			
			if(actProdata.contains(productname))
			{
				System.out.println("validation pass");
			}
			else
			{
				System.out.println("validation fail");
			}*/
			driver.findElement(By.xpath("/html/body/table[1]/tbody/tr/td[3]/table/tbody/tr/td[2]/img")).click();
			driver.findElement(By.linkText("Sign Out")).click();
			
	}

}
