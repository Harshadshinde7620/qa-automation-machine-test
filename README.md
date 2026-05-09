````md
# QA Automation Engineer - Machine Test

## Project Overview

This repository contains solutions for the QA Automation Engineer machine test.  
The project demonstrates Web UI Automation, API Automation, Native Android Automation using Appium, and architecture strategy discussions for advanced mobile testing scenarios.

The framework is developed using Java, Selenium WebDriver, Rest Assured, Appium, TestNG, and Cucumber BDD with Maven as the build management tool.

---

# Technologies Used

- Java
- Selenium WebDriver
- Rest Assured
- Appium
- TestNG
- Cucumber BDD
- Maven
- Android Emulator
- UiAutomator2

---

# Project Structure

```text
SmartTrackerAppiumProject
│
├── src/test/java
│      ├── mobileAutomation.base
│      │      └── BaseTest.java
│      │
│      ├── mobileAutomation.pages
│      │      └── SmartTrackerPage.java
│      │
│      ├── mobileAutomation.tests
│      │      └── SmartTrackerTest.java
│      │
│      ├── stepDefinations
│      │      ├── Hooks.java
│      │      └── Task1StepDefinition.java
│      │
│      ├── testRunner
│      │      └── TestRunner.java
│      │
│      └── utilities
│             └── DriverFactory.java
│
├── src/test/resources
│      └── features
│             └── LeadAssignment.feature
│
├── pom.xml
├── testng.xml
└── README.md
````

---

# Task 1 - Web UI & API Data Sync Validation

## API Automation

The framework performs the following API validations using Rest Assured:

* Sends a POST request to:

  ```text
  https://jsonplaceholder.typicode.com/users
  ```

* Sends mock lead data containing:

  * Name
  * Phone Number
  * Geo Coordinates

* Performs a GET request to verify:

  * API response status code
  * Successful API communication

## Web UI Automation

Selenium WebDriver automation is implemented for:

* Launching:

  ```text
  https://the-internet.herokuapp.com/login
  ```

* Entering credentials:

  ```text
  Username: tomsmith
  Password: SuperSecretPassword!
  ```

* Validating successful login into secure area.

## Integration Flow

The framework demonstrates how API setup steps can be chained before UI validation steps inside a single automated test flow using Cucumber and TestNG.

---

# Task 2 - Native Android & Hardware Interaction Scripting

The Appium framework demonstrates automation logic for a native Android application named:

```text
com.example.smartlocationtackingapp
```

## Automated Flow Covered

* Launch Android application using Appium
* Click "Start Tracking Service"
* Handle native Android location permission popup
* Enable precise location access if available
* Click "While using the app"
* Verify button changes to:

  ```text
  Stop Tracking Service
  ```
* Validate activity logs contain:

  ```text
  Location Update
  Lat:
  Lng:
  ```

## Framework Design

The Appium framework follows the Page Object Model (POM) design pattern:

* BaseTest → Driver setup and teardown
* Page Class → Element locators
* Test Class → Test execution and validations

## Assumptions

Since APK and actual UI hierarchy were not provided, inferred Android locators such as XPath and Android resource IDs were used based on visible UI text.

---

# Task 3 - Edge Case & Architecture Strategy

## 1. Location Spoofing Strategy

To test the "Virtual Surprise Visit" feature, mock GPS coordinates can be injected into the Android emulator using Appium’s location APIs or Android Emulator Extended Controls. A scheduler or automation loop can update the device location every 10 minutes using predefined latitude and longitude datasets. This approach simulates real-world agent movement and helps validate geofencing, background tracking, and live location synchronization features. For scalable execution, location datasets can also be maintained externally in JSON or Excel files and dynamically consumed during runtime.

---

## 2. Audio / Telecom Validation Strategy

Standard UI automation can verify that a recording file is created successfully, but it cannot confirm whether the recording contains actual voice data. To automate this validation conceptually, the recorded audio file can be analyzed using audio-processing libraries or speech-recognition services. The framework can validate waveform amplitude, decibel levels, duration, and non-silent audio frequencies to ensure the recording is not empty or silent. Additionally, speech-to-text APIs such as Google Speech API can be integrated to confirm the presence of spoken words inside the recording.

---

# Maven Dependencies

Main dependencies used in the framework:

* Selenium Java
* TestNG
* Rest Assured
* Cucumber Java
* Cucumber TestNG
* Appium Java Client

---

# Execution

## Run Cucumber Tests

Execute using TestNG runner or Maven commands.

## Run Appium Tests

Start Appium server and Android emulator before execution.

Example Appium Server:

```text
http://127.0.0.1:4723
```

---

# Note

The API automation code is fully implemented and logically validated.
During execution in the current environment, external network restrictions caused:

```text
java.net.SocketException: Network is unreachable
```

while accessing JSONPlaceholder APIs.

The automation framework and implementation logic remain complete and functional.

---

## 👤 Author

**Harshad Chandrakant Shinde**
QA Automation Engineer | 3.5+ Years Experience
📧 harshadshinde.work@gmail.com
🔗 [LinkedIn](https://www.linkedin.com/in/) | [GitHub](https://github.com/Harshadshinde7620)

---

## 📄 License

This project is open-source and available under the [MIT License](LICENSE).
