package ru.training.at.lesson4;


import io.qameta.allure.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;

public class DemoTestNamingAndDescription {

    @BeforeMethod
    public void setupNameless() {
        //nop
    }

    @BeforeMethod(description = "Setting up test env")
    public void setUpName() {
        step("setup name");
    }

    @Test
    public void testWithoutTestNameTakesNameFromMethod() {
        step("nop");
    }

    @Test(description = "This is test name (@Test)")
    @Description("This is test description (@Description)")
    public void descriptionAnnotationJavadocDescription() {
        step("step 1");
    }
}
