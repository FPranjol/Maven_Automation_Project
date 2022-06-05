package Day8_052122;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class getTitle_example {
    public static void main(String[] args) {

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

    String actualTitle=driver.getTitle();
    if (actualTitle.equals("Google")){
        System.out.println("my title matches");
    }else {
        System.out.println("title doesnt match. Actual title is " + actualTitle);

    }

    }

}
