package ru.training.at.lesson5.steps;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.Then;
import java.util.List;
import ru.training.at.lesson5.context.TestContext;
import ru.training.at.lesson5.cucumber.YandexMarketCompareProductPage;

public class YandexMarketCompareProductsStep {

    @Then("added product titles should be displayed on the Yandex Market Compare Products page")
    public void addedProductTitlesShouldBeDisplayedOnTheCompareProductsPage() {
        List<String> expectedProductNames =
            TestContext.getInstance().getTestObject(TestContext.PRODUCT_NAMES);
        List<String> actualProductNames =
            new YandexMarketCompareProductPage(
                TestContext.getInstance().getTestObject(TestContext.WEB_DRIVER))
                .getProductNames();

        assertThat(actualProductNames)
            .as("Incorrect products was added to compare list")
            .containsExactlyInAnyOrderElementsOf(expectedProductNames);
    }
}
