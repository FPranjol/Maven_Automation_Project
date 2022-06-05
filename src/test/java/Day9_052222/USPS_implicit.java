package Day9_052222;

import ReusableLibraries.Reusable_Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

public class USPS_implicit {
    public static void main(String[] args) {

//setting the local driver to reusable setDriver method
        WebDriver driver = Reusable_Actions.setDriver();

        //navigate to usps
        driver.navigate().to("https://www.usps.com");

        //hovering to the quick tools
        Reusable_Actions.mouseHover(driver,"//*[text()='Quick Tools']","Quick Tools");

        //hover to send tab
        Reusable_Actions.mouseHover(driver, "//*[@id='mail-ship-width']","Send Tab");

        //click on calculate a price
        Reusable_Actions.clickAction(driver,"//*[@class='tool-calc']","Calculate a Price");

        //enter the zip code
        Reusable_Actions.sendKeysAction(driver,"//*[@id='Origin']","11218","Zip Code");





    }
}
