package GenericUtility;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriverUtility {
	public void implcityWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	public void switchwindow(WebDriver driver, String PartialWindowTitle)
	{
		Set<String> allId = driver.getWindowHandles();
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
	}
	}
	public void mouseOverOnElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
		
	}
}
	


