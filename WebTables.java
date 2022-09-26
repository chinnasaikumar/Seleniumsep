package seliniumbasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTables {

	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://stqatools.com/demo/WebTable.php");
		//Getting number of rows
		List<WebElement> rows = driver.findElements(By.tagName("tr"));
		int rowsize =rows.size() ;
		System.out.println("No of rows are:"+rowsize);
        //Getting number of columns
		List<WebElement> columns = driver.findElements(By.tagName("th"));
		int columnsize = columns.size();
		System.out.println("No of columns are:"+columnsize);
		//Getting data from webtables
		WebElement email = driver.findElement(By.xpath("//td[normalize-space()='Rahul']//following::td[2]"));
	    String text = email.getText();
	    System.out.println("Email of Rahul Sharma is:"+text);
	    driver.quit();
	}

}
