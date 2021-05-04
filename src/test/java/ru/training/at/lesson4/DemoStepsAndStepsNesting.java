package ru.training.at.lesson4;

import io.qameta.allure.Description;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.assertj.core.api.Assertions;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.training.at.lesson4.utils.AttachmentUtils;
import ru.training.at.lesson4.utils.LoginUtils;
import ru.training.at.lesson4.utils.PasswordStrengthValidationUtils;

import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DemoStepsAndStepsNesting {

    public static final String CAT_URL =
            "https://upload.wikimedia.org/wikipedia/commons/b/b6/Felis_catus-cat_on_snow.jpg";

    @BeforeMethod
    public void setUp(ITestContext context) {
        LoginUtils.loginWithDefaultUser();
        context.setAttribute("driver", "some driverText");
    }

    @Test
    public void testLogout() {
        LoginUtils.logout();
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void nullUserExceptionExpected() {
        LoginUtils.login(null);
    }

    @Test(expectedExceptions = NullPointerException.class)
    @Description("Lets try to expect wrong exception")
    public void testEmptyUser() {
        LoginUtils.login(LoginUtils.EMPTY_USER);
    }

    @Test
    public void test2x2is5() throws Exception {
        AttachmentUtils.attachPngImage(IOUtils.toByteArray(new URL(CAT_URL)), "'good cat'");
        Assertions.assertThat(2 * 2).isEqualTo(5);
    }

    @Test
    public void testDescriptionForCollectionParamsAndAttachments() {
        List<String> input = Arrays.asList("a", "aA", "aA9");
        AttachmentUtils.makeStringAttachment(input);

        List<String> actual = PasswordStrengthValidationUtils.filterBadPasswords(input);
        List<String> expected = Collections.singletonList("aA9");

        attachCatPicture();
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @SneakyThrows
    private void attachCatPicture() {
        try (InputStream is = new URL(CAT_URL).openStream()) {
            AttachmentUtils.attachFromInputStream("Everybody loves cat", is);
        }
    }

}
