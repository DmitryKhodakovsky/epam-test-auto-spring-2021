package ru.training.at.hw1.utils;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.assertj.core.api.Assertions.within;


public class ProgressiveTaxCalculationUnitTest {

    public static final double COIN_DELTA = 0.01;

    // compare run when alwaysRun=false
    @BeforeGroups(groups = {Tags.BIG_AMOUNT}, alwaysRun = true)
    public void setUp() {
        System.out.println("before BIG_AMOUNT group");
    }

    @Test(groups = {Tags.BIG_AMOUNT, Tags.PROGRESSIVE_TAX})
    public void flatTaxBigAmountTest() {
        double actual = TaxCalculationUnit.calculateIncomeTaxValue(10_000_000);
        // 5m * 0.13 + 5m * 0.15
        double expected = 1_400_000;
        Assertions.assertThat(actual)
                .as("progressive tax for over 5m should be greater than flat tax")
                .isEqualTo(expected);
    }

    @Test(groups = {Tags.SMALL_AMOUNT, Tags.PROGRESSIVE_TAX})
    public void flatTaxSmallAmountTest() {
        double actual = TaxCalculationUnit.calculateIncomeTaxValue(0.27);
        double expected = 0.04;
        // actual is equals to 0.0351, but currency precision in real life of legal entity is 1 cent
        Assertions.assertThat(actual)
                .isCloseTo(expected, within(COIN_DELTA));
    }

    @Test(groups = {Tags.SOFT_ASSERTS})
    public void softAssertionInAssertjDemoTest() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(5).isEqualTo(5);
        softly.assertThat(7).as("looks like odd number").isEven();
        softly.assertThat("stringValue").isEqualToIgnoringCase("stringVALUE");
        softly.assertThat(true).as("demonstration only").isNotEqualTo(true);
        softly.assertAll();
    }

    @Test(groups = {Tags.SOFT_ASSERTS})
    public void softAssertInTestNgDemoTest() {
        SoftAssert softly = new SoftAssert();
        softly.assertEquals(5, 5);
        softly.assertEquals(5, 6, "five should not be equal to six");
        softly.assertTrue(false, "why not");
        softly.assertTrue(true);
        softly.assertAll("something went wrong :(");
    }
}