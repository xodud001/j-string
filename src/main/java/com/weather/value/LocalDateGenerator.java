package com.weather.value;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Arrays;

public class LocalDateGenerator implements ValueGenerator {
    @Override
    public String generate(Class<?> type) {
        return String.format("\"%s\"", "9999-12-31");
    }

    @Override
    public boolean isSupported(Class<?> type) {
        return LocalDate.class.isAssignableFrom(type);
    }
}
