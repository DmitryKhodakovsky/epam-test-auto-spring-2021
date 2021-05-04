package ru.training.at.lesson4.utils;

import io.qameta.allure.Step;
import lombok.NonNull;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class PasswordStrengthValidationUtils {

    @Step("filtering out bad passwords: {passwords}")
    public List<String> filterBadPasswords(@NonNull final List<String> passwords) {
        return passwords.stream()
                .filter(x -> x.matches(".*[a-z].*"))
                .filter(x -> x.matches(".*[A-Z].*"))
                .filter(x -> x.matches(".*[0-9].*"))
                .collect(Collectors.toList());
    }
}
