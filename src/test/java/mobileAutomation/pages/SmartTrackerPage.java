package mobileAutomation.pages;

import org.openqa.selenium.By;

public class SmartTrackerPage {

    // Start Tracking Button
    public By startTrackingButton =
            By.xpath("//android.widget.Button[@text='Start Tracking Service']");

    // Stop Tracking Button
    public By stopTrackingButton =
            By.xpath("//android.widget.Button[@text='Stop Tracking Service']");

    // While Using App Permission
    public By allowWhileUsingAppButton =
            By.xpath("//android.widget.Button[contains(@text,'While using')]");

    // Precise Location Toggle
    public By preciseLocationToggle =
            By.id("com.android.permissioncontroller:id/permission_location_accuracy_radio_fine");

    // Location Update Log
    public By locationUpdateLog =
            By.xpath("//*[contains(@text,'Location Update')]");

    // Latitude Longitude Log
    public By latLngLog =
            By.xpath("//*[contains(@text,'Lat:') and contains(@text,'Lng:')]");
}