package com.weather.value;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeGenerator implements ValueGenerator {

    @Override
    public String generate(Class<?> type) {
        return String.format("\"%s\"", "9999-12-31T12:00:00.123456");
    }

    @Override
    public boolean isSupported(Class<?> type) {
        return LocalDateTime.class.isAssignableFrom(type);
    }
}
