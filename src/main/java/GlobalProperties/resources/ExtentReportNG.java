package GlobalProperties.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
	public static ExtentReports  getExtentReportObject()
	{
		String mypath = System.getProperty("user.dir")+"\\Reports\\index.html";
		ExtentSparkReporter report= new ExtentSparkReporter(mypath);
		report.config().setReportName("Web Automation Results");
		report.config().setDocumentTitle("Test Result");
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Automation Tester", "Gajanan V.B");
		return extent;}}
	
	
	
	
	
	
	
	
	
	
	
	


