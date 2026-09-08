package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private final AndroidDriver driver;
    private final WebDriverWait wait;

    public HomePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private final By searchTab =
        By.id("org.wikipedia:id/nav_tab_search");
        //    AppiumBy.cssSelector("[resource-id='org.wikipedia:id/nav_tab_search']");
            //AppiumBy.xpath("//*[@resource-id='org.wikipedia:id/nav_tab_search']");

    public void clickSearch() {

        WebElement searchElement = wait.until(
                ExpectedConditions.elementToBeClickable(searchTab)
        );

        searchElement.click();
    }
}
/*package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private final AndroidDriver driver;
    private final WebDriverWait wait;

    public HomePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private final By searchTab =
            AppiumBy.accessibilityId("Search");

    public void clickSearch() {

        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(searchTab)
        );

        element.click();
    }
}*/