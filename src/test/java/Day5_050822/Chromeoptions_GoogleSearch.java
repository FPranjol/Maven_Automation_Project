package Day5_050822;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chromeoptions_GoogleSearch {
    public static void main(String[] args) throws InterruptedException {

        //setup your chromedriver
        WebDriverManager.chromedriver().setup();
        //set chrome options arguments
        ChromeOptions options=new ChromeOptions();
        //set the condition to incognito mode
        options.addArguments("incognito");
        //set the condition to maximize/fullscreen your driver
        options.addArguments("start-maximized");
        //setting your driver as headless(running on background)
        options.addArguments("headless");
        //for mac use full screen
        //options.addArguments("start-fullscreen")

        //define the webdriver i am going to use
        WebDriver driver=new ChromeDriver(options);

        //go to google home
        driver.navigate().to("https://www.google.com");
        Thread.sleep(3000);
        //navigate to maximize
        driver.manage().window().maximize();
        //locate the element
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("Cars");
        //sumbit on google search button
        driver.findElement(By.xpath("//*[@name='btnK']")).submit();
       Thread.sleep(2500);
        //capture the google search and print it
        String searchResult = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
        //   System.out.println("Result is "+ searchResult);
//extract the number and print the search number only
        String[] arrayResult = searchResult.split(" ");
        System.out.println("my search number is " + arrayResult[1]);

        //quit the driver
        driver.quit();
    }
}
