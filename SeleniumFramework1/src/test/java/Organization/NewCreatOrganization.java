package Organization;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.ExcellUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyUtility;
import GenericUtility.WebDriverUtility;
import POM.HomePage;
import POM.LoginPage;
import POM.OrganizationCreationPage;
import io.github.bonigarcia.wdm.WebDriverManager;
@Test
public class NewCreatOrganization extends BaseClass{

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		String key="webdriver.chrome.driver";
//		String Value="./src/main/resources/chromedriver.exe";
//		System.setProperty(key, Value);
//		WebDriver driver=new ChromeDriver();
		
	PropertyUtility plib=new PropertyUtility();
		 String BROWSER = plib.getKeyValue("browser");
		WebDriver driver;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		
        driver.manage().window().maximize();
        
        WebDriverUtility wlib=new WebDriverUtility();
        wlib.implcityWait(driver);
      //  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        String URL = plib.getKeyValue("url");
        String USERNAME = plib.getKeyValue("username");
        String PASSWORD = plib.getKeyValue("password");
        
      /*  FileInputStream fis=new FileInputStream("./src/test/resources/PropertyFileData.properties");
        Properties pro=new Properties();
        pro.load(fis);
        String URL = pro.getProperty("url");
        String USERNAME = pro.getProperty("username");
        String PASSWORD = pro.getProperty("password");*/
        driver.get(URL);
		//driver.get("http://localhost:8888/");
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//        driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//        driver.findElement(By.id("submitButton")).click();
        
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToApp(USERNAME, PASSWORD);
      //  loginPage.getSubmitBtn().click();
        
        HomePage home=new HomePage(driver);
        home.clickOrganizationsLinkText();
       // driver.findElement(By.linkText("Organizations")).click();
        
        OrganizationCreationPage org=new OrganizationCreationPage(driver);
        org.organizationcreateimage();
      //  driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
        
       Random ran=new Random();
        int RanNUm = ran.nextInt(1000);
        
        JavaUtility jlib=new JavaUtility();
        int RanNum = jlib.getRandomNum();
        
        ExcellUtility elib=new ExcellUtility();
        String exceldata = elib.getExcellDataFormatter("Organization", 0, 0)+RanNUm;
        
//        FileInputStream fes=new FileInputStream("./src/test/resources/ExcelSheetData.xlsx");
//        Workbook book = WorkbookFactory.create(fes);
//        Sheet sheet = book.getSheet("Organization");
//        Row row = sheet.getRow(2);
//        Cell  cell = row.getCell(1);
//        String exceldata = cell.getStringCellValue()+RanNum;
        
        org.organizationnamestext(exceldata);
      // driver.findElement(By.name("accountname")).sendKeys(exceldata);
        
        org.savebutton();
       // driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
       // ValidationAndVerificationPage validate=new ValidationAndVerificationPage(driver);
        
       // validate.organisationValidation(driver, exceldata);
       /* String actdata = driver.findElement(By.cssSelector("span.dvHeaderText")).getText();
        if(actdata.contains(exceldata))
        {
        	System.out.println("pass");
        }
        else
        {
        	System.out.println("fail");
        }*/
        //  home.signoutLink(driver);
          
          driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
          driver.findElement(By.linkText("Sign Out")).click();
}
	}


