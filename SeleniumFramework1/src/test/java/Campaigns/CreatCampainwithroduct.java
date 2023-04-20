package Campaigns;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import GenericUtility.ExcellUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyUtility;
import GenericUtility.WebDriverUtility;

public class CreatCampainwithroduct {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.edge.driver", "./src/main/resources/msedgedriver.exe");

	    //WebDriver driver=new ChromeDriver();
			WebDriver driver=new EdgeDriver();
			WebDriverUtility wlib=new WebDriverUtility();
			wlib.implcityWait(driver);
			/*driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);*/
			PropertyUtility plib=new PropertyUtility();
			String URL = plib.getKeyValue("url");
			String USERNAME = plib.getKeyValue("username");
			String PASSWORD = plib.getKeyValue("password");
			/*FileInputStream fis=new FileInputStream("./src/test/resources/PropertyFileData.Properties.txt");
	        Properties pro=new Properties();
	        pro.load(fis);
	        String URL = pro.getProperty("url");
	        String USERNAME = pro.getProperty("username");
	        String PASSWORD = pro.getProperty("password");*/
	        driver.get(URL);
	        driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	        driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	        driver.findElement(By.id("submitButton")).click();
	        driver.findElement(By.linkText("Products")).click();
	        driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
	       
	        JavaUtility jlib=new JavaUtility();
		    int RanNum = jlib.getRandomNum();
		    
		    ExcellUtility elib=new ExcellUtility();
		    String productdata = elib.getExcellData("Products", 0,0)+RanNum;
		    
	       /* Random ran=new Random();
	        int RanNUm = ran.nextInt(1000);
	        FileInputStream fes =new FileInputStream("./src/test/resources/Properties.xlsx.xlsx");
	        Workbook book = WorkbookFactory.create(fes);
	        Sheet sheet = book.getSheet("Products");
	        Row row = sheet.getRow(0);
	        Cell cell = row.getCell(0);
	        String productdata = cell.getStringCellValue()+RanNUm;*/
	        
	        driver.findElement(By.name("productname")).sendKeys(productdata);
	        
	        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	        driver.findElement(By.linkText("More")).click();
	    	driver.findElement(By.linkText("Campaigns")).click();
	    	
	    	driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
	    	JavaUtility jlib1=new JavaUtility();
	   	 int RanNum1 = jlib1.getRandomNum();
	   	 
	   	 ExcellUtility elib1=new ExcellUtility();
	   	 String CampData = elib1.getExcellDataFormatter("Campaigns", 0, 0)+RanNum1;
	   	   /* String CampData = elib1.getExcellData("Campaigns", 0,0)+RanNum1;*/
	   	    
	    	/*FileInputStream fes1 =new FileInputStream("./src/test/resources/Properties.xlsx.xlsx");
	    	Workbook book1 = WorkbookFactory.create(fes1);
	         Sheet sheet1 = book1.getSheet("Campaigns");
	         Row row1 = sheet1.getRow(0);
	         Cell cell1 = row1.getCell(0);
	         String CampData = cell1.getStringCellValue()+RanNUm;*/
	   	    
	         driver.findElement(By.name("campaignname")).sendKeys(CampData);
	         driver.findElement(By.xpath("//img[@alt='Select']")).click();
	         
	         wlib.switchwindow(driver, "Products&action");
	         
	         /*Set<String> allId = driver.getWindowHandles();
	         Iterator<String> Id = allId.iterator();
	         while(Id.hasNext())
	         {
	       	  String wid = Id.next();//org
	       	  driver.switchTo().window(wid);
	       	  String title = driver.getTitle();
	       	  
	       	  if(title.contains("Products&action"))
	       	  {
	       		  break;
	       	  }
	         }*/
	         
	       	  driver.findElement(By.id("search_txt")).sendKeys(productdata);
	       	  driver.findElement(By.name("search")).click();
	       	  driver.findElement(By.xpath("//a[text()='"+productdata+"']")).click();
	    	  
	       	 wlib.switchwindow(driver, "Campaigns&action");
	    	  /*(Set<String> allId1 = driver.getWindowHandles();//org   //cont  //prd
	          Iterator<String> id1 = allId1.iterator();
	          
	          while(id1.hasNext())
	          {
	        	  String wid1 = id1.next();//org
	        	  driver.switchTo().window(wid1);
	        	  String title = driver.getTitle();
	        	  
	        	  if(title.contains("Campaigns&action"))
	        	  {
	        		  break;
	        	  }
	          }*/
	    	  
	          driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	          
	        String act = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
	        if(act.contains(CampData))
	        {
	        	System.out.println("camp pass");
	        }
	        else
	        {
	        	System.out.println("camp fail");
	        }
	        String actData = driver.findElement(By.xpath("//span[@id='dtlview_Product']")).getText();
	        if(actData.contains(productdata))
	        {
	        	System.out.println("product Pass");
	        }
	        else
	        {
	        	System.out.println("Product fail");

	        }       
	        driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	        driver.findElement(By.linkText("Sign Out")).click();
	    	
	}

}


