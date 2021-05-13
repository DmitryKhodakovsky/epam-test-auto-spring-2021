package ru.training.at.lesson7.grid;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.Test;

public class YandexMarketTest extends AbstractBaseTest {

    @Test
    public void addProductsToCompareListTest() {
        // 1. Open Yandex market Home Page
        YandexMarketHomePage homePage = new YandexMarketHomePage(driver);
        homePage.open();

        // 2. Select category of products
        homePage.selectCategory("Электроника");

        // 3. Select subcategory of products
        new YandexMarketCategoryPage(driver).selectCatalogItemPage("Смартфоны");

        // 4. Add products to compare list
        YandexMarketCatalogItemPage catalogItemPage = new YandexMarketCatalogItemPage(driver);
        String product1 = catalogItemPage.addProductToCompare(1);
        String product2 = catalogItemPage.addProductToCompare(2);

        List<String> expectedProductTitleList = new ArrayList<>();
        expectedProductTitleList.add(product1);
        expectedProductTitleList.add(product2);

        // 5. Click compare button
        catalogItemPage.clickCompareButton();

        // 6. Check that only added product names displayed on the page
        List<String> actualProductTitleList = new YandexMarketCompareProductPage(driver)
            .getProductNames();

        assertThat(actualProductTitleList)
            .as("Incorrect products was added to compare")
            .containsExactlyInAnyOrderElementsOf(expectedProductTitleList);
    }
}
