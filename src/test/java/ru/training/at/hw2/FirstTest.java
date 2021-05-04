package ru.training.at.hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class FirstTest {

    private WebDriverWait webDriverWait;
    WebDriver webDriver;

    private WebElement webElement;

    @Test
    public void simpleTest() {
        System.setProperty("webdriver.chrome.driver", "");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.navigate().to("https://www.epam.com");
        webElement = webDriver.findElement(By.xpath("//span[text() = 'Home']"));
        webElement.click();
        webDriverWait = new WebDriverWait(webDriver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        assertEquals("EPAM | Enterprise Software Development, Design & Consulting",
                webDriver.getTitle());
    }

    @AfterMethod
    public void clear() {
        webDriver.close();
    }

}
