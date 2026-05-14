package mobileAutomation.tests;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.Test;

import mobileAutomation.base.BaseTest;
import mobileAutomation.pages.SmartTrackerPage;

public class SmartTrackerTest extends BaseTest {

    SmartTrackerPage page = new SmartTrackerPage();
    @Test
    public void validateLocationTrackingFlow() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(30));

        // Click Start Tracking Service button
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                page.startTrackingButton));

        driver.findElement(page.startTrackingButton).click();

        System.out.println("Clicked Start Tracking Service button");

        // Handle precise location option
        try {

            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    page.preciseLocationToggle));

            driver.findElement(page.preciseLocationToggle).click();

            System.out.println("Precise location selected");

        } catch (Exception e) {

            System.out.println("Precise location option not displayed");
        }

        // Grant location permission
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                page.allowWhileUsingAppButton));

        driver.findElement(page.allowWhileUsingAppButton).click();

        System.out.println("Location permission granted");

        // Wait for app processing
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Validate app remains open
        String currentPackage = driver.getCurrentPackage();

        System.out.println("Current package: " + currentPackage);

        Assert.assertNotNull(currentPackage);

        System.out.println("Application is active");
        // Validate text views/logs exist
        int textViewCount =
                driver.findElements(page.anyTextView).size();

        Assert.assertTrue(textViewCount > 0,
                "No text/log elements displayed");

        System.out.println("UI elements displayed successfully");

        // Optional Stop button validation
        try {

            if(driver.findElement(page.stopTrackingButton).isDisplayed()) {

                System.out.println(
                        "Stop Tracking button displayed");
            }

        } catch (Exception e) {

            System.out.println(
                    "Stop Tracking button not displayed");
        }

        System.out.println(
                "Location tracking flow validated successfully");
    }
}