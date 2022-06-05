package ReusableLibraries;

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

public class Reusable_Actions {
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
    public static void sendKeysAction(WebDriver driver, String xpath, String userValue, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.sendKeys(userValue);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
        }
    }//end of sendkeys method

    //create a getText method
    public static String getTextAction(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String result = null;
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            result = element.getText();
        } catch (Exception e) {
            System.out.println("Unable to capture text on element " + elementName + " " + e);
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

    public static void selectByText(WebDriver driver,String xpath, String month, String elementName){
        try {
            WebElement startMonth=driver.findElement(By.xpath(xpath));
            Select dropdown=new Select(startMonth);
            dropdown.selectByVisibleText(month);
        }catch (Exception e){

            System.out.println("unable to find dropdown" + elementName+ "" +e);
        }//end of selectByText
    }
//create submit action
    public static void submitAction(WebDriver driver,String xpath, String elementName)
    {WebDriverWait wait = new WebDriverWait(driver,10);
        try{WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.submit();
        } catch (Exception e)
        {System.out.println("Unable to submit on element " + elementName + " " + e);}}
    //end of submit

/*FAILING
    //create a selectByText method
    public static void selectByText(WebDriver driver, String xpath, int indexNumber, String MonthName){
        WebElement birthMonth = driver.findElement(By.xpath("//*[@name='param[start_month]']"));
        //define select command
        ArrayList<String> month=new ArrayList<>();
        month.add("January");
        month.add("February");
        month.add("March");
        month.add("April");
        month.add("May");
        month.add("June");
        month.add("July");
        month.add("August");
        month.add("September");
        month.add("October");
        month.add("November");
        month.add("December");
        Select dropDown=new Select(MonthName);
        //select by visible text
        dropDown.selectByVisibleText();

    }
*/
 /* FAILING
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            //store new tabs in an array list
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            //switch to new tab, it should be at index 1
            driver.switchTo().window(tabs.get(1));
        } catch (Exception e) {
            System.out.println("Unable to switch to new tab " + elementName + " " + e);
        }
        return driver;
    } //end of switch tab action
*/



}