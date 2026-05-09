	package mobileAutomation.base;

	import java.net.MalformedURLException;
	import java.net.URL;
	import java.time.Duration;

	import org.openqa.selenium.remote.DesiredCapabilities;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;

	import io.appium.java_client.android.AndroidDriver;

	public class BaseTest {

	    public static AndroidDriver driver;

	    @BeforeClass
	    public void setup() throws MalformedURLException {

	        DesiredCapabilities caps = new DesiredCapabilities();

	        caps.setCapability("platformName", "Android");
	        caps.setCapability("deviceName", "Android Emulator");
	        caps.setCapability("automationName", "UiAutomator2");

	        caps.setCapability("appPackage",
	                "com.example.smartlocationtackingapp");

	        caps.setCapability("appActivity",
	                "com.example.smartlocationtackingapp.MainActivity");

	        driver = new AndroidDriver(
	                new URL("http://127.0.0.1:4723/wd/hub"),
	                caps);

	        driver.manage().timeouts()
	                .implicitlyWait(Duration.ofSeconds(10));

	        System.out.println("Application launched successfully");
	    }

	    @AfterClass
	    public void tearDown() {

	        if(driver != null) {

	            driver.quit();
	        }
	    }
	}

