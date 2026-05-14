package mobileAutomation.pages;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;

public class SmartTrackerPage {

    // Start Tracking Button
    public By startTrackingButton =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().textContains(\"Start\")");

    // Stop Tracking Button
    public By stopTrackingButton =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().textContains(\"Stop\")");

    // While Using App Permission
    public By allowWhileUsingAppButton =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().textContains(\"While\")");

    // Precise Location Toggle
    public By preciseLocationToggle =
            By.id("com.android.permissioncontroller:id/permission_location_accuracy_radio_fine");

    // Generic TextView locator
    public By anyTextView =
            By.className("android.widget.TextView");
}