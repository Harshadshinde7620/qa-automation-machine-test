	package mobileAutomation.base;

	import java.net.MalformedURLException;
	import java.net.URL;
	import java.time.Duration;

	import org.openqa.selenium.remote.DesiredCapabilities;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;

	import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

	public class BaseTest {

	    public static AndroidDriver driver;

	    @BeforeClass
	    public void setup() throws MalformedURLException {

	    	UiAutomator2Options options = new UiAutomator2Options();

	    	options.setPlatformName("Android");
	    	options.setDeviceName("Pixel 6");
	    	options.setAutomationName("UiAutomator2");

	    	options.setApp("/Users/xenneotech/Downloads/location-app.apk");

	    	options.setAppPackage("com.example.smartlocationtackingapp");

	    	options.setAppActivity(
	    	    "com.example.smartlocationtackingapp.ui.MainActivity"
	    	);

	    	driver = new AndroidDriver(
	    	        new URL("http://127.0.0.1:4723"),
	    	        options
	    	);
	    }

	    @AfterClass
	    public void tearDown() {

	        if(driver != null) {

	            driver.quit();
	        }
	    }
	}

