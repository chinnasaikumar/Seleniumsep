package seliniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calender {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		Thread.sleep(2000);
		WebElement datepicker = driver.findElement(By.id("first_date_picker"));
		datepicker.sendKeys("10/29/2022");
		Thread.sleep(3000);
		/*WebElement datepicker2 = driver.findElement(By.id("second_date_picker"));
		datepicker2.sendKeys("29/10/2022");*/
		WebElement datepicker2 = driver.findElement(By.id("second_date_picker"));
		datepicker2.click();
		WebElement monthyear = driver.findElement(By.className("ui-datepicker-title"));
		String monthyeartext = monthyear.getText();
		System.out.println(monthyeartext);
		String month = monthyeartext.split(" ")[0].trim();
		System.out.println(month);
		String year = monthyeartext.split(" ")[1].trim();
		System.out.println(year);
		Thread.sleep(3000);
		while (!(month.equals("October")&&year.equals("2029")))
		{
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			 monthyear = driver.findElement(By.className("ui-datepicker-title"));
			 monthyeartext = monthyear.getText();
			 month = monthyeartext.split(" ")[0].trim();
			 year = monthyeartext.split(" ")[1].trim();
		}
		driver.findElement(By.xpath("//a[text()='29']")).click();
		Thread.sleep(2000);
		driver.quit();
	}
}
