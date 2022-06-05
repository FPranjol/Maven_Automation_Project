package ReusableLibraries;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class Reusable_Actions_Loggers {

        //resuable function for webdriver as a return method
        public static WebDriver setDriver() {
            //setup your chromedriver with webdrivermanager
            WebDriverManager.chromedriver().setup();
            //set chrome options arguments
            ChromeOptions options = new ChromeOptions();
            //set the condition to incognito mode
            options.addArguments("incognito");
            //set the condition to maximize/fullscreen your driver
            options.addArguments("start-maximized");
            //for mac use full screen
            //options.addArguments("start-fullscreen");
            //define the webdriver I am going to use
            WebDriver driver = new ChromeDriver(options);
            return driver;
        }//end of setDriver method

        //create a mouse hover method
        public static void mouseHover(WebDriver driver, String xpath, String elementName) {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            Actions actions = new Actions(driver);
            try {
                WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
                actions.moveToElement(element).perform();
            } catch (Exception e) {
                System.out.println("Unable to hover on element " + elementName + " " + e);
            }
        }//end of mouseHover

        //create a click method
        public static void clickAction(WebDriver driver, String xpath, String elementName) {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            try {
                WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
                element.click();
            } catch (Exception e) {
                System.out.println("Unable to click on element " + elementName + " " + e);
            }
        }//end of clickAction

        //create a sendkeys method
        public static void sendKeysAction(WebDriver driver, String xpath, String userValue,ExtentTest logger, String elementName) {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            try {
                WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
                element.sendKeys(userValue);
                logger.log(LogStatus.PASS,"Successfully entered used value on element"+elementName);
            } catch (Exception e) {
                System.out.println("Unable to click on element " + elementName + " " + e);
                logger.log(LogStatus.FAIL,"Unable to click on element " + elementName + " " + e);
            }
        }//end of sendkeys method

        //create a getText method
        public static String getTextAction(WebDriver driver, String xpath,ExtentTest logger, String elementName) {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            String result = null;
            try {
                WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
                result = element.getText();
                logger.log(LogStatus.PASS,"Successfully capture text from element");
            } catch (Exception e) {
                System.out.println("Unable to capture text on element " + elementName + " " + e);
            logger.log(LogStatus.PASS,"Unable to capture text on element"  + elementName + " " + e);
            }
            return result;
        }//end of getTextAction method

        //create a click by index method
        public static void clickByIndexAction(WebDriver driver, String xpath, int indexNumber, String elementName) {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            try {
                WebElement element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath))).get(indexNumber);
                element.click();
            } catch (Exception e) {
                System.out.println("Unable to click on element " + elementName + " " + e);
            }
        }//end of clickByIndexAction

        //create a  Switch To Tab By Index method
        public static void switchTabByIndexAction(WebDriver driver,int userValue) {
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(userValue));
        }    //end of switch to tab by index method

        //create a verifyTitle Method
        public static void verifyTitle(WebDriver driver,String title){
            //get title
            String Title= driver.getTitle();
            if (Title.equals(Title)) {
                System.out.println("Title Matches");
            }
            else{
                System.out.println("title doesn't match. Title is"+Title );
            }//end of title verify
        }//end of if-else?

    public static void submitAction(WebDriver driver, String xpath, ExtentTest logger, String elementName)
    {WebDriverWait wait = new WebDriverWait(driver,10);
        try{WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.submit();
            logger.log(LogStatus.PASS,"Successfully submit on an element"+ elementName);
        } catch (Exception e) {

            logger.log(LogStatus.FAIL, "Unable to submit on element " + elementName + " " + e);
            System.out.println("Unable to submit on element " + elementName + " " + e);
        }//end of submit


    }//create submit action
    public static void selectByText(WebDriver driver,String xpath, String month, String elementName){
            try {
                WebElement startMonth=driver.findElement(By.xpath(xpath));
                Select dropdown=new Select(startMonth);
                dropdown.selectByVisibleText(month);
            }catch (Exception e){

                System.out.println("unable to find dropdown" + elementName+ "" +e);
            }//end of selectByText
        }

    }
