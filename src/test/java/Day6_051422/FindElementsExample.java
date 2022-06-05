package Day6_051422;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FindElementsExample {
    public static void main(String[] args) throws InterruptedException {
        //go to bing and click on second element of the links by using class and by index.
        //setup webdriver
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
    }
}
