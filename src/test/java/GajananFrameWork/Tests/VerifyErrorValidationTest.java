package GajananFrameWork.Tests;

import java.util.List;

import org.testng.annotations.Test;

import Gajanan.TestComponents.BaseTest;
import Gajanan.TestComponents.Retry;
import POM.pageobjects.CartPage;
import POM.pageobjects.ProductCatalog;
import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class VerifyErrorValidationTest extends BaseTest {
	@Test(groups={"ErrorHandling"},retryAnalyzer=Retry.class)
	public void VerifyErrorForLoginPage() throws IOException {

		page.LoginPage("gajananbhnage200@gmail.com", "Gatha10137#");
		Assert.assertEquals("Incorrect email  password.", page.ErrorMsg());
	}

	@Test(retryAnalyzer=Retry.class)
	public void VerifySubmitOrder() throws IOException, InterruptedException {

		// Test DATA
		String ProductName = "ZARA COAT 3";

		ProductCatalog Prod = page.LoginPage("Shwetagajanan1013@gmail.com", "Gatha1013#");
		List<WebElement> ProductList = Prod.getProductList();
		Prod.AddProductToCart(ProductName);
		CartPage cart = Prod.ClickCart();
		boolean match = cart.VerifyCartDisplyList(ProductName);

		Assert.assertTrue(match);

	}

}
