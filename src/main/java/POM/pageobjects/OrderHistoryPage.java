package POM.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.AbstractComponents.AbstractComponent;

public class OrderHistoryPage extends AbstractComponent
{
	WebDriver driver;
	
public OrderHistoryPage(WebDriver driver)
{
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
	@FindBy(xpath="//tr/td[2]")
	List<WebElement> Orderlist;
	
	
	
public boolean VerifyOrderDisplyList(String ProductName)
{
	boolean match = Orderlist.stream().anyMatch(Ordertable -> Ordertable.getText().equalsIgnoreCase(ProductName));
	
return match;
}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
