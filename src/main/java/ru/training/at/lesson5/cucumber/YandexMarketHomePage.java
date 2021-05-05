package ru.training.at.lesson5.cucumber;

import org.openqa.selenium.WebDriver;

public class YandexMarketHomePage extends YandexMarketBasePage {

    public YandexMarketHomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        open("");
    }

}
