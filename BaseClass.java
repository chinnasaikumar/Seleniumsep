package extentReport;


	

	import java.io.IOException;
	import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.ExcelCode;
	public class BaseClass {
	

		public ChromeDriver driver;
		 static ExtentSparkReporter reporter;
		 static ExtentReports extent;
		 static ExtentTest test;
		@BeforeMethod
		public void startApp() {

			System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		}
		@BeforeSuite
		public void startReport() {
			reporter = new ExtentSparkReporter("./ExtentReport/report.html");
			extent = new ExtentReports();
			extent.attachReporter(reporter);
		}
		@BeforeClass
		public void testDetails() {
			test = extent.createTest("Login Test Case","Positive test for login functionality");
			test.assignAuthor("CSK");
			test.assignCategory("Functional");
		}
		
		@AfterMethod
		public void closeApp() {
			driver.quit();
		}
		/*@DataProvider(name="LoginData")
		public String[][] sendData() throws IOException {
			return ExcelCode.readExcel();

		}*/
		@AfterSuite
	public void closeReport() {
		extent.flush();
	}
	}


