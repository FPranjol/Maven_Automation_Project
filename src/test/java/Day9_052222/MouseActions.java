package Day9_052222;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {
    public static void main(String[] args) throws InterruptedException {

        //set up your chromedriver with webmanager
        WebDriverManager.chromedriver().setup();
        //set up chrome options arguments
        ChromeOptions options=new ChromeOptions();
        //set the condition to incognito mode
        options.addArguments("incognito");
        //set the condition to maximize/fullscreen
        options.addArguments("start-maximized");
        //define the webdriver i am going to use
        WebDriver driver=new ChromeDriver(options);
        //navigate to usps homepage
         driver.navigate().to("https://usps.com");
        Thread.sleep(2000);

        //declare mouse actions
        Actions mouseActions=new Actions(driver);

                //hoverr over send tab
        WebElement sendTab=driver.findElement(By.xpath("//*[@id='mail-ship-width']"));
        mouseActions.moveToElement(sendTab).perform();

   Thread.sleep(1000);

   WebElement tracking = driver.findElement(By.xpath("//*[text()='Tracking']"));
   mouseActions.moveToElement(tracking).click().perform();
   Thread.sleep(1000);

   WebElement trackingField= driver.findElement(By.xpath("//*[@id='tracking-input']"));
mouseActions.moveToElement(trackingField).click().perform();
mouseActions.moveToElement(trackingField).sendKeys("11218284434").perform();


    }
}
