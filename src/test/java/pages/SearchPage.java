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

    private final By closeButton =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().className(\"android.widget.Button\").instance(0)"
            );

    private final By searchCard =
            By.id("org.wikipedia:id/search_card");
    private final By searchInput =
            AppiumBy.id("org.wikipedia:id/search_src_text");
    private final By firstSearchResult =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().text(\"Artificial intelligence\")"
            );

    public void closePopup() {

        wait.until(
                ExpectedConditions.elementToBeClickable(closeButton)
        ).click();
    }

    public void clickSearchField() {

        wait.until(
                ExpectedConditions.elementToBeClickable(searchCard)
        ).click();

        wait.until(
                ExpectedConditions.invisibilityOfElementLocated(searchCard)
        );
    }
    public void enterSearchText(String text) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(searchInput)
        ).sendKeys(text);
    }
    public void clickFirstSearchResult() {

        wait.until(
                ExpectedConditions.elementToBeClickable(firstSearchResult)
        ).click();

    }
}

