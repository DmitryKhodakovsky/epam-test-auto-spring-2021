package ru.training.at.lesson7.grid;

import org.openqa.selenium.WebDriver;
import ru.training.at.lesson7.grid.component.BaseComponent;
import ru.training.at.lesson7.grid.component.HeaderComponent;

public abstract class YandexMarketBasePage extends BaseComponent {

    private static final String BASE_URL = "https://market.yandex.ru";

    protected HeaderComponent header;

    protected YandexMarketBasePage(WebDriver driver) {
        super(driver);
        header = new HeaderComponent(driver);
    }

    public void selectCategory(String categoryName) {
        header.selectCategory(categoryName);
    }

    public void sendKeysToSearchInputField(String searchText) {
        header.sendKeysToSearchInputField(searchText);
    }

    public void clickToSearchButton() {
        header.clickToSearchButton();
    }

    protected void open(String url) {
        driver.navigate().to(BASE_URL + url);
    }
}
