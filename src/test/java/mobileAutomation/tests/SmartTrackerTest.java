package mobileAutomation.tests;

import org.openqa.selenium.By;

public class SmartTrackerTest {

    public By startTrackingButton =
            By.xpath("//android.widget.Button[@text='Start Tracking Service']");

    public By stopTrackingButton =
            By.xpath("//android.widget.Button[@text='Stop Tracking Service']");

    public By allowWhileUsingAppButton =
            By.xpath("//android.widget.Button[contains(@text,'While using')]");

    public By preciseLocationToggle =
            By.id("com.android.permissioncontroller:id/permission_location_accuracy_radio_fine");

    public By locationUpdateLog =
            By.xpath("//*[contains(@text,'Location Update')]");

    public By latLngLog =
            By.xpath("//*[contains(@text,'Lat:') and contains(@text,'Lng:')]");
}