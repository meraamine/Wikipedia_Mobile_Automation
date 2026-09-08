# Wikipedia Mobile Automation

Mobile UI automation project for testing the Wikipedia Android application using **Appium, Java, TestNG, and Page Object Model (POM)**.

The project automates the following scenario:

> Open Wikipedia → Complete Onboarding → Navigate to Search → Search for "Artificial Intelligence" → Open the article → Close the popup → Save the article.


## Tech Stack

| Technology | Version |
|---|---|
| Java | 21 |
| Appium Java Client | 10.1.1 |
| Appium Server | 2.x |
| TestNG | 7.12.0 |
| Maven | 3.9.16 |
| Automation Engine | UiAutomator2 |
| Platform | Android |
| IDE | IntelliJ IDEA |
| Device | Android Emulator |
Appium Inspector

Appium Inspector is used to inspect the Android application's UI hierarchy and identify reliable locators for automation.

It helps identify:

Resource IDs
Class names
Text values
Content descriptions
UI hierarchy
Element properties
UiAutomator selectors
Inspector Configuration

The Inspector connects to the Appium Server using:

- Remote Host: 127.0.0.1
- Remote Port: 4723
- Remote Path: /
- Android Capabilities

The following capabilities are used:

- Platform Name: Android
- Automation Name: UiAutomator2
- Device Name: emulator-5554
- App Package: org.wikipedia
- App Activity: org.wikipedia.main.MainActivity

Equivalent Java configuration:

- options.setPlatformName("Android");
- options.setAutomationName("UiAutomator2");
- options.setDeviceName("emulator-5554");
- options.setAppPackage("org.wikipedia");
- options.setAppActivity("org.wikipedia.main.MainActivity");
- Locator Identification

Appium Inspector was used to inspect the Wikipedia application and identify elements such as:

Search Tab
Search Input
Artificial Intelligence Search Result
Article Save Button
Popup Close Button

Example resource IDs identified during inspection:

org.wikipedia:id/nav_tab_search
org.wikipedia:id/search_card
org.wikipedia:id/search_src_text
org.wikipedia:id/page_save
org.wikipedia:id/closeButton

The inspected locators are then used inside the Page Object classes to separate UI element identification from test logic.
---

https://github.com/user-attachments/assets/2a177dea-362f-41d0-b602-fa6e7b2ebf81


## Project Structure

```text
Wikipedia_Mobile_Automation
│
├── pom.xml
├── README.md
│
└── src
    └── test
        └── java
            │
            ├── base
            │   └── BaseTest.java
            │
            ├── pages
            │   ├── ArticlePage.java
            │   ├── HomePage.java
            │   ├── OnboardingPage.java
            │   └── SearchPage.java
            │
            └── tests
                └── SearchTest.java
```

---

## Framework Design

The project follows the **Page Object Model (POM)** design pattern.

### BaseTest

`BaseTest.java`

Responsible for:

- Configuring Appium capabilities.
- Starting the AndroidDriver.
- Connecting to the Android emulator.
- Launching the Wikipedia application.
- Completing the onboarding flow.
- Closing the driver after each test.

### Page Objects

#### OnboardingPage

Handles the initial Wikipedia onboarding screens.

```java
onboardingPage.completeOnboarding();
```

#### HomePage

Handles actions available on the Wikipedia home screen.

```java
homePage.clickSearch();
```

#### SearchPage

Handles the search flow:

- Closing the search popup.
- Opening the search field.
- Entering the search text.
- Selecting the search result.

Example:

```java
searchPage.clickSearchField();
searchPage.enterSearchText("Artificial Intelligence");
searchPage.clickFirstSearchResult();
```

#### ArticlePage

Handles actions inside the article page:

- Closing the article popup.
- Saving the article.

Example:

```java
articlePage.closePopup();
articlePage.clickSave();
```

---

## Test Scenario

### Search and Save Article

**Test Name:**

```text
searchForArticle
```

### Test Steps

1. Launch the Wikipedia Android application.
2. Complete the onboarding screens.
3. Navigate to the Search tab.
4. Close the search popup if displayed.
5. Open the search field.
6. Search for:
   ```text
   Artificial Intelligence
   ```
7. Select the search result.
8. Close the article popup.
9. Click the Save button.

### Expected Result

The **Artificial Intelligence** article should be opened successfully and the user should be able to save the article.

---

## Prerequisites

Before running the project, make sure the following are installed:

### 1. Java JDK

Java 21 is used in this project.

Verify the installation:

```bash
java -version
```

Expected output should show Java 21.

---

### 2. Maven

Verify Maven:

