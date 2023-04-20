package Sample;

import java.io.Reader;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Browser1 {

	
		public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver", "./src/main/resources/msedgedriver.exe");

    //WebDriver driver=new ChromeDriver();
		WebDriver driver=new EdgeDriver();
	Properties pro= new Properties();;

	
	 String URL=pro.getProperty("url");
	 String USERNAME= pro.getProperty("username");
	 String PASSWORD=pro.getProperty("password");
	 driver.get(URL);
	 driver.findElement(By.id("useername")).sendKeys(USERNAME);
	 driver.findElement(By.name("pwd")).sendKeys(PASSWORD);
	 driver.findElement(By.id("loginbutton")).click();
	 
	 //pushed and pulled back
	
	
	

		}

}
