package metamaskCall;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class addCoupon 
{
	public static void main(String[] args) throws InterruptedException {
        // Set the path to ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\parth\\Desktop\\New Frameworks 2025\\metamaskCall\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://bitdeals-admin.maticz.in/");
        driver.findElement(By.id("emailId")).sendKeys("admin@gmail.com");
        driver.findElement(By.id("password")).sendKeys("poiuy");
        driver.findElement(By.xpath("//button[text()=\"Sign In\"]")).click();
     // Locate the sidebar element
        Thread.sleep(3000);
        WebElement sidebar = driver.findElement(By.xpath("//aside[@class='sidebar']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollTop -= 600;", sidebar);
        driver.findElement(By.xpath("//a[text()=\"Coupons\"]")).click();
        driver.findElement(By.xpath("//button[text()=\"Add\"]")).click();
        
        for(int i=1;i<=10;i++)
        {
        	driver.findElement(By.xpath("//input[@placeholder=\"Coupon Title\"]")).sendKeys("Coupon "+i);
        	driver.findElement(By.xpath("//input[@placeholder=\"Coupon Description\"]")).sendKeys("Coupon number "+i);
        	driver.findElement(By.xpath("//input[@placeholder=\"Coupon Code\"]")).sendKeys("CODE"+i);
        	
        	
        }
        
        
        
        
        
        
        
        
        
        
        
}
}
