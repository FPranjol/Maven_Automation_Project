package Day6_051422;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Scroll_mortgagecalc {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        //set chrome options arguments
        ChromeOptions options = new ChromeOptions();
        //set the condition to incognito mode
        options.addArguments("incognito");
        //set the condition to maximize/fullscreen your driver
        options.addArguments("start-maximized");
        //define the webdriver i am going to use
        WebDriver driver = new ChromeDriver(options);
        //navigate to bing home
        driver.navigate().to("https://www.bing.com");
        Thread.sleep(2500);
        //click on images using class property with index of 1
        //to ignore white space in the property value we can use contains in xpath
        driver.findElements(By.xpath("//li[contains(@class,'scope')]")).get(0).click();
        //navigate to martgage calc
        driver.navigate().to("https://www.mortgagecalculator.org");
        Thread.sleep(3000);
  //declare javascriptexecutor variable
        JavascriptExecutor jse=(JavascriptExecutor) driver;
        //scroll a bit for browser to preform scrolling
        jse.executeScript("Scroll(0,800)");
        Thread.sleep(2500);

        WebElement shareButton=driver.findElement(By.xpath("//*[@id='share_button']"));
        //scroll into share this calculation button
        jse.executeScript("arguments[0].scrollIntoView(true);",shareButton);
        Thread.sleep(2500);
        //click on the share this calculation button
        shareButton.click();
        Thread.sleep(2000);
        jse.executeScript("scroll(0,-400)");
        Thread.sleep(2000);
        //quit the driver
        driver.quit();
    }
}
