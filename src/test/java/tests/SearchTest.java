package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.ArticlePage;
import pages.HomePage;
import pages.SearchPage;

public class SearchTest extends BaseTest {

    @Test
    public void searchForArticle() {

        HomePage homePage = new HomePage(driver);
        SearchPage searchPage = new SearchPage(driver);
        ArticlePage articlePage = new ArticlePage(driver);

        homePage.clickSearch();
        searchPage.closePopup();
        searchPage.clickSearchField();
        searchPage.enterSearchText("Artificial Intelligence");
        searchPage.clickFirstSearchResult();
        articlePage.closePopup();
        articlePage.clickSave();

    }
}