```bash
mvn -version
```

---

### 3. Android SDK

Make sure Android SDK is installed and the following are available:

- Android SDK Platform
- Android SDK Platform-Tools
- Android Emulator

Verify ADB:

```bash
adb version
```

---

### 4. Android Emulator

Create and start an Android emulator.

The project currently uses:

```text
emulator-5554
```

Verify the connected device:

```bash
adb devices
```

Expected example:

```text
List of devices attached
emulator-5554    device
```

---

### 5. Appium Server

Install Appium 2 and the UiAutomator2 driver.

Start Appium using:

```bash
appium
```

The project connects to:

```text
http://127.0.0.1:4723
```

---

## App Configuration

The project uses the following Wikipedia application configuration:

```java
options.setPlatformName("Android");
options.setAutomationName("UiAutomator2");
options.setDeviceName("emulator-5554");
options.setAppPackage("org.wikipedia");
options.setAppActivity("org.wikipedia.main.MainActivity");
```

Make sure the Wikipedia application is installed on the emulator.

You can verify the package using:

```bash
adb shell pm list packages | findstr wikipedia
```

---

## Dependencies

The main dependencies are configured in `pom.xml`.

### Appium Java Client

```xml
<dependency>
    <groupId>io.appium</groupId>
    <artifactId>java-client</artifactId>
    <version>10.1.1</version>
</dependency>
```

### TestNG

```xml
<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.12.0</version>
    <scope>compile</scope>
</dependency>
```

---

## How to Run

### Step 1 — Start Android Emulator

Start your Android emulator and verify:

```bash
adb devices
```

---

### Step 2 — Start Appium

Run:

```bash
appium
```

Appium should start on:

```text
http://127.0.0.1:4723
```

---

### Step 3 — Run the Tests

From the project root directory:

```bash
mvn test
```

Or run the test directly from IntelliJ IDEA:

```text
SearchTest.java
→ Right Click
→ Run 'SearchTest'
```

---

## Test Flow

```text
Start Appium
     │
     ▼
Launch Wikipedia
     │
     ▼
Complete Onboarding
     │
     ▼
Home Page
     │
     ▼
Click Search
     │
     ▼
Close Popup
     │
     ▼
Open Search Field
     │
     ▼
Search "Artificial Intelligence"
     │
     ▼
Open Article
     │
     ▼
Close Popup
     │
     ▼
Click Save
     │
     ▼
Test Complete
```

---

## Locators

The project uses different locator strategies depending on the UI element.

Examples:

### Resource ID

```java
AppiumBy.id("org.wikipedia:id/page_save");
```

### Class Name

```java
AppiumBy.className("android.widget.Button");
```

### UiAutomator

```java
AppiumBy.androidUIAutomator(
    "new UiSelector().text(\"Artificial intelligence\")"
);
```

The project primarily uses **resource IDs** where available because they are generally more stable than position-based locators.

---

## Explicit Waits

The framework uses Selenium `WebDriverWait` with explicit waits instead of fixed sleeps.

Example:

```java
wait.until(
    ExpectedConditions.elementToBeClickable(saveButton)
).click();
```

This helps make the test more stable when dealing with Android UI loading times and dynamic elements.

---

## Test Architecture

```text
                 BaseTest
                    │
                    │
        ┌───────────┴───────────┐
        │                       │
   Page Objects              Tests
        │                       │
        ├── OnboardingPage      │
        ├── HomePage            │
        ├── SearchPage ◄────────┤
        └── ArticlePage         │
                                │
                          SearchTest
```

The test classes contain the test flow, while page classes contain the UI locators and page-specific actions.

---

## Important Notes

- The emulator must be running before executing the test.
- Appium Server must be running on port `4723`.
- The device name in `BaseTest` must match the connected emulator.
- The Wikipedia application package must be installed.
- The current test expects the search result **Artificial intelligence** to be available.
- Popups are handled before interacting with the relevant page elements.

---

## Future Improvements

Possible improvements for the framework include:

- Add assertions to verify the article was opened successfully.
- Add an assertion to verify that the article was saved.
- Improve popup handling so it only closes when the popup is actually displayed.
- Add reusable utility methods for common Appium actions.
- Add configuration management for device and Appium server settings.
- Add screenshots when tests fail.
- Add TestNG listeners for better reporting.
- Add test data management.
- Add CI/CD integration using GitHub Actions.
- Add additional positive and negative test scenarios.

---

## Author

**Marina Amine**

Software Testing / QA Automation

Technologies: Java, Selenium, Appium, TestNG, Maven, API Testing, Manual Testing
