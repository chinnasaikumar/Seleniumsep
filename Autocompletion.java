package seliniumbasics;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Autocompletion {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://jqueryui.com/autocomplete/");

		Thread.sleep(2000);
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		driver.findElement(By.id("tags")).sendKeys("a");		
		Thread.sleep(2000);
		//List<WebElement> options=driver.findElements(By.id("ui-id-1"));
		List<WebElement> options=driver.findElements(By.xpath("//ul[@id='ui-id-1']/li"));
		Thread.sleep(2000);
		
		for(WebElement choose:options)
		{
			String text = choose.getText();
			//System.out.println(text);
			
			if(text.equals("Java"))
			{
				choose.click();
				Thread.sleep(2000);
				break;
			}
		}
		Thread.sleep(2000);
		driver.close();

	}

}
