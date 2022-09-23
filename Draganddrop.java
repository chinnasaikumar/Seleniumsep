package praticing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Draganddrop {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver d;
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://jqueryui.com/droppable/");
		d.switchTo().frame(0);
		Actions a = new Actions(d);
		Thread.sleep(2000);
		a.clickAndHold(d.findElement(By.id("draggable"))).moveToElement(d.findElement(By.id("droppable"))).release().build().perform();
		//a.dragAndDrop(d.findElement(By.id("draggable")), d.findElement(By.id("droppable"))).build().perform();
		Thread.sleep(2000);	
		d.quit();
	}

}
