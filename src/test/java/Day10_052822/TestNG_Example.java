package Day10_052822;

import ReusableLibraries.Reusable_Actions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


public class TestNG_Example {

        //declare the local driver outside so that it can be reusable with other annotation methods
        WebDriver driver;

        //before suite will set the driver you are using
        @BeforeSuite
        public void SetChromeDriver() {
            driver = Reusable_Actions.setDriver();
        }//end of before suite annotation


        //test case 1: navigate to google and enter a keyword on search field
        @Test(priority = 1)
        public void SearchForKeyword() {
            driver.navigate().to("https://www.google.com");
            //enter a keyword
            Reusable_Actions.sendKeysAction(driver, "//*[@name='q']", "BMW", "Search Field");
            //submit the go button
            Reusable_Actions.submitAction(driver,"//*[@name='btnK']","Google Search Button" );
        }//end of test 1

        @Test(priority = 2)
        public void CaptureSearchNumber() {
            String result = Reusable_Actions.getTextAction(driver, "//*[@id='result-stats']", "Search Result text");
            //split the result by single space and print out the search number
            String[] arrayResult = result.split(" ");
            System.out.println("Search number is " + arrayResult[1]);
        }//end of test

        @AfterSuite
    public void quitSession(){

        }

}//end of main




