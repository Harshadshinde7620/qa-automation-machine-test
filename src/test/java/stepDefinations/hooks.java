package stepDefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class hooks {

    public static WebDriver driver;

    @Before
    public void setup() {

        driver = new ChromeDriver();

    }

    @After
    public void tearDown() {

        if(driver != null) {
            driver.quit();
        }
    }
}
	/*
	public static WebDriver driver;
    public static AppiumDriver mobileDriver;

    // Change this value based on execution
    // web = Selenium
    // mobile = Appium
    //public static String executionType = "web";

    @Before
    public void setup() {

        /*WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts()
              .implicitlyWait(Duration.ofSeconds(10));
    }*/

   /* public void user_launches_the_demo_login_page() {

    	 driver.get("https://the-internet.herokuapp.com/login");
        //driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
*/

  /*  @After
    public void teardown() {

        System.out.println("Execution Completed");

        if (driver != null) {
            driver.quit();
        }

        if (mobileDriver != null) {
            mobileDriver.quit();
        }
    }
*/
   
