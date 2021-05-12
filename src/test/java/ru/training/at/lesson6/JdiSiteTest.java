package ru.training.at.lesson6;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static java.lang.String.format;

public class JdiSiteTest {

    public static final int EXPECTED_BENEFITS_COUNT = 4;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        PageFactory.initSite(JdiSite.class);
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        WebDriverUtils.killAllSeleniumDrivers();
    }

    @Test
    public void jdiHomepageBenefitsTest() {
        /*
         * 1. open home page
         * 2. check benefits count
         */
        JdiSite.open();
        int actualCount = JdiSite.jdiHomePage.getBenefitsCount();
        Assert.assertEquals(actualCount, EXPECTED_BENEFITS_COUNT,
                format("Expected benefits: %s, but actual: %s",
                        EXPECTED_BENEFITS_COUNT, actualCount));
    }
}
