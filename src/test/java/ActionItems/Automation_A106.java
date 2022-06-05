package ActionItems;

import ReusableLibraries.Reusable_Actions;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Automation_A106 {



    //declare the local driver outside so that it can be reusable with other annotation methods
    WebDriver driver;
ExtentReports reports;
ExtentTest logger;
    //before suite will set the driver you are using
    @BeforeSuite
    public void SetChromeDriver() {
        driver = Reusable_Actions.setDriver();
   //define path or report
        ExtentReports reports=new ExtentReports("src/main/java/HTML_Report/Automation.html",true);

    }//end of before suite annotation


    //Prerequisite/User story 1- navigate to CIGNA.com find a doctor/dentist/facility module
    @Test( priority = 1)
   // logger.StartTest= ("Search for a keyword");
    public void navigateToCignaModule(){
        driver.navigate().to("https://www.cigna.com");
        Reusable_Actions.clickAction(driver,"//*[@class='btn btn-sm btn-primary']","FindDoctorDentistFacilityModule");
    }//end of test 1/Prerequisite

//User story 2- I want to be able to select doctor by type
    @Test(dependsOnMethods = "navigateToCignaModule")
    public void DoctorByType() throws InterruptedException {
        Reusable_Actions.clickAction(driver,"//*[@triggers='mousehoverstart.cignahover:mousehoverend.cignahover focus']","EmployerOrSchoolTab");
        //click employer/school as provider
        Reusable_Actions.clickAction(driver,"//*[@aria-label='Geolocation search']","ZipcodeTextBox");
        //type specified zipcode into text box
        Reusable_Actions.sendKeysAction(driver,"//*[@aria-label='Geolocation search']","Brooklyn","zipcode");
        //click popup of zipcode address
       Reusable_Actions.clickAction(driver,"//*[@class='suggestion ng-star-inserted']","clickPopUp");
       Reusable_Actions.mouseHover(driver,"//*[@class='search-button']","DoctorByType");
       //click doctor by type
        Reusable_Actions.clickByIndexAction(driver,"//*[@class='search-button']",0,"DoctorByType");
    Thread.sleep(1500);
    }//end of test

    //User story 3- As a user I want to be able to find a Cardiologist “Accepting new patients” so that I can select the best suited one for my needs.
@Test(dependsOnMethods = "DoctorByType")
    public void Cardiologist(){
        //click doctor by type button
Reusable_Actions.clickByIndexAction(driver,"//*[@class='search-button']",0,"DoctorTypeTextBox");

//type cardiologist into search field
    Reusable_Actions.sendKeysAction(driver,"//*[@class='category-search-form__input form-control ng-pristine ng-valid ng-star-inserted ng-touched']","Cardiologist","DoctorTypeBox");
//click cardiologist from dropdown
    Reusable_Actions.clickAction(driver,"//*[@id='ngb-typeahead-2-0']","ClickPopup");

    //click continue as guest from forced sign in pop up
    Reusable_Actions.clickAction(driver,"//*[@class='large-btns']","GuestPopUp");
//click continue without a plan
    Reusable_Actions.clickAction(driver,"//*[@class='btn']","ContinueWithOutPlan");
    //click more options
    Reusable_Actions.clickAction(driver,"//*[@class='filter-more']","moreOptions");
    //Click CheckBox for Accepting new patients
    Reusable_Actions.clickAction(driver,"//*[@class='cigna-checkbox-label ng-star-inserted']","CheckBoxAMP");
    //click apply new filter
    Reusable_Actions.clickAction(driver, "//*[@class='btn-filter']" ,"apply");
    }//end of test suite

    //User story 4- As a user when I search for someone that’s not in the CIGNA system, I should be informed, so I can search for someone else.
    @Test(dependsOnMethods = "navigateToCignaModule")
    public void Negative(){
        //click employer or school as provider
        Reusable_Actions.clickAction(driver ,"//*[@aria-label='Geolocation search']","provider/employer");
        //click doctor by name
        Reusable_Actions.clickAction(driver,"//*[@class='search-button active']","");
        // type in fake test doctor name to ensure no results should be found
        Reusable_Actions.sendKeysAction(driver,"//*[@class='search-button active']","Fake doctor name","doctor name,fake");
       //click dropdown result of text search
        Reusable_Actions.clickAction(driver,"//*[@class='dropdown-item ng-tns-c39-13 ng-trigger ng-trigger-typeaheadAnimation ng-star-inserted']","dropdownName");
        //view the no search results found page
    }//end of test

    //User Story 5: As a user I want to find a dentist, based on their distance from my home, so that I can have shorter commute.
@Test(dependsOnMethods = "navigateToCignaModule")
public void Dentist(){
    //click employer or school as provider
    Reusable_Actions.clickAction(driver ,"//*[@aria-label='Geolocation search']","provider/employer");
        //click on text box
        Reusable_Actions.clickAction(driver,"//*[@class='typeahead-input elastic-input__field placeholder-text ng-pristine ng-valid ng-touched']","LocationTextbox");
       //type location in text box
        Reusable_Actions.sendKeysAction(driver,"//*[@class='typeahead-input elastic-input__field placeholder-text ng-pristine ng-valid ng-touched']","11218","");
       //click zip in text box suggestion
        Reusable_Actions.clickAction(driver,"//*[@class='dropdown-item ng-tns-c39-0 ng-trigger ng-trigger-typeaheadAnimation ng-star-inserted active']","dropdownOfLocation");
    //click doctor by type button
    Reusable_Actions.clickByIndexAction(driver,"//*[@class='search-button']",0,"DoctorTypeTextBox");
//click doctor type text bar
    Reusable_Actions.clickAction(driver, "//*[@class='category-search-form__input form-control ng-pristine ng-valid ng-star-inserted ng-touched']","DoctorTypeTextBox");
    //type Dentist
    Reusable_Actions.sendKeysAction(driver,"//*[@class='category-search-form__input form-control ng-pristine ng-valid ng-star-inserted ng-touched']","Dentist","TypeDentist");
    //click dentist suggestion
    Reusable_Actions.clickAction(driver,"//*[@class='dropdown-options__button ng-star-inserted']","DentistSuggestion");
    //click continue as guest from forced sign in pop up
    Reusable_Actions.clickAction(driver,"//*[@class='large-btns']","GuestPopUp");
    //click continue without a plan
    Reusable_Actions.clickAction(driver,"//*[@class='btn']","ContinueWithOutPlan");
    //click sort filter dropdown
    Reusable_Actions.clickAction(driver,"//*[@id='sort-btn_zuepevewosf']","FilterDropdown");
    //click by distance
    Reusable_Actions.clickByIndexAction(driver,"//*[@role='menuitem']",1,"Distance dropdown filter");
    //user should be able to view dentist results nearest to you
    }//end of test 5

    //User Story 6: As a user I want to find a “Doctor by Name” so that I can see if he is covered under Cigna
@Test(dependsOnMethods = "navigateToCignaModule")
       public void DoctorByName() {
    //click employer or school as provider
    Reusable_Actions.clickAction(driver, "//*[@aria-label='Geolocation search']", "provider/employer");
    //click on text box
    Reusable_Actions.clickAction(driver, "//*[@class='typeahead-input elastic-input__field placeholder-text ng-pristine ng-valid ng-touched']", "LocationTextbox");
    //type location in text box
    Reusable_Actions.sendKeysAction(driver, "//*[@class='typeahead-input elastic-input__field placeholder-text ng-pristine ng-valid ng-touched']", "11218", "");
    //click zip in text box suggestion
    Reusable_Actions.clickAction(driver, "//*[@class='dropdown-item ng-tns-c39-0 ng-trigger ng-trigger-typeaheadAnimation ng-star-inserted active']", "dropdownOfLocation");
    //click doctor by name
    Reusable_Actions.clickByIndexAction(driver,"//*[@class='search-button']",1,"DoctorTypeTextBox");
    //click doctor name text bar
    Reusable_Actions.clickAction(driver,"//*[@class='category-search-form__input form-control ng-pristine ng-valid ng-star-inserted ng-touched;]","DoctorNameTextBar");
    //Type doctor name
    Reusable_Actions.sendKeysAction(driver,"//*[@class='category-search-form__input form-control ng-pristine ng-valid ng-star-inserted ng-touched']","Mohammed Khan","TypeDoctorName");
    //click Name Suggestion
    Reusable_Actions.clickAction(driver,"//*[@class='dropdown-item ng-tns-c39-11 ng-trigger ng-trigger-typeaheadAnimation ng-star-inserted active']","NameSuggestion");
    //click profession you are searching for
    Reusable_Actions.clickByIndexAction(driver,"//*[@class='category-card-md']",0,"DoctorByName");
    //Get text of Plans accepted
    Reusable_Actions.getTextAction(driver,"//*[@class='listings-body-layout__plan-info body-section']","PlansAccepted");
    }

    //After suite to quit driver/ get reports
    @AfterSuite
    public void quitSession(){
        driver.quit();
        //end of after suite
    }

//Failing
  //  public ExtentReports getReports() {
//return reports.
  //  }


}//end of class





