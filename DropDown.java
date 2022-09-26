package seliniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://new.rezofy.com/signupAffliate");
		driver.manage().window().maximize();
		Select country = new Select(driver.findElement(By.id("acountrycombobox")));
		country.selectByValue("IN");
		Thread.sleep(2000);
		Select state = new Select(driver.findElement(By.id("aindianStates")));
		state.selectByVisibleText("Andhra Pradesh");
		Thread.sleep(2000);
		/*Select state2 =new Select(driver.findElement(By.id("gstBillingInfoState")));
		Thread.sleep(2000);
		state2.selectByIndex(0);
		Thread.sleep(2000);*/
		driver.quit();
		

	}

}
