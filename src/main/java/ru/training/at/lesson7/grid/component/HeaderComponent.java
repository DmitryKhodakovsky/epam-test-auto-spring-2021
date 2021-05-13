package ru.training.at.lesson7.grid.component;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import java.util.List;
import java.util.Optional;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderComponent extends BaseComponent {

    @FindBy(css = "[data-zone-name='category-link'] span")
    private List<WebElement> categoryItems;

    @FindBy(id = "header-search")
    private WebElement searchInputField;

    @FindBy(xpath = "//button[./div[text()='Найти']]")
    private WebElement searchButton;

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public void selectCategory(String categoryName) {
        Optional<WebElement> category = categoryItems
            .stream()
            .filter(categoryItem -> categoryItem.getText().equalsIgnoreCase(categoryName))
            .findFirst();

        category.ifPresent(WebElement::click);
    }

    public void sendKeysToSearchInputField(String text) {
        wait.until(visibilityOf(searchInputField)).sendKeys(text);
    }

    public void clickToSearchButton() {
        wait.until(elementToBeClickable(searchButton)).click();
    }
}
