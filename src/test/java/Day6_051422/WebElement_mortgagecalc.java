package Day6_051422;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebElement_mortgagecalc {
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
//click, clear and enter new value on home value field
        WebElement homeValue=driver.findElement(By.xpath("//*[@id='homeval']"));
homeValue.click();
homeValue.click();
homeValue.sendKeys("450000");
        //click on % radio button
        driver.findElement(By.xpath("//*[@value='percent'")).click();
        //click,clear,and enter new data on down payment field
        WebElement downPayment=driver.findElement(By.xpath("//*downpayment']"));

    }
}
