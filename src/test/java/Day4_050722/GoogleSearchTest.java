package Day4_050722;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
    public static void main(String[] args) {

        //setup your chromedriver
        WebDriverManager.chromedriver().setup();
        //define the webdriver i am going to
        WebDriver driver=new ChromeDriver();

        //go to google home
        driver.navigate().to("https://www.google.com");

        //navigate to maximize
        driver.manage().window().maximize();
        //locate the element
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("cars");
        //sumbit on google search button
        driver.findElement(By.xpath("//*[@name='btnK']")).submit();
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
