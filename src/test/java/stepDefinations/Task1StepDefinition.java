package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.ValidatableResponseOptions;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


import java.time.Duration;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class Task1StepDefinition {
	
	Response response;
	WebDriver driver = hooks.driver;
	

	@Given("User creates a new lead using POST API")
	public void user_creates_a_new_lead_using_post_api() {

	    //RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

	    Map<String, Object> payload = new HashMap<>();

	    payload.put("name", "Harshad Shinde");
	    payload.put("phone", "9876543210");

	    Map<String, String> geo = new HashMap<>();
	    geo.put("lat", "18.7895");
	    geo.put("lng", "75.897");

	    payload.put("geo", geo);

	    response =
	            given()
	                .header("Content-Type", "application/json")
	                .body(payload)
	            .when()
	                .post("https://jsonplaceholder.typicode.com/users");

	    response.then()
	            .statusCode(201)
	            .body("name", equalTo("Harshad Shinde"));

	    System.out.println("POST RESPONSE:");
	    response.prettyPrint();
	}

	@Then("User verifies GET API response is successful")
	public void user_verifies_get_api_response_is_successful() {
	  
		Response getResponse= 
				given()
				.when()
					.get("https://jsonplaceholder.typicode.com/users");
		
		getResponse.then()
			.statusCode(200);
		
		System.out.println("Get API Validated sucessfully");
	}

	@When("User launches the demo login page")
	public void user_launches_the_demo_login_page() {

	    driver = hooks.driver;

	    driver.get("https://the-internet.herokuapp.com/login");

	    driver.manage().window().maximize();

	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("User enters valid username and password")
	public void user_enters_valid_username_and_password() {

	    driver.findElement(By.id("username"))
	            .sendKeys("tomsmith");

	    driver.findElement(By.id("password"))
	            .sendKeys("SuperSecretPassword!");
	}

	@When("User clicks on login button")
	public void user_clicks_on_login_button() {

	    driver.findElement(By.cssSelector("button[type='submit']"))
	            .click();
	}

	@Then("User should navigate to secure area successfully")
	public void user_should_navigate_to_secure_area_successfully() {

	    String successMessage =
	            driver.findElement(By.id("flash")).getText();

	    Assert.assertTrue(
	            successMessage.contains("You logged into a secure area!"),
	            "Login Validation Failed"
	    );

	    System.out.println("UI Login Successful");
	}



}
