package ActionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Automation_AI03 {
    public static void main(String[] args) throws InterruptedException {
        //setup webdriver
        WebDriverManager.chromedriver().setup();
        //set chrome options arguments
        ChromeOptions options = new ChromeOptions();
        //set the condition to incognito mode
        options.addArguments("incognito");
        //set the condition to maximize/fullscreen your driver
        options.addArguments("start-maximized");
        //define the webdriver i am going to use
        WebDriver driver = new ChromeDriver(options);
        //use arraylist to display countries
        ArrayList<String> country = new ArrayList<>();
        country.add("USA");
        country.add("Bangladesh");
        country.add("Canada");
        country.add("Denmark");
        country.add("Egypt");
        //use for loop to print the results
        for(int i = 0; i < country.size(); i++) ;{

            //go to bing
        driver.navigate().to("https://www.bing.com");
        //set threat
        Thread.sleep(2500);
        //locate search box and enter countries
      //  driver.findElement(By.xpath("//*[@id='sb_form_q']")).sendKeys(country.get(i));
        //enter search button
        driver.findElement(By.xpath("//*[@id='search_icon']")).submit();
        Thread.sleep(2500);
        //capture the search results and store in variable
        String searchResult=driver.findElement(By.xpath("//*[@id='search_icon']")).getText();
        //pull number from results using split
        String[] result=searchResult.split(" ");
   //     System.out.println("The search result for country" + country.get(i)+"is"+result[0]);


    }
}}
