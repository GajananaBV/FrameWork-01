package GajananFrameWork.Tests;

import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Gajanan.TestComponents.BaseTest;
import POM.pageobjects.CartPage;
import POM.pageobjects.CheckoutPage;
import POM.pageobjects.ConfirmationPage;
import POM.pageobjects.OrderHistoryPage;
import POM.pageobjects.ProductCatalog;
import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SubmitOrderTest extends BaseTest {

	@Test(dataProvider = "getData", groups = { "Purchase" })
	public void VerifySubmitOrder(HashMap<String, String> input) throws IOException, InterruptedException {

		String Counrty = "India";
		String ExpectedConfirmation = "THANKYOU FOR THE ORDER.";

		ProductCatalog Prod = page.LoginPage(input.get("Email"), input.get("Password"));
		List<WebElement> ProductList = Prod.getProductList();
		Prod.AddProductToCart(input.get("ProductName"));
		CartPage cart = Prod.ClickCart();
		boolean match = cart.VerifyCartDisplyList(input.get("ProductName"));
		assertTrue(match);
		CheckoutPage Check = cart.GoToChecklout();
		Check.Counrty(Counrty);
		ConfirmationPage confirm = Check.PLaceHolder();
		String Conf = confirm.VerifyConfirm(ExpectedConfirmation);
		assertTrue(Conf.equalsIgnoreCase(ExpectedConfirmation));
		confirm.VerfiyOrderID();

	}

	@Test(dependsOnMethods = { "VerifySubmitOrder" })
	public void VerifyOrderHistory() {
		String ProductName = "ZARA COAT 3";
		page.LoginPage("Shwetagajanan1013@gmail.com", "Gatha1013#");
		OrderHistoryPage OrderPage = page.CLickOrderHistory();
		Assert.assertTrue(OrderPage.VerifyOrderDisplyList(ProductName));

	}

	// @DataProvider
	// public Object[][] getData() throws IOException
	// {
	// List<HashMap<String,String>> data =
	// getJsonDataToMap(System.getProperty(System.getProperty("user.dir")+"//src//test//java//GajananDataReader//data//DataReader.json"),StandardCharsets.UTF_8);
	// return new Object[][] {{data.get(0)},{data.get(0)}};
	@DataProvider
	public Object[][] getData() throws IOException {
		// First Data
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("Email", "gajananbhnage200@gmail.com");
		map.put("Password", "Gatha1013#");
		map.put("ProductName", "ZARA COAT 3");
		// Second Test Data
		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("Email", "Shwetagajanan1013@gmail.com");
		map1.put("Password", "Gatha1013#");
		map1.put("ProductName", "IPHONE 13 PRO");
		//Third section
		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("Email", "Gatha@gmail.com");
		map2.put("Password", "Gatha1013#");
		map2.put("ProductName", "ADIDAS ORIGINAL");
		return new Object[][] { { map }, { map1 }, { map2 } };

	}

}
