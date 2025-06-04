package sampleSite;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class sampleEcomm 
{
	public WebDriver driver;
	
	@BeforeTest
	public void driverSetup() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void timeout() {
		
		Timeouts time = driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	
	}
	
	@Test
	public void urlLaunch() {
		
		driver.get("https://www.automationexercise.com/");
	}
	
	@AfterTest
	public void quitAll() {
		
		driver.quit();
	}
	
}
