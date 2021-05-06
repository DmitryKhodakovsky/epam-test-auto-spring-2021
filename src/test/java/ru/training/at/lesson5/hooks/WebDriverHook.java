package ru.training.at.lesson5.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.training.at.lesson5.context.TestContext;

public class WebDriverHook {

    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        TestContext.getInstance().setTestObject(TestContext.WEB_DRIVER, driver);
    }

    @After
    public void tearDown() {
        driver.quit();
        TestContext.getInstance().cleanContext();
    }
}
