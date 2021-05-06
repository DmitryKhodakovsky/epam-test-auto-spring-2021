package ru.training.at.lesson5.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import ru.training.at.lesson5.context.TestContext;
import ru.training.at.lesson5.cucumber.YandexMarketCatalogItemPage;
import ru.training.at.lesson5.cucumber.YandexMarketCategoryPage;
import ru.training.at.lesson5.cucumber.YandexMarketHomePage;

public class CommonStep {

    @Given("I open Yandex Market Home page")
    public void openYandexMarketHomePage() {
        new YandexMarketHomePage(TestContext.getInstance()
                                            .getTestObject(TestContext.WEB_DRIVER)).open();
    }

    @Given("I open subcategory {string} in category {string} from menu section")
    public void openSubcategoryInCategoryFromMenuSection(String subcategory, String category) {
        new YandexMarketHomePage(TestContext.getInstance()
                                            .getTestObject(TestContext.WEB_DRIVER))
            .selectCategory(category);
        new YandexMarketCategoryPage(TestContext.getInstance()
                                                .getTestObject(TestContext.WEB_DRIVER))
            .selectCatalogItemPage(subcategory);
    }

    @When("I click 'Сравнить' button in the pop-up header of the page")
    public void clickCompareButtonInThePopUpHeaderOfThePage() {
        new YandexMarketCatalogItemPage(TestContext.getInstance()
                                                   .getTestObject(TestContext.WEB_DRIVER))
            .clickCompareButton();
    }
}
