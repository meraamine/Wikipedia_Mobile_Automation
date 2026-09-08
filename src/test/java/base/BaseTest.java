package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.OnboardingPage;

import java.net.MalformedURLException;
import java.net.URI;

public class BaseTest {

    protected AndroidDriver driver;

    protected UiAutomator2Options options = new UiAutomator2Options();

    @BeforeMethod
    public void setUp() throws MalformedURLException {

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("emulator-5554");
        options.setAppPackage("org.wikipedia");
        options.setAppActivity("org.wikipedia.main.MainActivity");

        driver = new AndroidDriver(
                URI.create("http://127.0.0.1:4723").toURL(),
                options
        );

        OnboardingPage onboardingPage =
                new OnboardingPage(driver);

        onboardingPage.completeOnboarding();
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}