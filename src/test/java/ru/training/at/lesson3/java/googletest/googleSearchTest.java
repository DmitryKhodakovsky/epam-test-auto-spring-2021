package ru.training.at.lesson3.java.googletest;

import com.epam.training.center.qa.at.lesson3.main.java.pages.SearchPage;
import com.google.inject.Inject;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class googleSearchTest extends BaseTest {

    @Inject
    private SearchPage searchPage;
//    private WebDriver webDriver;
//    @Before
//    public void init() {
//        searchPage = new SearchPage(webDriver);
//    }

    @Test
    public void testGoogleSearch() {
        searchPage.openGooglePage();

        searchPage.searchText("yandex.ru");
        searchPage.verifyFirstSuggestion("yandex.ru");

    }

}
