package metamaskCall;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.io.File;
import java.time.Duration;

public class MetaMaskSelenium {
    public static void main(String[] args) {
        // Set the path to ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\parth\\Desktop\\New Frameworks 2025\\metamaskCall\\chromedriver.exe");

        // Set the path to the MetaMask extension
        String metaMaskExtensionPath = "C:\\Users\\parth\\Downloads\\MetaMask-Chrome-Web-Store.crx";

        // Configure ChromeOptions with MetaMask extension
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File(metaMaskExtensionPath));
        WebDriver driver = new ChromeDriver(options);

        try {
            // Wait until the extension is loaded
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Navigate to a URL to start the setup process
            driver.manage().window().maximize();
            driver.get("https://bitdeals.maticz.in/");
            
            // Set up MetaMask with a seed phrase and password (replace with your values)
            Thread.sleep(4000);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, 500);");
            WebElement ele = driver.findElement(By.xpath("//input[@type=\"checkbox\"]"));
            wait.until(ExpectedConditions.elementToBeClickable(ele)).wait();
            js.executeScript("arguments[0].click();", ele);
//            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type=\"checkbox\"]"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),\"Import\")]"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),\"agree\")]"))).click();
            driver.findElement(By.cssSelector("input[type=\"password\"]")).sendKeys("cancel grunt belt base social found riot burst wolf space helmet plunge");
            driver.findElement(By.xpath("//button[contains(text(),\"Secret\")]")).click();
            driver.findElement(By.xpath("(//input[@type=\"password\"])[1]")).sendKeys("test@4321");
            driver.findElement(By.xpath("(//input[@type=\"password\"])[2]")).sendKeys("test@4321");
            driver.findElement(By.xpath("//input[@type='checkbox']")).click();
            driver.findElement(By.xpath("//button[contains(text(),'Import')]")).click();

            // Confirm the wallet setup
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=\"Done\"]"))).click();
            
            // Switch back to your main application URL
            driver.get("https://bitdeals.maticz.in/");

            // Interact with MetaMask-connected DApp
            System.out.println("MetaMask setup completed and connected!");
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        } 
        finally
        {
//            driver.quit();
        }
    }
}
