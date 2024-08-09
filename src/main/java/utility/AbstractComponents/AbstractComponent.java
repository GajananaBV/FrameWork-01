package utility.AbstractComponents;

import POM.pageobjects.CartPage;
import POM.pageobjects.OrderHistoryPage;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent

{
	WebDriver driver;

	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
PageFactory.initElements(driver, this);
	}
	
@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
WebElement CartClick;
@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
WebElement OrderHistoryCLick;


public void WaitAppearWeBElement(WebElement findBy)
{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOf(findBy));
}
	public void WaitForAppearElement(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public void WaitFordisppearElement(WebElement el) throws InterruptedException {
Thread.sleep(1000);
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.invisibilityOf(el));
	}

	public CartPage ClickCart() {
		CartClick.click();
		CartPage cart = new CartPage(driver);
		return cart;
	}
	public OrderHistoryPage CLickOrderHistory() {
		OrderHistoryCLick.click();
		OrderHistoryPage order = new OrderHistoryPage(driver);
		return order;
	}
	

}
