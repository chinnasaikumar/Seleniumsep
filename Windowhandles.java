package praticing;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windowhandles {

	public static void main(String[] args) throws InterruptedException {
		WebDriver d;
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		d = new ChromeDriver();
		d.manage().window().maximize();
		Thread.sleep(3000);
		d.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		WebElement link = d.findElement(By.linkText("OrangeHRM, Inc"));
		link.click();
		Thread.sleep(2000);
		String oldhandle = d.getWindowHandle();
		Set<String> handles = d.getWindowHandles();
		for (String newhandle: handles)
		{
			d.switchTo().window(newhandle);
		}
		System.out.println(d.getTitle());
		d.switchTo().window(oldhandle);
		System.out.println(d.getTitle());
		d.quit();
	}

}
