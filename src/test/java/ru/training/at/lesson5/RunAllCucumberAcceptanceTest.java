package ru.training.at.lesson5;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/lesson5"})
public class RunAllCucumberAcceptanceTest extends AbstractTestNGCucumberTests {
}
