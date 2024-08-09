package Gajanan.TestComponents;

import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import POM.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseTest {
	public WebDriver driver;
	 public LandingPage page;
	
	

	public WebDriver InitializeDriver() throws IOException {

		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(
				"C:\\Users\\GajananVilasBhange\\eclipse-workspace\\FrameWork-1\\src\\main\\java\\GlobalProperties\\resources\\GlobalData.properties");
		prop.load(file);
		String Browser = prop.getProperty("browser");
		if (Browser.equalsIgnoreCase("Chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (Browser.equalsIgnoreCase("Edge")) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		return driver;
	}
	@BeforeMethod(alwaysRun=true)
	public LandingPage LaunchingBrowser() throws IOException
	{
		
		driver=InitializeDriver();
	 page = new LandingPage(driver);
		page.GoTo();
		return page;
		
		
	}
	@AfterMethod(alwaysRun=true)
	public void CLoseBrowser()
	{
		driver.close();
	}
	
	public String TakeScreenShott(String TCName,WebDriver driver) throws IOException
	{
		TakesScreenshot SS = (TakesScreenshot)driver;
		File Source = SS.getScreenshotAs(OutputType.FILE);
		File file=new File(System.getProperty("user.dir")+"//reports//"+TCName+".png");
		FileUtils.copyFile(Source,  file);
		return System.getProperty("user.dir")+"//reports//"+TCName+".png";
	}

	public List<HashMap<String,String>> getJsonDataToMap(String filpath) throws IOException
	{
		//read jason to string 
		String jsonContent = FileUtils.readFileToString(new File(filpath),StandardCharsets.UTF_8); 
	//String to Jackson datatbind
			ObjectMapper mapper= new ObjectMapper();
			List<HashMap<String,String>> data= mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){});
				return data;
				
			}
	
}
