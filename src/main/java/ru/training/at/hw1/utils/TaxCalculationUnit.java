package ru.training.at.hw1.utils;

import org.apache.commons.lang3.StringUtils;

public class TaxCalculationUnit {


    // method from external dependency is called here
    public static final String EXTERNAL_LIB_METHOD_USE =
            StringUtils.getCommonPrefix("abcd", "abc1");

    /**
     * Utility class should not be instantiable, so let's make constructor private.
     */
    private TaxCalculationUnit() {
        throw new UnsupportedOperationException();
    }

    public static double getIncomeTaxRate() {
        return 0.13d;
    }

    public static double calculateIncomeTaxValue(double income) {
        return income * getIncomeTaxRate();
    }
}
