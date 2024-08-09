package POM.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent
{
	WebDriver driver;
	
public CartPage(WebDriver driver)
{
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
	@FindBy(xpath="//div[@class='cart']//h3")
	List<WebElement> CartProduct;
	
	@FindBy(css=".totalRow button")
	WebElement Checkout;
	
public boolean VerifyCartDisplyList(String ProductName)
{
	boolean match = CartProduct.stream().anyMatch(cartprod -> cartprod.getText().equalsIgnoreCase(ProductName));
	
return match;
}

public CheckoutPage GoToChecklout()
{
	Checkout.click();
	CheckoutPage Check = new CheckoutPage(driver);
	return Check;
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
