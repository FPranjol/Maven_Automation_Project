package Day8_052122;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class ActionItemInclass {
    public static void main(String[] args) throws InterruptedException {

        ArrayList<String> destinations = new ArrayList<>();
        destinations.add("New York");
        destinations.add("Boston");
        destinations.add("Chicago");

        ArrayList<String> CheckIn = new ArrayList<>();
        CheckIn.add("5");
        CheckIn.add("6");
        CheckIn.add("7");

        ArrayList<String> CheckOut = new ArrayList<>();
        CheckOut.add("15");
        CheckOut.add("16");
        CheckOut.add("17");

        ArrayList<Integer> adults=new ArrayList<>();
        adults.add(3);
        adults.add(4);
        adults.add(5);

        ArrayList<Integer> rooms=new ArrayList<>();
        rooms.add(2);
        rooms.add(3);
        rooms.add(4);

        //setup your chromedriver with webmanager
        WebDriverManager.chromedriver().setup();
        //set up chrome options arguments
        ChromeOptions options = new ChromeOptions();
        //set the condition to incognito mode
        options.addArguments("incognito");
        //set the condition to maximize/fullscreen
        options.addArguments("start-maximized");
        //define the webdriver i am going to use
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.hotels.com/");
        Thread.sleep(2000);

 for (int i = 0; i<destinations.size();i++){

        try {
            WebElement destinationSearch = driver.findElement(By.xpath("//*[@class='uitk-fake-input uitk-form-field-trigger']"));
            destinationSearch.click();
        } catch (Exception e) {
            System.out.println("Unable to find the destination search field" + e);
        }
        Thread.sleep(1000);
        try {
            WebElement whereareyougoing = driver.findElement(By.xpath("//*[@id=location-field-destination']"));
            whereareyougoing.click();
            whereareyougoing.sendKeys("Boston");
        } catch (Exception e) {
            System.out.println("Unable to click the first result"+e);
        }

        Thread.sleep(1000);
        try {
            WebElement firstResult = driver.findElements(By.xpath("//*[@data-stid='location-field-destination-result-item-button']")).get(0);
            firstResult.click();
        } catch (Exception e) {
            System.out.println("unable to find the first search result"+ e);
        }

        try {
            //exception for selecting the date
            WebElement checkInBox = driver.findElement(By.xpath("//*[@data-name='d1']"));
            checkInBox.click();
            Thread.sleep(1000);
            WebElement checkInCalender = driver.findElements(By.xpath("//*[@data-day='"+CheckIn.get(i)+"']")).get(0);
            checkInCalender.click();
        }catch (Exception e){
            System.out.println("unable to click the check in date"+ e);
        }//end of exception

        try {
            //exception for selecting the date
            WebElement checkoutBox = driver.findElement(By.xpath("//*[@data-name='d2']"));
            checkoutBox.click();
            Thread.sleep(1000);
            WebElement checkOutCalender = driver.findElements(By.xpath("//*[@data-day='"+CheckOut.get(i)+"']")).get(1);
            checkOutCalender.click();
            Thread.sleep(1000);
            WebElement doneButton = driver.findElement(By.xpath("//*[@data-stid='apply-data-picker']"));
        }catch (Exception e) {
            System.out.println("unable to click the check in date" + e);
        }//end of exception

     //exception for entering the number of adults





        }//end of loop
    }//end of main
}//end of class
