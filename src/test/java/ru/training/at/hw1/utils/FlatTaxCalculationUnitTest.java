package ru.training.at.hw1.utils;

import org.testng.Assert;
import org.testng.annotations.Test;


public class FlatTaxCalculationUnitTest {

    @Test(groups = {Tags.BIG_AMOUNT, Tags.FLAT_TAX})
    public void flatTaxBigAmountTest() {
        double actual = TaxCalculationUnit.calculateIncomeTaxValue(10_000_000);
        double expected = 1_300_000;
        Assert.assertEquals(actual, expected);
    }

    @Test(groups = {Tags.SMALL_AMOUNT, Tags.FLAT_TAX})
    public void flatTaxSmallAmountTest() {
        double actual = TaxCalculationUnit.calculateIncomeTaxValue(0.27);
        double expected = 0.04;
        // actual is equals to 0.0351, but currency precision in real life of legal entity is 1 cent
        Assert.assertEquals(actual, expected, 0.01);
    }
}