package POM.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent
{
	WebDriver driver;
	public CheckoutPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement CountrySelect;
	
	@FindBy(xpath="//section[@class='ta-results list-group ng-star-inserted']//button[2]")
	WebElement SelectCountry;
	
	@FindBy(xpath="//a[text()='Place Order ']")
	WebElement PlaceOrder;
	
	
	public void Counrty(String Country )
	{
		CountrySelect.sendKeys(Country);
		SelectCountry.click();
	}
	
	public ConfirmationPage PLaceHolder() 
	{
		PlaceOrder.click();
		ConfirmationPage confirm = new ConfirmationPage(driver);
		return confirm;
	}
	
	
	
	
	
	
	
	
	
	
	

}
