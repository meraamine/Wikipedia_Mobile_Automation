package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.OnboardingPage;

public class SearchTest extends BaseTest {

    @Test
    public void openSearchPage() {

        OnboardingPage onboardingPage =
                new OnboardingPage(driver);

        HomePage homePage =
                new HomePage(driver);

        onboardingPage.completeOnboarding();

        homePage.clickSearch();
    }
}/*package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.SearchPage;

public class SearchTest extends BaseTest {

    @Test
    public void searchWikipedia() {

        SearchPage searchPage =
                new SearchPage(driver);

        searchPage.clickSearch();
    }
}*/