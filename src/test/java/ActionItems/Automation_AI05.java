package ActionItems;

import ReusableLibraries.ReusableMethods;
import ReusableLibraries.Reusable_Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class Automation_AI05 {
    public static void main(String[] args) throws InterruptedException {

        ArrayList<String> nameFirst = new ArrayList<>();
        nameFirst.add("Adam");
        nameFirst.add("Barry");
        nameFirst.add("Mohammed");
        ArrayList<String> nameLast = new ArrayList<>();
        nameLast.add("Apples");
        nameLast.add("Bananas");
        nameLast.add("Khan");
        ArrayList<String> birthMonth = new ArrayList<>();
        birthMonth.add("January");
        birthMonth.add("February");
        birthMonth.add("March");
        ArrayList<String> birthDay = new ArrayList<>();
        birthDay.add("10");
        birthDay.add("20");
        birthDay.add("30");
        ArrayList<String> birthYear = new ArrayList<>();
        birthYear.add("1970");
        birthYear.add("1980");
        birthYear.add("1990");
        ArrayList<String> memberID = new ArrayList<>();
        memberID.add("111111");
        memberID.add("222222");
        memberID.add("333333");
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11238");
        zipCode.add("11228");
        zipCode.add("11218");


        //start for loop
        for (int i = 0; i< birthDay.size(); i++) {

        //call reusable action for set driver
        WebDriver driver = Reusable_Actions.setDriver();

        //navigate to uhc.com
        driver.navigate().to("https://www.uhc.com");

        //verify title
        Reusable_Actions.verifyTitle(driver, "");



            try {
                //click find a doctor
                driver.findElement(By.xpath("//*[@class='find-doctor position-relative  cta button-style__outline-blue cta--remove-icon mr-2 lg-items-center lg-flex']")).click();
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("unable to find 'find a doctor' element");
            }

            try {
                //click sign in
                driver.findElement(By.xpath("//*[@aria-label='Sign in menu']")).click();
            } catch (Exception e) {
                System.out.println("Unable to find element for sign in");
            }

            try {
//click on medicare plan
                driver.findElements(By.xpath("//*[@class='signin__link weight-bold display-block px-5 py-2']")).get(1).click();
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("Unable to find medicare plan element");
            }

//call reusable action for switchTab and storing in array list
            //    Reusable_Actions.switchTabByIndexAction().get();  //FAILING
            Reusable_Actions.switchTabByIndexAction(driver, 1);
            //Temporary
            //store new tabs in an array list
            //   ArrayList<String> tabs=new ArrayList<>(driver.getWindowHandles());
            //switch to new tab, it should be at index 1
            //  driver.switchTo().window(tabs.get(1));
            //temporary

            try {
//click on register now
                driver.findElement(By.xpath("//*[@class='uhc-tempo-link uhc-tempo-link--medium registerBtn ng-scope']")).click();
            } catch (Exception e) {
                System.out.println("unable to find register now element");
            }
            WebElement firstName = driver.findElement(By.xpath("//*[@class='Tier1Component_inputDefault__1Av0M']"));
            try {
//click first name text box and enter name from array list
                firstName.click();
                firstName.clear();
                firstName.sendKeys(nameFirst.get(i));
            } catch (Exception e) {
                System.out.println("unable to find first name text box element");
            }
            try {
                //click last name and enter  name from array list
                WebElement lastName = driver.findElement(By.xpath("//*[@id='lastName']"));
                lastName.click();
                lastName.clear();
                lastName.sendKeys(nameLast.get(i));
            } catch (Exception e) {
                System.out.println("unable to find last name text box element");
            }

            try {
                //click zipcode and enter from array list
                WebElement ZipCode = driver.findElement(By.xpath("//*[@id='zipCode']"));
                ZipCode.click();
                ZipCode.clear();
                ZipCode.sendKeys(zipCode.get(i));
            } catch (Exception e) {
                System.out.println("unable to find zip code text box element"+e);
            }

            try {
                //click membership id text box element
                WebElement MemberID = driver.findElement(By.xpath("//*[@id='memberId']"));
                MemberID.click();
                MemberID.clear();
                MemberID.sendKeys(memberID.get(i));
            } catch (Exception e) {
                System.out.println("unable to find member id text box element"+e);
            }

            //enter month dropdown info
            Reusable_Actions.selectByText(driver, "//*[2name='dob_month']", birthMonth.get(i), "Birth Month");


            try {
                //click DOB text box
                WebElement DayOB = driver.findElement(By.xpath("//*[@id='dob_day']"));
                DayOB.click();
                DayOB.clear();
                DayOB.sendKeys(birthDay.get(i));
            } catch (Exception e) {
                System.out.println("unable to find day of birth element"+e);
            }
            try {
                //click on year of birth text box
                WebElement YearOB = driver.findElement(By.xpath("//*[@id='dob_year']"));
                YearOB.click();
                YearOB.clear();
                YearOB.sendKeys(birthYear.get(i));
            } catch (Exception e) {
                System.out.println("unable to locate text box "+e);
            }
            //click continue button
            WebElement continueButton= driver.findElement(By.xpath("//*[@class='rds-primary-button is-rds-fullwidth']"));
            continueButton.click();

            //get text from error and print it
           WebElement Error= driver.findElement(By.xpath("//*[@class='SummaryError_ErrorContent__1j0LP']"));
           Reusable_Actions.getTextAction(driver,"//*[@class='SummaryError_ErrorContent__1j0LP']","Error message");
            System.out.println(Error+"");

            driver.close();

            Reusable_Actions.switchTabByIndexAction(driver,0);

        }//end of loop
        //quit driver

    }//end of main
}//end of class
