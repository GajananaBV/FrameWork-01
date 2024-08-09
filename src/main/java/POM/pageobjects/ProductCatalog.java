package POM.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.AbstractComponents.AbstractComponent;

public class ProductCatalog extends AbstractComponent {
	WebDriver driver;

	public ProductCatalog(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

//List<WebElement> Products = driver.findElements(By.className("mb-3"));
	@FindBy(css = ".mb-3")
	List<WebElement> Products;
	@FindBy(css = ".ng-animating")
	WebElement Spinner;
	By ProductBy=By.cssSelector(".mb-3");
	By addtoCart = By.cssSelector(".card-body button:last-of-type");
	By Toaster = By.cssSelector("#toast-container");

	public List<WebElement> getProductList() {
		WaitForAppearElement(ProductBy);
		return Products;
	}

	public WebElement getProductByName(String ProductName)

	{
		WebElement prod = getProductList().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(ProductName)).findFirst()
				.orElse(null);
		return prod;
	}

	public void AddProductToCart(String ProductName) throws InterruptedException {
		WebElement prod = getProductByName(ProductName);
		prod.findElement(addtoCart).click();
		WaitForAppearElement(Toaster);
		WaitFordisppearElement(Spinner);

	}

}
