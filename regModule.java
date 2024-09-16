package AlterGlobe;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class regModule 
{
	WebDriver driver = new ChromeDriver();
	
	@BeforeTest
	void url()
	{
		driver.manage().window().maximize();
		driver.get("https://alter-globe.maticz.in/");
	}
	@Test(priority = 0)
	void regPage()
	{
		driver.findElement(By.xpath("//a[text()=\"Register\"]")).click();
		String regHeading = driver.findElement(By.xpath("//h3[text()=\"Register\"]")).getText();
		String expHeading = "Register";
		Assert.assertEquals(regHeading, expHeading);
	}
	@Test(priority = 1)
	void regFlow() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[contains(@placeholder,\"first\")]")).sendKeys("Vicky");
		driver.findElement(By.xpath("//input[contains(@placeholder,\"last\")]")).sendKeys("Maticz");
		driver.findElement(By.xpath("//input[@placeholder=\"DD/MM/YYYY\"]")).click();
	    WebElement yeardd = driver.findElement(By.xpath("//select[@class=\"decorated\"]"));
		Select year = new Select(yeardd);
		year.selectByVisibleText("2000");
		WebElement monthdd = driver.findElement(By.xpath("//option[text()='May']//parent::select"));
		Select month = new Select(monthdd);
		month.selectByVisibleText("May");
		driver.findElement(By.xpath("//div[text()=\"16\"]")).click();
		driver.findElement(By.xpath("//input[contains(@placeholder,\"mail\")]")).sendKeys("vickymat@yopmail.com");
		driver.findElement(By.xpath("//div[@class=\"flag-dropdown \"]")).click();
		driver.findElement(By.xpath("//span[text()=\"India\"]")).click();
		driver.findElement(By.xpath("//input[contains(@placeholder,\"phone\")]")).sendKeys("7232320912");
		driver.findElement(By.xpath("//div[@class=\"me-auth__select__indicator me-auth__select__dropdown-indicator css-1xc3v61-indicatorContainer\"]")).click();
		driver.findElement(By.xpath("//div[text()=\"User\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("Test@123");
		driver.findElement(By.xpath("//input[@name=\"confirm password\"]")).sendKeys("Test@123");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,3000)"); 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()=\"Register\"]")).click();
		
//		Select
		
	}
	
	
	
	
	
}
