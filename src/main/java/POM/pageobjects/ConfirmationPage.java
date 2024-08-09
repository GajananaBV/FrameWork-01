package POM.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent

{

WebDriver driver;
public ConfirmationPage(WebDriver driver)
{
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);

}
	
	@FindBy(xpath="//h1[@class='hero-primary']")
	WebElement ConfirmationMsg;
	
	@FindBy(xpath="//label[@class=\"ng-star-inserted\"]")
	WebElement getOrderID;
	
	public String VerifyConfirm(String ConfirmText )
	{
		ConfirmText= ConfirmationMsg.getText();
		return ConfirmText;
		
	}
	
	public void VerfiyOrderID()
	{
		String OrderID;
		OrderID=getOrderID.getText().split(" ")[1].trim();
		System.out.println("ORDER ID :-"+ OrderID);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
