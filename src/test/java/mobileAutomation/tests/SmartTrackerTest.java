package mobileAutomation.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import mobileAutomation.base.BaseTest;
import mobileAutomation.pages.SmartTrackerPage;

public class SmartTrackerTest extends BaseTest {

    SmartTrackerPage page = new SmartTrackerPage();

    @Test
    public void validateLocationTrackingFlow() {

        // Click Start Tracking Service button
        driver.findElement(page.startTrackingButton).click();

        System.out.println("Clicked Start Tracking Service button");

        // Handle precise location option if displayed
        try {

            driver.findElement(page.preciseLocationToggle).click();

            System.out.println("Precise location selected");

        } catch (Exception e) {

            System.out.println("Precise location option not displayed");
        }

        // Click While Using App permission
        driver.findElement(page.allowWhileUsingAppButton).click();

        System.out.println("Location permission granted");

        // Verify Stop Tracking Service button
        WebElement stopButton =
                driver.findElement(page.stopTrackingButton);

        Assert.assertTrue(stopButton.isDisplayed(),
                "Stop Tracking Service button not displayed");

        System.out.println("Tracking service started successfully");

        // Verify Location Update log
        WebElement locationLog =
                driver.findElement(page.locationUpdateLog);

        Assert.assertTrue(locationLog.isDisplayed(),
                "Location Update log not displayed");

        // Verify Latitude and Longitude
        String coordinates =
                driver.findElement(page.latLngLog).getText();

        Assert.assertTrue(coordinates.contains("Lat:"));
        Assert.assertTrue(coordinates.contains("Lng:"));

        System.out.println("Location logs validated successfully");
    }
}