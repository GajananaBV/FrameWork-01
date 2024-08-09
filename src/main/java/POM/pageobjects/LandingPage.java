package POM.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent 
{

	WebDriver driver;
	
	
	//Create Constructor 
	public LandingPage(WebDriver driver)
	{  super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement Password;
	
	@FindBy(id="login")
	WebElement Submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement Error;
	
	public ProductCatalog LoginPage (String Email,String PWD)
	{
		userEmail.sendKeys(Email);
		Password.sendKeys(PWD);
		Submit.click();
		ProductCatalog Prod = new ProductCatalog(driver);
		
		return Prod;
		
	}
	public String ErrorMsg()
	{
		WaitAppearWeBElement(Error);
		return Error.getText();
		
		
		
	}
	
	public void GoTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
