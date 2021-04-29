package ru.training.at.lesson3.java.driverutils;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import org.openqa.selenium.WebDriver;

public class GuiceDriverManager extends AbstractModule {

    @Override
    protected void configure() {
        bind(DriverInterface.class)
                .to(DriverManager.class)
                .in(Scopes.SINGLETON);
    }

    @Provides
    public WebDriver getDriver(DriverManager driverManager) {
        return driverManager.setupDriver();
    }
}
