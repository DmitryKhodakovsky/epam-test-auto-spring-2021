package ru.training.at.lesson7.grid;

import org.openqa.selenium.WebDriver;

public class YandexMarketHomePage extends YandexMarketBasePage {

    public YandexMarketHomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        open("");
    }

}
