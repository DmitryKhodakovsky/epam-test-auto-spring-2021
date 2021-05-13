package ru.training.at.lesson7.grid.component;

import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfNestedElementLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ProductCardComponent extends BaseComponent {

    private WebElement productCard;

    public ProductCardComponent(WebDriver driver, WebElement productCard) {
        super(driver);
        this.productCard = productCard;
    }

    public String getProductName() {
        return wait.until(visibilityOf(productCard
            .findElement(xpath(".//div//child::h3[@data-zone-name='title']")))).getText().trim();
    }

    public void clickToAddToCompareButton() {
        WebElement addToCompare = wait.until(presenceOfNestedElementLocatedBy(productCard,
            xpath(".//div[contains(@aria-label, 'сравнению')]")));
        new Actions(driver)
            .moveToElement(addToCompare)
            .click()
            .build()
            .perform();
    }
}
