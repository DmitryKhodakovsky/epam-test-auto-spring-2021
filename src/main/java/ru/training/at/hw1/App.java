package ru.training.at.hw1;

import ru.training.at.hw1.utils.TaxCalculationUnit;

public class App {
    public static void main(String[] args) {
        double income = Double.parseDouble(args[0]);
        double tax = TaxCalculationUnit.calculateIncomeTaxValue(income);

        System.out.printf("Your income tax is $ %.2f%n", tax);
    }
}
