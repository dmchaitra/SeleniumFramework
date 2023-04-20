package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidationandVerificationPage {
public ValidationandVerificationPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="/html/body/table[3]/tbody/tr[1]/td/table[2]/tbody/tr/td[2]/div/table[1]/tbody/tr/td/span[1]")
private WebElement actOrgdata;
@FindBy(xpath="/html/body/table[3]/tbody/tr/td/table[2]/tbody/tr/td[2]/div/table[1]/tbody/tr/td/span[1]")
private WebElement actProdata;
@FindBy(xpath="/html/body/table[3]/tbody/tr[1]/td/table[2]/tbody/tr/td[2]/div/table[1]/tbody/tr/td/span[1]")
private WebElement actCamdata;
public WebElement getactOrgdata() {
	return actOrgdata;
	
}
public WebElement getactProdata() {
	return actProdata;
	
}
public WebElement getactCamdata() {
	return actCamdata;

}
public void orgCreateValidation(String expected_org_data)
{
	String actualOrgdata = actOrgdata.getText();
	if (actualOrgdata.contains(expected_org_data))
	{
		System.out.println("org validaytion pass");
	}
	else{
		System.out.println("org validaytion fail");
	}
	}

public void proCreateValidation(String expected_pro_data)
{
	String actualProdata = actProdata.getText();
	if (actualProdata.contains(expected_pro_data))
	{
		System.out.println("pro validation pass");
	}
	else{
		System.out.println("pro validation fail");
	}
	}
}
