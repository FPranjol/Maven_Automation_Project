package Day7_051522;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.sql.Driver;
import java.util.ArrayList;

public class FidelisCare_Tabs {
    public static void main(String[] args) throws InterruptedException {

        //setup your chromedriver with webmanager
        WebDriverManager.chromedriver().setup();
        //set up chrome options arguments
        ChromeOptions options=new ChromeOptions();
        //set the condition to incognito mode
        options.addArguments("incognito");
        //set the condition to maximize/fullscreen
        options.addArguments("start-maximized");
        //define the webdriver i am going to use
        WebDriver driver=new ChromeDriver(options);
        //navigate to martgage calc
        driver.navigate().to("https://fideliscare.org");
        Thread.sleep(2000);

        //click on shop for a plan
        driver.findElements(By.xpath("//*[text() = 'Shop For a Plan']")).get(0).click();
        Thread.sleep(2000);
        //click on medicaid  managed care
        driver.findElements(By.xpath("//*[text() = 'Medicaid Managed Care']")).get(0).click();
        Thread.sleep(2000);
        //click on search under find a doctor card
        driver.findElement(By.xpath("//*[@href = '/findadoctor']")).click();
        Thread.sleep(2000);
        //store new tabs in an array list
        ArrayList<String> tabs=new ArrayList<>(driver.getWindowHandles());
        //switch to new tab, it should be at index 1
        driver.switchTo().window(tabs.get(1));
        //click on new search button
        driver.findElement(By.xpath("//*[@class = 'fal fa-search-plus']")).click();
Thread.sleep(1000);
//close the new tab
driver.close();
//switch back to the default tab
        driver.switchTo().window(tabs.get(0));
        //then click on the providers card
        driver.findElement(By.xpath("//*[@class = 'fal fa-stethoscope fa-fw']")).click();
        Thread.sleep(2000);


    }//end of main
}//end of class
