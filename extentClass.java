package extentReport;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

public class extentClass extends BaseClass{
	@Test
	public void loginTestCase() throws IOException {


		try {
			driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
			reportStep("Username entered Successfully", "pass");
		} 
		catch (Exception e) {
			reportStep("Username Not Entered Successfully", "fail");
			e.printStackTrace();
		}

		try {
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Admin123");
			reportStep("Password entered Successfully", "pass");
		} 
		catch (Exception e) {
			reportStep("Password not entered Successfully", "fail");
			e.printStackTrace();
		}

		try {
			driver.findElement(By.xpath("//button")).click();
			reportStep("Login Button Clicked Successfully", "pass");
		} 
		catch (Exception e) {
			reportStep("Login Button Not Clicked Successfully", "fail");
			e.printStackTrace();
		}
	}

	public void reportStep(String msg, String status) throws IOException {
		if(status.equals("pass"))
		{
			test.pass(msg,MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+takesnap()+".png").build());
		}
		else
		{
			test.fail(msg,MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+takesnap()+".png").build());
		}
	}
	public long takesnap() throws IOException 
	{
		long number=(long)(Math.floor(Math.random()*90000L)+10000L);
		File scr = driver.getScreenshotAs(OutputType.FILE);
		File dst = new File("./snaps/img"+number+".png");
		FileUtils.copyFile(scr, dst);
		return number;

	}
}




