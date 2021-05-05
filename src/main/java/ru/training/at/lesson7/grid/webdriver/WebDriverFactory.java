package ru.training.at.lesson7.grid.webdriver;

import java.net.MalformedURLException;
import java.net.URL;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class WebDriverFactory {

    private static final String CHROME = "chrome";
    private static final String FIREFOX = "firefox";

    public static WebDriver createWebDriver(final String browserName) {
        WebDriver driver;

        if (CHROME.equalsIgnoreCase(browserName)) {
            driver = createChromeDriver();
        } else if (FIREFOX.equalsIgnoreCase(browserName)) {
            driver = createFirefoxDriver();
        } else {
            throw new IllegalArgumentException(String.format("Unsupported browser %s",
                browserName));
        }

        return driver;
    }

    private static WebDriver createChromeDriver() {
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
                new ChromeOptions());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

    private static WebDriver createFirefoxDriver() {
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
                new FirefoxOptions());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
