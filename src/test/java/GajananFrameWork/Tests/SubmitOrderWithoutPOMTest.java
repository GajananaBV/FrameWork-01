package GajananFrameWork.Tests;

import static org.testng.Assert.assertTrue;

import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SubmitOrderWithoutPOMTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Test DATA
		String MyProduct = "ZARA COAT 3";
		String CN = "India";
		String ExpectedConfirmation = "THANKYOU FOR THE ORDER.";

		// Login Application with Id & Password
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("userEmail")).sendKeys("gajananbhnage200@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Gatha10173#");
		driver.findElement(By.id("login")).click();
		
	

		// Find products
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("mb-3")));
		List<WebElement> Products = driver.findElements(By.className("mb-3"));

		// Use java Stream

		WebElement prod = Products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst()
				.orElse(null);
		// click on Add to cart Button

		prod.findElement(By.xpath("//button[text()=' Add To Cart']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		// click on Cart
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();

		List<WebElement> cartProducts = driver.findElements(By.xpath("//div[@class='cart']//h3"));

		boolean match = cartProducts.stream().anyMatch(cartprod -> cartprod.getText().equalsIgnoreCase(MyProduct));
		assertTrue(match);
		// Click on checkout button
		driver.findElement(By.cssSelector(".totalRow button")).click();

		// set the date in the dropdown
		WebElement Dropdown = driver.findElement(By.xpath("//select[@class='input ddl'][1]"));

		Select s = new Select(Dropdown);
		s.selectByVisibleText("10");
		Thread.sleep(2000);
		WebElement Dropdown2 = driver.findElement(By.xpath("//select[@class='input ddl'][2]"));
		Select s2 = new Select(Dropdown2);
		s2.selectByVisibleText("12");

		// Slect country in the

		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys(CN);
		//
		driver.findElement(By.xpath("//section[@class='ta-results list-group ng-star-inserted']//button[2]")).click();
		// Click on PlaceHolder Button
		driver.findElement(By.xpath("//a[text()='Place Order ']")).click();
		// Validate than you for confirmation
		String ConfirmationMsg = driver.findElement(By.xpath("//h1[@class='hero-primary']")).getText();
		assertTrue(ConfirmationMsg.equalsIgnoreCase(ExpectedConfirmation));

		// get the Order ID
		String OrderID = driver.findElement(By.xpath("//label[@class=\"ng-star-inserted\"]")).getText().split(" ")[1]
				.trim();
		System.out.println("ORDER ID :-"+ OrderID);

		driver.close();

	}

}
