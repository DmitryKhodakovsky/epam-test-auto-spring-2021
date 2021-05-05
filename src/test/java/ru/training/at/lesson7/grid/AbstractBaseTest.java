package ru.training.at.lesson7.grid;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.training.at.lesson7.grid.webdriver.WebDriverFactory;

public abstract class AbstractBaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        //        try {
        //            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
        //            new FirefoxOptions());
        //        } catch (MalformedURLException e) {
        //            e.printStackTrace();
        //        }
        driver = WebDriverFactory.createWebDriver(System.getProperty("browser.name"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
