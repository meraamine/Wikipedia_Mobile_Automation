package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OnboardingPage {

    private final AndroidDriver driver;
    private final WebDriverWait wait;

    public OnboardingPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private final By nextButton =
            AppiumBy.className("android.widget.Button");

    public void completeOnboarding() {

        for (int i = 0; i < 4; i++) {
            wait.until(
                    ExpectedConditions.elementToBeClickable(nextButton)
            ).click();
        }
    }
}