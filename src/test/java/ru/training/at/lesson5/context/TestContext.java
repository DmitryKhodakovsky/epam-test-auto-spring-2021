package ru.training.at.lesson5.context;

import java.util.HashMap;
import java.util.Map;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TestContext {

    public static final String WEB_DRIVER = "driver";
    public static final String PRODUCT_NAMES = "product_names";

    private static TestContext instance;

    private Map<String, Object> context = new HashMap<>();

    public void setTestObject(String key, Object object) {
        context.put(key, object);
    }

    public <T> T getTestObject(String key) {
        return (T) context.get(key);
    }

    public void cleanContext() {
        context.clear();
    }

    public static TestContext getInstance() {
        if (instance == null) {
            instance = new TestContext();
        }
        return instance;
    }
}
