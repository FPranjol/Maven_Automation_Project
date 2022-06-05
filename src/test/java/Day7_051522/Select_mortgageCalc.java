package Day7_051522;

import Day5_050822.Chromeoptions_GoogleSearch;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Select_mortgageCalc {
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
        driver.navigate().to("https://www.mortgagecalculator.org");
        Thread.sleep(2000);
        //select start month from the dropdown
        WebElement startMonth= driver.findElement(By.xpath("//*[@name='param[start_month]']"));
        //define select command
        Select dropDown=new Select(startMonth);
        //select by visible text
        dropDown.selectByVisibleText("Jun");

        //select loan type from the dropdown
        WebElement loanType= driver.findElement(By.xpath("//*[@name='param[milserve]']"));
        //define select command
        Select loanTypeDropdown=new Select(loanType);
        //select by visible text
        loanTypeDropdown.selectByVisibleText("FHA");





    }
}
