package ru.training.at.lesson3.java.googletest;

import com.epam.training.center.qa.at.lesson3.main.java.driverutils.DriverManager;
import com.epam.training.center.qa.at.lesson3.main.java.driverutils.GuiceDriverManager;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    private final Injector injector = Guice.createInjector(new GuiceDriverManager());

    @Inject
    public WebDriver webDriver;

    @Before
    public void prepareToTest() {
        injector.injectMembers(this);
//        webDriver = new DriverManager().setupDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDownDriver() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

}
