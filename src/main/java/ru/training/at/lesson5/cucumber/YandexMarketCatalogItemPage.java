package ru.training.at.lesson5.cucumber;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.training.at.lesson5.cucumber.component.ProductCardComponent;

public class YandexMarketCatalogItemPage extends YandexMarketBasePage {

    @FindBy(css = "[data-autotest-id='product-snippet']")
    private List<WebElement> products;

    @FindBy(xpath = "//a/span[text()='Сравнить']")
    private WebElement compareButton;

    public YandexMarketCatalogItemPage(WebDriver driver) {
        super(driver);
    }

    public void clickCompareButton() {
        wait.until(elementToBeClickable(compareButton)).click();
    }

    public List<String> getProductNames() {
        return products
            .stream()
            .map(product -> new ProductCardComponent(driver, product))
            .collect(Collectors.toList())
            .stream()
            .map(ProductCardComponent::getProductName)
            .collect(Collectors.toList());
    }

    public String addProductToCompare(int index) {
        return addProductToCompare(new ProductCardComponent(driver, products.get(index - 1)));
    }

    private String addProductToCompare(ProductCardComponent productCard) {
        productCard.clickToAddToCompareButton();
        String productName = productCard.getProductName();
        int lastCommaIndex = productName.lastIndexOf(",");
        return lastCommaIndex == -1 ? productName : productName.substring(0, lastCommaIndex);
    }
}
