package seliniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tutorialdemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver ;
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://tutorialsninja.com/demo/");
		WebElement search= driver.findElement(By.name("search"));
		Thread.sleep(2000);
		search.sendKeys("mac"+Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.linkText("MacBook")).click();
		Thread.sleep(2000);
		driver.close();

	}

}
