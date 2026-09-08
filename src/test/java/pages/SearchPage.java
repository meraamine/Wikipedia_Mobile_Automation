package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage {

    private final AndroidDriver driver;
    private final WebDriverWait wait;

    public SearchPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private final By searchButton =
            AppiumBy.accessibilityId("Search Wikipedia");

    public void clickSearch() {

        wait.until(
                ExpectedConditions.elementToBeClickable(searchButton)
        ).click();
    }
}