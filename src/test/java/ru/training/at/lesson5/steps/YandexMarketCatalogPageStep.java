package ru.training.at.lesson5.steps;

import io.cucumber.java.en.When;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import ru.training.at.lesson5.context.TestContext;
import ru.training.at.lesson5.cucumber.YandexMarketCatalogItemPage;

public class YandexMarketCatalogPageStep {

    @When("I add products {string} to compare list on Yandex Market Catalog page")
    public void addProductsToCompareListOnYandexMarketCatalogPage(String productIndexes) {
        List<Integer> indexes = Arrays.stream(productIndexes.split(","))
                                      .map(Integer::parseInt)
                                      .collect(Collectors.toList());

        YandexMarketCatalogItemPage catalogItemPage =
            new YandexMarketCatalogItemPage(TestContext.getInstance()
                                                       .getTestObject(TestContext.WEB_DRIVER));
        List<String> productNames = new ArrayList<>();
        for (int index : indexes) {
            productNames.add(catalogItemPage.addProductToCompare(index));
        }

        TestContext.getInstance().setTestObject(TestContext.PRODUCT_NAMES,
            productNames);
    }
}
