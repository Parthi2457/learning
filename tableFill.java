package sampleSite;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class tableFill {
	
	public WebDriver driver;

	@BeforeTest
	public void driverSetup() {
		
		driver = new ChromeDriver();
	}
	@Test(priority=0)
	public void launchURL() {
		
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/webtables");
		String exp = "Web Tables";
		String act = driver.findElement(By.xpath("//h1[text()=\"Web Tables\"]")).getText();
		Assert.assertEquals(act, exp);
	}
	@Test(priority=1)
	public void addRecord() {
		
		driver.findElement(By.id("addNewRecordButton")).click();
		driver.findElement(By.id("firstName")).sendKeys("Kavi");
		driver.findElement(By.id("lastName")).sendKeys("M");
		driver.findElement(By.id("userEmail")).sendKeys("kavi@example.com");
		driver.findElement(By.id("age")).sendKeys("29");
		driver.findElement(By.id("salary")).sendKeys("75000");
		driver.findElement(By.id("department")).sendKeys("QA");
		driver.findElement(By.id("submit")).click();
		driver.findElement(By.id("searchBox")).sendKeys("Kavi");
		String actname = driver.findElement(By.xpath("//div[text()=\"Cierra\"]")).getText();
		String expname = "Kavi";
		if(actname.contains(expname)) {
			
			System.out.println("Added user is present");
			driver.findElement(By.id("delete-record-1")).click();
			driver.findElement(By.id("searchBox")).clear();
			List<WebElement> firstNames = driver.findElements(By.xpath("//div[@role=\"gridcell\"]"));
			
			for(WebElement addedName : firstNames) {
				
				
			}
			
		}
		else {
			System.out.println("User is not added");
		}
	}
}
