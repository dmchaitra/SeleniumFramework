package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="user_name")
	private WebElement usernameEdtTxt;
	@FindBy(name="user_password")
	private WebElement passwordEdtTxt;
	@FindBy(id="submitButton")
	private WebElement submitBtn;
	
	public WebElement getusernameEdtTxt() {
		return usernameEdtTxt;
	}
	
	public WebElement getpasswordEdtTxt() {
		return passwordEdtTxt;
	}
	public WebElement getSubmitBtn() {
		return submitBtn;
		
	}
	public void loginToApp(String username, String password) {
		usernameEdtTxt.sendKeys(username);
		passwordEdtTxt.sendKeys(password);
		submitBtn.click();
	}
}
