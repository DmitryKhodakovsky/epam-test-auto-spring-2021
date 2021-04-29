package ru.training.at.lesson3.java.driverutils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager implements DriverInterface {
//public final class DriverManager {

    public static WebDriver driver;

    public WebDriver setupDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts()
                    .implicitlyWait(10, TimeUnit.SECONDS);
        }
        return driver;
    }

}