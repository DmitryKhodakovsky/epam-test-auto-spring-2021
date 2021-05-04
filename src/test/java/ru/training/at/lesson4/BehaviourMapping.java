package ru.training.at.lesson4;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import ru.training.at.lesson4.storynames.Epics;
import ru.training.at.lesson4.storynames.Features;
import ru.training.at.lesson4.storynames.Stories;

import static io.qameta.allure.Allure.step;

@Epic(Epics.FIRST_BIG_EPIC)
public class BehaviourMapping {
    @Test
    @Feature(Features.LOGIN)
    @Story(Stories.DEFAULT_LOGIN)
    @Story(Stories.LOGOUT)
    @Owner("Bob Ivanovich")
    public void testAlpha() {
        step("step");
    }

    @Test
    @Feature(Features.GET_QUESTION_LIST)
    @Story(Stories.DEFAULT_LOGIN)
    @Severity(SeverityLevel.BLOCKER)
    public void testBravo() {
        step("other step");
    }
}
