package sampleSite;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Fillform {

	public WebDriver driver;
	
	@BeforeTest
	public void driverSetup() {
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Test(priority = 0)
	public void launchURL() 
	{	
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/automation-practice-form");
		String act = driver.findElement(By.xpath("//h1[text()=\"Practice Form\"]")).getText();
		String exp = "Practice Form";
		Assert.assertEquals(act, exp);			
	}
	@Test(priority=1)
	public void fillForm() throws InterruptedException {
		
		driver.findElement(By.id("firstName")).sendKeys("Parthi");
		driver.findElement(By.id("lastName")).sendKeys("S");
		driver.findElement(By.id("userEmail")).sendKeys("parthi@example.com");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)", "");
		driver.findElement(By.xpath("//label[text()=\"Male\"]")).click();
		driver.findElement(By.id("userNumber")).sendKeys("9876543210");
		driver.findElement(By.id("dateOfBirthInput")).click();
		WebElement year = driver.findElement(By.xpath("//select[@class=\"react-datepicker__year-select\"]"));
		Select yeardd = new Select(year);
		yeardd.selectByValue("1998");
		WebElement month = driver.findElement(By.xpath("//select[@class=\"react-datepicker__month-select\"]"));
		Select monthdd = new Select(month);
		monthdd.selectByValue("5");
		driver.findElement(By.xpath("(//div[text()=\"4\"])[1]")).click();
		WebElement subField =  driver.findElement(By.id("subjectsInput"));
		subField.sendKeys("Computer Science");
		subField.sendKeys(Keys.ENTER);
		WebElement sportsCheck = driver.findElement(By.xpath("//label[text()=\"Sports\"]"));
		sportsCheck.click();
		WebElement readingCheck = driver.findElement(By.xpath("//label[text()=\"Reading\"]"));
		readingCheck.click();
		js.executeScript("window.scrollBy(0,400)", "");
		WebElement uploadPic = driver.findElement(By.id("uploadPicture"));
		uploadPic.sendKeys("D:\\Test Images\\NFT\\Images\\32.jpg");
		WebElement addressField = driver.findElement(By.id("currentAddress"));
		addressField.sendKeys("Chennai, India");
		WebElement stateDD = driver.findElement(By.xpath("//div[@id='state']//input"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(stateDD));
		stateDD.click();
		stateDD.sendKeys("ncr");
		stateDD.sendKeys(Keys.ENTER);
		WebElement cityDD = driver.findElement(By.xpath("//div[@id='city']//input"));
		cityDD.click();
		cityDD.sendKeys("delhi");
		cityDD.sendKeys(Keys.ENTER);
		WebElement submitBtn = driver.findElement(By.id("submit"));
		submitBtn.click();	
	}
	@Test(priority=2)
	public void verify() {
		
		String act = driver.findElement(By.id("example-modal-sizes-title-lg")).getText();
		String exp = "Thanks for submitting the form";
		Assert.assertEquals(act, exp);
	}
	@Test(priority=3)
	public void nameVerify() {
		
		String expName = "Parthi S";
		String actName = driver.findElement(By.xpath("//td[text()='Student Name']/following-sibling::td")).getText();
		Assert.assertEquals(actName,expName);
	}
	
	@AfterTest()
	public void closeBrowser()
	{
		driver.close();
	}
}
