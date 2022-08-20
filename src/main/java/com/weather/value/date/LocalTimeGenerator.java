package com.weather.value.date;

import com.weather.value.ValueGenerator;

import java.time.LocalTime;

public class LocalTimeGenerator implements ValueGenerator {

    @Override
    public String generate(Class<?> type) {
        return String.format("\"%s\"", "12:00:00.123456");
    }

    @Override
    public boolean isSupported(Class<?> type) {
        return LocalTime.class.isAssignableFrom(type);
    }
}
