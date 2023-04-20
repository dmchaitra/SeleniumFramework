package GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import POM.HomePage;
import POM.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	@BeforeSuite(groups= {"smoketest","regressiontest","sanitytest"})
	public void BS()
	{
		System.out.println("Database Connection");
	}
	@BeforeTest(groups= {"smoketest","regressiontest","sanitytest"})
	public void BT()
	{
		System.out.println("Parallel Execution");
	}
	@Parameters("Browser")
	@BeforeClass(groups= {"smoketest","regressiontest","sanitytest"})
	public void BC(String Browser) throws Throwable
	{
		//PropertyUtility plib=new PropertyUtility();
		//String Browser = plib.getKeyValue("browser");
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
		}
		
		
		System.out.println("Launching Browser");
	}
	@BeforeMethod(groups= {"smoketest","regressiontest","sanitytest"})
	public void BM() throws Throwable
	{
		PropertyUtility plib=new PropertyUtility();
		String URL = plib.getKeyValue("url");
		String USERNAME = plib.getKeyValue("username");
		String PASSWORD = plib.getKeyValue("password");
		driver.get(URL);
		
		LoginPage LoginPage = new LoginPage(driver);
		LoginPage.loginToApp(USERNAME, PASSWORD);
		//LoginPage.getSubmitBtn();
		System.out.println("Login Application");
	}
	@AfterMethod(groups= {"smoketest","regressiontest","sanitytest"})
	public void AM()
	{
//		HomePage home=new HomePage(driver);
//		home.signoutLink(driver);
		System.out.println("Logout Application");
	}
    @AfterClass(groups= {"smoketest","regressiontest","sanitytest"})
	public void AC()
	{
    	//driver.quit();
		System.out.println(" Browser closer");
	}
    @AfterTest(groups= {"smoketest","regressiontest","sanitytest"})
    public void AT()
	{
		System.out.println("Parallel Execution Done");
	}
@AfterSuite(groups= {"smoketest","regressiontest","sanitytest"})
    public void AS()
	{
		System.out.println("Database Connection close");
	}
}



